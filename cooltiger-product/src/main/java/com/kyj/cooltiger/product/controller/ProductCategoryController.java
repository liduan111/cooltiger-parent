package com.kyj.cooltiger.product.controller;

import com.kyj.cooltiger.common.constant.IMAGES_PATH;
import com.kyj.cooltiger.common.excep.MyException;
import com.kyj.cooltiger.common.utils.CharUtil;
import com.kyj.cooltiger.common.utils.FileTypeUtil;
import com.kyj.cooltiger.common.utils.FtpUtil;
import com.kyj.cooltiger.common.utils.Result;
import com.kyj.cooltiger.feign.product.client.ProductCategoryClient;
import com.kyj.cooltiger.product.config.FtpConfig;
import com.kyj.cooltiger.product.entity.ProductCategory;
import com.kyj.cooltiger.product.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * @author liduan
 * Description: 商品分类controller
 * date: 2020/8/10 13:07
 */
@RestController
@RequestMapping("/product/productCategory")
public class ProductCategoryController implements ProductCategoryClient {

    @Autowired
    private ProductCategoryService productCategoryService;
    @Autowired
    private FtpConfig ftpConfig;

    /**
     * 添加商品分类
     *
     * @param categoryName     分类名称
     * @param categoryParentId 父分类ID(0:一级分类）
     * @param categoryLevel    分类等级（0-一级分类1-二级分类2-三级分类）
     * @param categoryLogo     分类图片logo
     * @return
     */
    @Override
    @RequestMapping(value = "/addProductCategory", method = {RequestMethod.POST})
    public Result addProductCategory(
            @RequestParam("category_name") String categoryName,
            @RequestParam(value = "category_parent_id", defaultValue = "0") Integer categoryParentId,
            @RequestParam(value = "category_level", defaultValue = "0") Integer categoryLevel,
            @RequestParam(value = "category_logo", required = false) MultipartFile categoryLogo) {
        //如果图片为空直接添加
        if (categoryLogo == null || categoryLogo.isEmpty()) {
            productCategoryService.addProductCategory(categoryName, categoryParentId, categoryLevel, null);
        }else {
            //根据文件名字判断文件类型
            String oldName = categoryLogo.getOriginalFilename();
            if (!FileTypeUtil.isImageByName(oldName)) {
                throw new MyException("PICTURE_FORMAT_ERROR", "图片格式错误");
            }
            //生成新的图片名
            String newName = CharUtil.getImageName(25) + oldName.substring(oldName.lastIndexOf("."));
            //添加
            productCategoryService.addProductCategory(categoryName, categoryParentId, categoryLevel,
                    ftpConfig.getImageBaseUrl() + IMAGES_PATH.CATEGORY_LOGO + "/" + newName);
            //上传图片
            FtpUtil ftpUtil = new FtpUtil();
            boolean result = ftpUtil.uploadFile(ftpConfig.getHost(), ftpConfig.getPort(), ftpConfig.getUserName(),
                    ftpConfig.getPassWord(), ftpConfig.getBasePath(), IMAGES_PATH.CATEGORY_LOGO, newName, categoryLogo);
            if (!result) {
                throw new MyException("PICTURE_UPLOAD_ERROR", "图片上传失败");
            }
        }
        return Result.success();
    }

    /**
     * 查询商品分类列表信息
     *
     * @param categoryParentId 父分类ID(0:一级分类）
     * @param categoryLevel    分类等级（0-一级分类1-二级分类2-三级分类）
     * @return
     */
    @Override
    @RequestMapping(value = "/productCategoryList", method = {RequestMethod.GET})
    public Result productCategoryList(
            @RequestParam(value = "category_parent_id", required = false) Integer categoryParentId,
            @RequestParam(value = "category_level", required = false) Integer categoryLevel) {
        Map<String, Object> resMap = productCategoryService.getProductCategoryList(categoryParentId,categoryLevel);
        return Result.success(resMap.get("data"));
    }

