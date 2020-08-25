package com.kyj.cooltiger.product.controller;

import com.kyj.cooltiger.common.constant.IMAGES_PATH;
import com.kyj.cooltiger.common.excep.MyException;
import com.kyj.cooltiger.common.utils.*;
import com.kyj.cooltiger.feign.product.client.CountryRegionClient;
import com.kyj.cooltiger.product.config.FtpConfig;
import com.kyj.cooltiger.product.entity.CountryRegion;
import com.kyj.cooltiger.product.service.CountryRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * @author liduan
 * Description: 国家地区controller
 * date: 2020/8/13 13:35
 */
@RestController
@RequestMapping("/product/countryRegion")
public class CountryRegionController implements CountryRegionClient {

    @Autowired
    private CountryRegionService countryRegionService;
    @Autowired
    private FtpConfig ftpConfig;


    /**
     * 添加国家地区信息
     *
     * @param parentId   地区父ID
     * @param regionName 地区名称
     * @param regionCode 地区行政编码
     * @param upFile     国旗
     * @return
     */
    @Override
    @RequestMapping(value = "/addCountryRegion", method = {RequestMethod.POST})
    public Result addCountryRegion(
            @RequestParam("parent_id") Integer parentId,
            @RequestParam("region_name") String regionName,
            @RequestParam(value = "region_code", required = false) String regionCode,
            @RequestParam(value = "pict", required = false) MultipartFile upFile) {
        //如果图片为空直接添加
        if (upFile == null || upFile.isEmpty()) {
            countryRegionService.addCountryRegion(parentId, regionName, regionCode, null);
        } else {
            //1、给上传的图片生成新的文件名
            //1.1获取原始文件名
            String oldName = upFile.getOriginalFilename();
            //1.1.1根据文件名字判断是否为图片，支持（jpg png gif bmp）
            if (!FileTypeUtil.isImageByName(oldName)) {
                throw new MyException("PICTURE_FORMAT_ERROR", "图片格式错误");
            }
            //1.2使用CharUtil工具类生成新图片名（时间戳+随机字符串）+ 后缀名
            String newName = CharUtil.getImageName(25) + oldName.substring(oldName.lastIndexOf("."));

            //2、把前端输入信息，包括图片的url保存到数据库
            countryRegionService.addCountryRegion(parentId, regionName, regionCode,
                    ftpConfig.getImageBaseUrl() + IMAGES_PATH.NATIONAL_FLAG + "/" + newName);
            //3、调用FtpUtil工具类上传图片
            FtpUtil ftpUtil = new FtpUtil();
            boolean result = ftpUtil.uploadFile(ftpConfig.getHost(), ftpConfig.getPort(), ftpConfig.getUserName(),
                    ftpConfig.getPassWord(), ftpConfig.getBasePath(), IMAGES_PATH.NATIONAL_FLAG, newName, upFile);
            if (!result) {
                throw new MyException("PICTURE_UPLOAD_ERROR", "图片上传失败");
            }
        }
        return Result.success();
    }

    /**
     * 查询国家地区列表
     *
     * @param parentId 地区父ID
     * @return
     */
    @Override
    @RequestMapping(value = "/getCountryRegion", method = {RequestMethod.GET})
    public Result getCountryRegion(
            @RequestParam("parent_id") Integer parentId) {
        Map<String, Object> res = countryRegionService.getCountryRegion(parentId);
        return Result.success(res.get("data"));
    }

    /**
     * 修改国家地区信息
     *
     * @param regionId   地区ID
     * @param regionName 地区名称
     * @param regionCode 地区行政编码
     * @return
     */
    @Override
    @RequestMapping(value = "/updateCountryRegion", method = {RequestMethod.PUT})
    public Result updateCountryRegion(
            @RequestParam("region_id") Integer regionId,
            @RequestParam("region_name") String regionName,
            @RequestParam(value = "region_code", required = false) String regionCode) {
        countryRegionService.updateCountryRegion(regionId, regionName, regionCode, null);
        return Result.success();
    }

