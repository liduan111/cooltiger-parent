package com.kyj.cooltiger.product.controller;

import com.kyj.cooltiger.common.constant.IMAGES_PATH;
import com.kyj.cooltiger.common.excep.MyException;
import com.kyj.cooltiger.common.utils.CharUtil;
import com.kyj.cooltiger.common.utils.FileTypeUtil;
import com.kyj.cooltiger.common.utils.FtpUtil;
import com.kyj.cooltiger.common.utils.Result;
import com.kyj.cooltiger.feign.product.client.ProductBrandInfoClient;
import com.kyj.cooltiger.product.config.FtpConfig;
import com.kyj.cooltiger.product.entity.ProductBrandInfo;
import com.kyj.cooltiger.product.service.ProductBrandInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * @author liduan
 * Description: 商品品牌信息controller
 * date: 2020/8/11 14:50
 */
@RestController
@RequestMapping("/product/productBrandInfo")
public class ProductBrandInfoController implements ProductBrandInfoClient {

    @Autowired
    private ProductBrandInfoService productBrandInfoService;
    @Autowired
    private FtpConfig ftpConfig;

    /**
     * 添加品牌信息
     *
     * @param brandName   品牌名称
     * @param brandDesc   品牌描述
     * @param brandOrder  排序
     * @param brandStatus 品牌状态 0-未启用1-启用
     * @param brandLogo   品牌logo
     * @return
     */
    @Override
    @RequestMapping(value = "/addProductBrandInfo", method = {RequestMethod.POST})
    public Result addProductBrandInfo(
            @RequestParam("brand_name") String brandName,
            @RequestParam(value = "brand_desc", required = false) String brandDesc,
            @RequestParam(value = "brand_order", defaultValue = "0") Integer brandOrder,
            @RequestParam(value = "brand_status", defaultValue = "1") Integer brandStatus,
            @RequestParam(value = "brand_logo", required = false) MultipartFile brandLogo) {
        //如果logo为空直接添加数据
        if (brandLogo == null || brandLogo.isEmpty()) {
            productBrandInfoService.addProductBrandInfo(brandName, brandDesc, brandOrder, brandStatus, null);
        } else {
            //1、给上传的图片生成新的文件名
            //1.1获取原始文件名
            String oldName = brandLogo.getOriginalFilename();
            //1.1.1根据文件名字判断是否为图片，支持（jpg png gif bmp）
            if (!FileTypeUtil.isImageByName(oldName)) {
                throw new MyException("PICTURE_FORMAT_ERROR", "图片格式错误");
            }
            //1.2使用CharUtil工具类生成新图片名（时间戳+随机字符串）+ 后缀名
            String newName = CharUtil.getImageName(25) + oldName.substring(oldName.lastIndexOf("."));

            //2、把前端输入信息，包括图片的url保存到数据库
            productBrandInfoService.addProductBrandInfo(brandName, brandDesc, brandOrder, brandStatus,
                    ftpConfig.getImageBaseUrl() + IMAGES_PATH.BRAND_LOGO + "/" + newName);
            //3、调用FtpUtil工具类上传图片
            FtpUtil ftpUtil = new FtpUtil();
            boolean result = ftpUtil.uploadFile(ftpConfig.getHost(), ftpConfig.getPort(), ftpConfig.getUserName(),
                    ftpConfig.getPassWord(), ftpConfig.getBasePath(), IMAGES_PATH.BRAND_LOGO, newName, brandLogo);
            if (!result) {
                throw new MyException("PICTURE_UPLOAD_ERROR", "图片上传失败");
            }
        }
        return Result.success();
    }

    /**
     * 查询品牌列表信息
     *
     * @param pageNo
     * @param pageSize
     * @param keyword
     * @return
     */
    @RequestMapping(value = "/getProductBrandInfoList", method = {RequestMethod.GET})
    public Result getProductBrandInfoList(
            @RequestParam(value = "page_no", defaultValue = "1") Integer pageNo,
            @RequestParam(value = "page_size", defaultValue = "10") Integer pageSize,
            @RequestParam(value = "keyword", required = false) String keyword) {
        Map<String, Object> res = productBrandInfoService.getProductBrandInfoList(pageNo, pageSize, keyword);
        return Result.success(res);
    }