    /**
     * 修改商品分类
     *
     * @param categoryId   分类ID
     * @param categoryName 分类名称
     * @return
     */
    @Override
    @RequestMapping(value = "/updateProductCategory", method = {RequestMethod.PUT})
    public Result updateProductCategory(
            @RequestParam(value = "category_id") Integer categoryId,
            @RequestParam(value = "category_name") String categoryName) {
        productCategoryService.updateProductCategory(categoryId, categoryName, null);
        return Result.success();
    }

    /**
     * 删除商品分类信息
     *
     * @param categoryId 分类ID
     * @return
     */
    @Override
    @RequestMapping(value = "/delProductCategory", method = {RequestMethod.DELETE})
    public Result delProductCategory(
            @RequestParam(value = "category_id") Integer categoryId) {
        //查询分类信息
        ProductCategory productCategory = productCategoryService.getProductCategoryByCategoryId(categoryId);
        //图片url存在则删除
        if (productCategory.getCategoryLogoUrl() != null && productCategory.getCategoryLogoUrl() != "") {
            String fileName = productCategory.getCategoryLogoUrl().substring(productCategory.getCategoryLogoUrl().lastIndexOf("/") + 1);
            //调用FtpUtil工具类删除图片
            FtpUtil ftpUtil = new FtpUtil();
            ftpUtil.deleteFile(ftpConfig.getHost(), ftpConfig.getPort(), ftpConfig.getUserName(),
                    ftpConfig.getPassWord(), ftpConfig.getBasePath() + IMAGES_PATH.CATEGORY_LOGO, fileName);
        }
        productCategoryService.delProductCategory(categoryId);
        return Result.success();
    }

    /**
     * 更换分类logo
     *
     * @param categoryId   分类ID
     * @param categoryLogo 分类Logo
     * @return
     */
    @Override
    @RequestMapping(value = "/updateCategoryLogo",method = {RequestMethod.PUT})
    public Result updateCategoryLogo(
            @RequestParam("category_id") Integer categoryId,
            @RequestParam("category_logo") MultipartFile categoryLogo){
        //查询分类信息
        ProductCategory productCategory = productCategoryService.getProductCategoryByCategoryId(categoryId);
        //图片url存在则删除
        if (productCategory.getCategoryLogoUrl() != null && productCategory.getCategoryLogoUrl() != "") {
            String fileName = productCategory.getCategoryLogoUrl().substring(productCategory.getCategoryLogoUrl().lastIndexOf("/") + 1);
            //调用FtpUtil工具类删除图片
            FtpUtil ftpUtil = new FtpUtil();
            ftpUtil.deleteFile(ftpConfig.getHost(), ftpConfig.getPort(), ftpConfig.getUserName(),
                    ftpConfig.getPassWord(), ftpConfig.getBasePath() + IMAGES_PATH.CATEGORY_LOGO, fileName);
        }
        //更换新图片
        //根据文件名字判断文件类型
        String oldName = categoryLogo.getOriginalFilename();
        if (!FileTypeUtil.isImageByName(oldName)) {
            throw new MyException("PICTURE_FORMAT_ERROR", "图片格式错误");
        }
        //生成新的图片名
        String newName = CharUtil.getImageName(25) + oldName.substring(oldName.lastIndexOf("."));
        //添加
        productCategoryService.updateProductCategory(categoryId, productCategory.getCategoryName(),
                ftpConfig.getImageBaseUrl() + IMAGES_PATH.CATEGORY_LOGO + "/" + newName);
        //上传图片
        FtpUtil ftpUtil = new FtpUtil();
        boolean result = ftpUtil.uploadFile(ftpConfig.getHost(), ftpConfig.getPort(), ftpConfig.getUserName(),
                ftpConfig.getPassWord(), ftpConfig.getBasePath(), IMAGES_PATH.CATEGORY_LOGO, newName, categoryLogo);
        if (!result) {
            throw new MyException("PICTURE_UPLOAD_ERROR", "图片上传失败");
        }
        return Result.success();
    }

}
