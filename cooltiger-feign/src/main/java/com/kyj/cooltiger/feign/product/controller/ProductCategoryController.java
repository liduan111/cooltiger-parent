package com.kyj.cooltiger.feign.product.controller;

import com.kyj.cooltiger.common.utils.Result;
import com.kyj.cooltiger.feign.product.client.ProductCategoryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author liduan
 * Description: 商品分类controller
 * date: 2020/8/24 14:11
 */
@RestController
@RequestMapping("/product/productCategory")
public class ProductCategoryController {

    @Autowired
    private ProductCategoryClient productCategoryClient;

    /**
     * 添加商品分类
     *
     * @param categoryName     分类名称
     * @param categoryParentId 父分类ID(0:一级分类）
     * @param categoryLevel    分类等级（0-一级分类1-二级分类2-三级分类）
     * @param categoryLogo     分类图片logo
     * @return
     */
    @RequestMapping(value = "/addProductCategory", method = {RequestMethod.POST})
    public Result addProductCategory(
            @RequestParam("category_name") String categoryName,
            @RequestParam(value = "category_parent_id", defaultValue = "0") Integer categoryParentId,
            @RequestParam(value = "category_level", defaultValue = "0") Integer categoryLevel,
            @RequestParam(value = "category_logo", required = false) MultipartFile categoryLogo) {
        return productCategoryClient.addProductCategory(categoryName, categoryParentId, categoryLevel, categoryLogo);
    }

    /**
     * 查询商品分类列表信息
     *
     * @param categoryParentId 父分类ID(0:一级分类）
     * @param categoryLevel    分类等级（0-一级分类1-二级分类2-三级分类）
     * @return
     */
    @RequestMapping(value = "/productCategoryList", method = {RequestMethod.GET})
    public Result productCategoryList(
            @RequestParam(value = "category_parent_id", required = false) Integer categoryParentId,
            @RequestParam(value = "category_level", required = false) Integer categoryLevel) {
        return productCategoryClient.productCategoryList(categoryParentId, categoryLevel);
    }

    /**
     * 修改商品分类
     *
     * @param categoryId   分类ID
     * @param categoryName 分类名称
     * @param logoUpdate   是否修改logo(0-未更换图片1-更换图片)
     * @param categoryLogo 分类logo
     * @return
     */
    @RequestMapping(value = "/updateProductCategory", method = {RequestMethod.PUT})
    public Result updateProductCategory(
            @RequestParam("category_id") Integer categoryId,
            @RequestParam("category_name") String categoryName,
            @RequestParam("logo_update") Integer logoUpdate,
            @RequestParam(value = "category_logo",required = false) MultipartFile categoryLogo) {
        return productCategoryClient.updateProductCategory(categoryId, categoryName, logoUpdate, categoryLogo);
    }

    /**
     * 删除商品分类信息
     *
     * @param categoryId 分类ID
     * @return
     */
    @RequestMapping(value = "/delProductCategory", method = {RequestMethod.DELETE})
    public Result delProductCategory(
            @RequestParam("category_id") Integer categoryId) {
        return productCategoryClient.delProductCategory(categoryId);
    }

}
