package com.kyj.cooltiger.product.controller;

import com.kyj.cooltiger.common.constant.IMAGES_PATH;
import com.kyj.cooltiger.common.excep.MyException;
import com.kyj.cooltiger.common.utils.CharUtil;
import com.kyj.cooltiger.common.utils.FileTypeUtil;
import com.kyj.cooltiger.common.utils.FtpUtil;
import com.kyj.cooltiger.common.utils.Result;
import com.kyj.cooltiger.feign.product.client.StoreInfoClient;
import com.kyj.cooltiger.feign.product.vo.StoreApplyIntoReqVo;
import com.kyj.cooltiger.product.config.FtpConfig;
import com.kyj.cooltiger.product.service.StoreInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author liduan
 * Description: 店铺信息controller
 * date: 2020/8/5 16:16
 */
@RestController
@RequestMapping("/store/storeInfo")
public class StoreInfoController implements StoreInfoClient {

    @Autowired
    private StoreInfoService storeInfoService;
    @Autowired
    private FtpConfig ftpConfig;

    /**
     * 店铺申请入驻
     *
     * @param userId              申请人ID
     * @param storeLogo           店铺Logo
     * @param idCardMain          身份证正面照片
     * @param idCardBack          身份证反面照片
     * @param licenses            经营资质照片
     * @param storeApplyIntoReqVo 店铺基本信息
     * @return
     */
    @Override
    @RequestMapping(value = "/storeApplyInto", method = {RequestMethod.POST})
    public Result storeApplyInto(
            @RequestParam("user_id") Integer userId,
            @RequestParam("store_logo") MultipartFile storeLogo,
            @RequestParam("id_card_main") MultipartFile idCardMain,
            @RequestParam("id_card_back") MultipartFile idCardBack,
            @RequestParam("licenses") MultipartFile[] licenses,
            StoreApplyIntoReqVo storeApplyIntoReqVo) {
        //店铺logo图片名字
        String storeLogoOldName = null;
        //身份证图片名字
        String idCardMainOldName = null;
        String idCardBackOldName = null;
        //验证图片
        //店铺logo
        if (storeLogo != null && !storeLogo.isEmpty()) {
            storeLogoOldName = storeLogo.getOriginalFilename();
            if (!FileTypeUtil.isImageByName(storeLogoOldName)) {
                throw new MyException("STORE_LOGO_FORMAT_ERROR", "店铺Logo图片格式错误");
            }
        } else {
            throw new MyException("STORE_LOGO_NOT_NULL", "店铺Logo不能为空");
        }
        //身份证
        if (idCardMain != null && !idCardMain.isEmpty() &&
                idCardBack != null && !idCardBack.isEmpty()) {
            idCardMainOldName = idCardMain.getOriginalFilename();
            idCardBackOldName = idCardBack.getOriginalFilename();
            if (!FileTypeUtil.isImageByName(idCardMainOldName) || !FileTypeUtil.isImageByName(idCardBackOldName)) {
                throw new MyException("PICTURE_FORMAT_ERROR", "身份证图片格式错误");
            }
        } else {
            throw new MyException("ID_CARD_NOT_NULL", "身份证不能为空");
        }
        //经营资质图片
        if (licenses != null && licenses.length > 0) {
            for (MultipartFile license : licenses) {
                if (!FileTypeUtil.isImageByName(license.getOriginalFilename())) {
                    throw new MyException("LICENSE_FORMAT_ERROR", "经营资质图片格式错误");
                }
            }
        }
        //生成新的图片名
        String storeLogoNewName = CharUtil.getImageName(25) + storeLogoOldName.substring(storeLogoOldName.lastIndexOf("."));
        String idCardMainNewName = CharUtil.getImageName(25) + idCardMainOldName.substring(idCardMainOldName.lastIndexOf("."));
        String idCardBackNewName = CharUtil.getImageName(25) + idCardBackOldName.substring(idCardBackOldName.lastIndexOf("."));
        //生成店铺编码
        String storeCode = CharUtil.getRandomNum(8);
        //图片上传工具类
        FtpUtil ftpUtil = new FtpUtil();
        //上传图片信息的集合
        List<FtpUtil.FileInfo> fileInfos = new ArrayList<>();
        FtpUtil.FileInfo fileInfo = null;
        //店铺logo
        fileInfo = ftpUtil.new FileInfo();
        fileInfo.setBasePath(ftpConfig.getBasePath());
        fileInfo.setFilePath(IMAGES_PATH.STORE + "/" + storeCode + IMAGES_PATH.STORE_LOGO);
        fileInfo.setFileName(storeLogoNewName);
        fileInfo.setUpFile(storeLogo);
        fileInfos.add(fileInfo);
        //身份证正面
        fileInfo = ftpUtil.new FileInfo();
        fileInfo.setBasePath(ftpConfig.getBasePath());
        fileInfo.setFilePath(IMAGES_PATH.STORE + "/" + storeCode + IMAGES_PATH.ID_CARD);
        fileInfo.setFileName(idCardMainNewName);
        fileInfo.setUpFile(idCardMain);
        fileInfos.add(fileInfo);
        //身份证反面
        fileInfo = ftpUtil.new FileInfo();
        fileInfo.setBasePath(ftpConfig.getBasePath());
        fileInfo.setFilePath(IMAGES_PATH.STORE + "/" + storeCode + IMAGES_PATH.ID_CARD);
        fileInfo.setFileName(idCardBackNewName);
        fileInfo.setUpFile(idCardBack);
        fileInfos.add(fileInfo);
        //经营资质图片
        List<String> licenseUrls = null;
        if (licenses != null && licenses.length > 0) {
            licenseUrls = new ArrayList<>();
            for (MultipartFile license : licenses) {
                String licenseOldName = license.getOriginalFilename();
                String licenseNewName = CharUtil.getImageName(25) + licenseOldName.substring(licenseOldName.lastIndexOf("."));
                fileInfo = ftpUtil.new FileInfo();
                fileInfo.setBasePath(ftpConfig.getBasePath());
                fileInfo.setFilePath(IMAGES_PATH.STORE + "/" + storeCode + IMAGES_PATH.LICENSES);
                fileInfo.setFileName(licenseNewName);
                fileInfo.setUpFile(license);
                fileInfos.add(fileInfo);
                licenseUrls.add(ftpConfig.getImageBaseUrl() + IMAGES_PATH.STORE + "/" + storeCode + IMAGES_PATH.LICENSES + "/" + licenseNewName);
            }
        }
        //添加到数据库
        storeInfoService.addStoreIntoInfo(userId, storeCode,
                ftpConfig.getImageBaseUrl() + IMAGES_PATH.STORE + "/" + storeCode + IMAGES_PATH.STORE_LOGO + "/" + storeLogoNewName,
                ftpConfig.getImageBaseUrl() + IMAGES_PATH.STORE + "/" + storeCode + IMAGES_PATH.ID_CARD + "/" + idCardMainNewName,
                ftpConfig.getImageBaseUrl() + IMAGES_PATH.STORE + "/" + storeCode + IMAGES_PATH.ID_CARD + "/" + idCardBackNewName,
                licenseUrls, storeApplyIntoReqVo);
        //图片批量上传
        int num = ftpUtil.uploadBatchFile(ftpConfig.getHost(), ftpConfig.getPort(), ftpConfig.getUserName(), ftpConfig.getPassWord(), fileInfos);
        return Result.success();
    }

