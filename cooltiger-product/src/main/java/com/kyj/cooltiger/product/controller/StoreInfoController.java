package com.kyj.cooltiger.product.controller;

import com.kyj.cooltiger.common.constant.IMAGES_PATH;
import com.kyj.cooltiger.common.constant.PRODUCT_IMAGE_TYPE;
import com.kyj.cooltiger.common.excep.MyException;
import com.kyj.cooltiger.common.utils.CharUtil;
import com.kyj.cooltiger.common.utils.FileTypeUtil;
import com.kyj.cooltiger.common.utils.FtpUtil;
import com.kyj.cooltiger.common.utils.Result;
import com.kyj.cooltiger.feign.product.client.StoreInfoClient;
import com.kyj.cooltiger.feign.product.vo.StoreApplyIntoReqVo;
import com.kyj.cooltiger.feign.product.vo.StoreFreightVo;
import com.kyj.cooltiger.product.config.FtpConfig;
import com.kyj.cooltiger.product.service.StoreInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liduan
 * Description: 店铺信息controller
 * date: 2020/8/5 16:16
 */
@RestController
@RequestMapping("/product/storeInfo")
public class StoreInfoController implements StoreInfoClient {

    @Autowired
    private StoreInfoService storeInfoService;
    @Autowired
    private FtpConfig ftpConfig;

    /**
     * 生成店铺编码
     *
     * @return
     */
    @RequestMapping(value = "/getStoreCode", method = {RequestMethod.GET})
    public Result getStoreCode() {
        //生成店铺编码
        Map<String, Object> res = new HashMap<>();
        res.put("store_code", CharUtil.getRandomNum(8));
        return Result.success(res);
    }

    /**
     * 上传店铺图片
     *
     * @param storeCode 店铺编码
     * @param pic       图片
     * @param picType   图片类型（1-店铺logo2-身份证3-经营资质）
     * @return
     */
    @RequestMapping(value = "/uploadStorePic", method = {RequestMethod.POST})
    public Result uploadStorePic(
            @RequestParam("store_code") String storeCode,
            @RequestParam("pic") MultipartFile pic,
            @RequestParam("pic_type") Integer picType) {
        if (pic == null || pic.isEmpty()) {
            throw new MyException("PIC_NOT_NULL", "图片不能为空");
        }
        String oldName = pic.getOriginalFilename();
        if (!FileTypeUtil.isImageByName(oldName)) {
            throw new MyException("PIC_FORMAT_ERROR", "图片格式错误");
        }
        //生成新的图片名
        String newName = CharUtil.getImageName(25) + oldName.substring(oldName.lastIndexOf("."));
        //图片存放子目录
        StringBuilder filePath = new StringBuilder(IMAGES_PATH.STORE + "/" + storeCode);
        if (picType == PRODUCT_IMAGE_TYPE.INFO) {
            filePath.append(IMAGES_PATH.STORE_LOGO);
        } else if (picType == PRODUCT_IMAGE_TYPE.SKU) {
            filePath.append(IMAGES_PATH.ID_CARD);
        } else if (picType == PRODUCT_IMAGE_TYPE.DATAIL) {
            filePath.append(IMAGES_PATH.LICENSES);
        }
        //图片上传
        FtpUtil ftpUtil = new FtpUtil();
        boolean result = ftpUtil.uploadFile(ftpConfig.getHost(), ftpConfig.getPort(), ftpConfig.getUserName(),
                ftpConfig.getPassWord(), ftpConfig.getBasePath(), filePath.toString(), newName, pic);
        //响应信息
        Map<String, Object> res = new HashMap<>();
        if (result){
            res.put("pic_url", ftpConfig.getImageBaseUrl() + IMAGES_PATH.STORE + "/" + storeCode + IMAGES_PATH.STORE_LOGO + "/" + newName);
        }else {
            throw new MyException("PIC_UPLOAD_ERROR","图片上传失败");
        }
        return Result.success(res);
    }

    /**
     * 店铺申请入驻
     *
     * @param userId              申请人ID
     * @param storeApplyIntoReqVo 店铺基本信息
     * @return
     */
    @Override
    @RequestMapping(value = "/storeApplyInto", method = {RequestMethod.POST})
    public Result storeApplyInto(
            @RequestParam("user_id") Integer userId,
            @RequestBody StoreApplyIntoReqVo storeApplyIntoReqVo) {
        storeInfoService.addStoreIntoInfo(userId,storeApplyIntoReqVo);
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

    /**
     * 获取店铺运费信息
     *
     * @param storeId 店铺ID
     * @return
     */
    @RequestMapping(value = "/getStoreFreight", method = {RequestMethod.GET})
    public Result getStoreFreight(
            @RequestParam("store_id") Integer storeId) {
        Map<String, Object> res = storeInfoService.getStoreFreight(storeId);
        return Result.success(res.get("data"));
    }

    /**
     * 添加/修改店铺运费信息
     *
     * @param storeFreightVo 店铺运费信息
     * @return
     */
    @RequestMapping(value = "/editStoreFreight", method = {RequestMethod.POST})
    public Result editStoreFreight(
            @RequestBody StoreFreightVo storeFreightVo) {
        storeInfoService.editStoreFreight(storeFreightVo);
        return Result.success();
    }
}