    /**
     * 删除国家地区信息
     *
     * @param regionId 地区ID
     * @return
     */
    @Override
    @RequestMapping(value = "/delCountryRegion", method = {RequestMethod.DELETE})
    public Result delCountryRegion(@RequestParam("region_id") Integer regionId) {
        //获取图片名
        CountryRegion countryRegion = countryRegionService.getCountryRegionByRegionId(regionId);
        //图片存在则删除
        if (countryRegion.getNationalFlagUrl() != null && countryRegion.getNationalFlagUrl() != "") {
            String fileName = countryRegion.getNationalFlagUrl().substring(countryRegion.getNationalFlagUrl().lastIndexOf("/") + 1);
            //调用FtpUtil工具类删除图片
            FtpUtil ftpUtil = new FtpUtil();
            ftpUtil.deleteFile(ftpConfig.getHost(), ftpConfig.getPort(), ftpConfig.getUserName(),
                    ftpConfig.getPassWord(), ftpConfig.getBasePath() + IMAGES_PATH.NATIONAL_FLAG, fileName);
        }
        //删除数据库
        countryRegionService.delCountryRegion(regionId);
        return Result.success();
    }

    /**
     * 更改国旗图片
     *
     * @param regionId
     * @param upFile
     * @return
     */
    @Override
    @RequestMapping(value = "/updateNationalFlag", method = {RequestMethod.PUT})
    public Result updateNationalFlag(
            @RequestParam("region_id") Integer regionId,
            @RequestParam("pict") MultipartFile upFile) {
        //删除旧图片
        //获取地区信息
        CountryRegion countryRegion = countryRegionService.getCountryRegionByRegionId(regionId);
        //图片存在则删除
        if (countryRegion.getNationalFlagUrl() != null && countryRegion.getNationalFlagUrl() != "") {
            String fileName = countryRegion.getNationalFlagUrl().substring(countryRegion.getNationalFlagUrl().lastIndexOf("/") + 1);
            //调用FtpUtil工具类删除图片
            FtpUtil ftpUtil = new FtpUtil();
            ftpUtil.deleteFile(ftpConfig.getHost(), ftpConfig.getPort(), ftpConfig.getUserName(),
                    ftpConfig.getPassWord(), ftpConfig.getBasePath() + IMAGES_PATH.NATIONAL_FLAG, fileName);
        }
        //添加信息图片
        //1、给上传的图片生成新的文件名
        //1.1获取原始文件名
        String oldName = upFile.getOriginalFilename();
        //1.1.1根据文件名字判断是否为图片，支持（jpg png gif bmp）
        if (!FileTypeUtil.isImageByName(oldName)) {
            throw new MyException("PICTURE_FORMAT_ERROR", "图片格式错误");
        }
        //1.2使用CharUtil工具类生成新图片名（时间戳+随机字符串）+ 后缀名
        String newName = CharUtil.getImageName(25) + oldName.substring(oldName.lastIndexOf("."));

        //2、把新的图片url保存到数据库
        countryRegionService.updateCountryRegion(regionId, countryRegion.getRegionName(), countryRegion.getRegionCode(),
                ftpConfig.getImageBaseUrl() + IMAGES_PATH.NATIONAL_FLAG + "/" + newName);
        //3、调用FtpUtil工具类上传图片
        FtpUtil ftpUtil = new FtpUtil();
        boolean result = ftpUtil.uploadFile(ftpConfig.getHost(), ftpConfig.getPort(), ftpConfig.getUserName(),
                ftpConfig.getPassWord(), ftpConfig.getBasePath(), IMAGES_PATH.NATIONAL_FLAG, newName, upFile);
        if (!result) {
            throw new MyException("PICTURE_UPLOAD_ERROR", "图片上传失败");
        }
        return Result.success();
    }
}