    /**
     * 修改商品品牌信息
     *
     * @param brandId     品牌ID
     * @param brandName   品牌名称
     * @param brandDesc   品牌描述
     * @param brandOrder  排序
     * @param brandStatus 品牌状态 0-未启用1-已启用
     * @return
     */
    @RequestMapping(value = "/updateProductBrandInfo", method = {RequestMethod.PUT})
    public Result updateProductBrandInfo(
            @RequestParam("brand_id") Integer brandId,
            @RequestParam("brand_name") String brandName,
            @RequestParam(value = "brand_desc", required = false) String brandDesc,
            @RequestParam(value = "brand_order", defaultValue = "0") Integer brandOrder,
            @RequestParam(value = "brand_status", defaultValue = "1") Integer brandStatus) {
        productBrandInfoService.updateProductBrandInfo(brandId, brandName, brandDesc, brandOrder, brandStatus, null);
        return Result.success();
    }

    /**
     * 删除品牌信息
     *
     * @param brandId 品牌ID
     * @return
     */
    @RequestMapping(value = "/delProductBrandInfo", method = {RequestMethod.DELETE})
    public Result delProductBrandInfo(
            @RequestParam("brand_id") Integer brandId) {
        //获取品牌信息
        ProductBrandInfo productBrandInfo = productBrandInfoService.getProductBrandInfo(brandId);
        if (productBrandInfo.getBrandLogoUrl() != null && productBrandInfo.getBrandLogoUrl() != "") {
            String fileName = productBrandInfo.getBrandLogoUrl().substring(productBrandInfo.getBrandLogoUrl().lastIndexOf("/") + 1);
            //调用FtpUtil工具类删除图片
            FtpUtil ftpUtil = new FtpUtil();
            ftpUtil.deleteFile(ftpConfig.getHost(), ftpConfig.getPort(), ftpConfig.getUserName(),
                    ftpConfig.getPassWord(), ftpConfig.getBasePath() + IMAGES_PATH.BRAND_LOGO, fileName);
        }
        //删除数据库数据
        productBrandInfoService.delProductBrandInfo(brandId);
        return Result.success();
    }

    /**
     * 更换品牌logo图片
     *
     * @param brandId   品牌ID
     * @param brandLogo 品牌logo
     * @return
     */
    @Override
    @RequestMapping(value = "/updateBrandLogo", method = {RequestMethod.PUT})
    public Result updateBrandLogo(
            @RequestParam("brand_id") Integer brandId,
            @RequestParam(value = "brand_logo") MultipartFile brandLogo) {
        //获取品牌信息
        ProductBrandInfo productBrandInfo = productBrandInfoService.getProductBrandInfo(brandId);
        //删除服务器图片
        if (productBrandInfo.getBrandLogoUrl() != null && productBrandInfo.getBrandLogoUrl() != "") {
            String fileName = productBrandInfo.getBrandLogoUrl().substring(productBrandInfo.getBrandLogoUrl().lastIndexOf("/") + 1);
            //调用FtpUtil工具类删除图片
            FtpUtil ftpUtil = new FtpUtil();
            ftpUtil.deleteFile(ftpConfig.getHost(), ftpConfig.getPort(), ftpConfig.getUserName(),
                    ftpConfig.getPassWord(), ftpConfig.getBasePath() + IMAGES_PATH.BRAND_LOGO, fileName);
        }
        //更换新图片
        //1、给上传的图片生成新的文件名
        //1.1获取原始文件名
        String oldName = brandLogo.getOriginalFilename();
        //1.1.1根据文件名字判断是否为图片，支持（jpg png gif bmp）
        if (!FileTypeUtil.isImageByName(oldName)) {
            throw new MyException("PICTURE_FORMAT_ERROR", "图片格式错误");
        }
        //1.2使用CharUtil工具类生成新图片名（时间戳+随机字符串）+ 后缀名
        String newName = CharUtil.getImageName(25) + oldName.substring(oldName.lastIndexOf("."));

        //2、更新数据到数据库
        productBrandInfoService.updateProductBrandInfo(brandId, productBrandInfo.getBrandName(),
                productBrandInfo.getBrandDesc(), productBrandInfo.getBrandOrder(), productBrandInfo.getBrandStatus(),
                ftpConfig.getImageBaseUrl() + IMAGES_PATH.BRAND_LOGO + "/" + newName);
        //3、调用FtpUtil工具类上传图片
        FtpUtil ftpUtil = new FtpUtil();
        boolean result = ftpUtil.uploadFile(ftpConfig.getHost(), ftpConfig.getPort(), ftpConfig.getUserName(),
                ftpConfig.getPassWord(), ftpConfig.getBasePath(), IMAGES_PATH.BRAND_LOGO, newName, brandLogo);
        if (!result) {
            throw new MyException("PICTURE_UPLOAD_ERROR", "图片上传失败");
        }
        return Result.success();
    }
}