    /**
     * 查询店铺列表
     *
     * @param pageNo   当前页
     * @param pageSize 分页单位
     * @param keyword  搜索关键字
     * @return
     */
    @Override
    @RequestMapping(value = "/getStoreList", method = {RequestMethod.GET})
    public Result getStoreList(
            @RequestParam(value = "page_no", defaultValue = "1") Integer pageNo,
            @RequestParam(value = "page_size", defaultValue = "10") Integer pageSize,
            @RequestParam(value = "keyword", required = false) String keyword) {
        Map<String, Object> resMap = storeInfoService.getStoreList(pageNo, pageSize, keyword);
        return Result.success(resMap);
    }

    /**
     * 查询店铺信息
     *
     * @param storeId 店铺ID
     * @return
     */
    @Override
    @RequestMapping(value = "/getStoreInfo", method = {RequestMethod.GET})
    public Result getStoreInfo(
            @RequestParam("store_id") Integer storeId) {
        Map<String, Object> resMap = storeInfoService.getStoreInfo(storeId);
        return Result.success(resMap.get("data"));
    }

    /**
     * 店铺信息审核
     *
     * @param storeId     店铺ID
     * @param auditStatus 审核结果（1-审核通过2-审核未通过）
     * @return
     */
    @Override
    @RequestMapping(value = "/storeInfoAudit", method = {RequestMethod.PUT})
    public Result storeInfoAudit(
            @RequestParam("store_id") Integer storeId,
            @RequestParam("audit_status") Integer auditStatus) {
        storeInfoService.storeInfoAudit(storeId, auditStatus);
        return Result.success();
    }

    /**
     * 修改店铺信息
     *
     * @param storeId             店铺ID
     * @param storeApplyIntoReqVo 店铺信息
     * @return
     */
    @Override
    @RequestMapping(value = "/updateStoreInfo", method = {RequestMethod.PUT})
    public Result updateStoreInfo(
            @RequestParam("store_id") Integer storeId,
            @RequestBody StoreApplyIntoReqVo storeApplyIntoReqVo) {
        storeInfoService.updateStoreInfo(storeId, storeApplyIntoReqVo);
        return Result.success();
    }
}
