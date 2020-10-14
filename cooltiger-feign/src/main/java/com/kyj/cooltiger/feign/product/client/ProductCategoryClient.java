package com.kyj.cooltiger.feign.product.client;

import com.kyj.cooltiger.common.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author liduan
 * Description: 商品类别Client
 * date: 2020/8/10 11:30
 */
@FeignClient(name = "Product-Service")
public interface ProductCategoryClient {

    /**
     * 添加商品分类
     *
     * @param categoryName     分类名称
     * @param categoryParentId 父分类ID(0:一级分类）
     * @param categoryLevel    分类等级（0-一级分类1-二级分类2-三级分类）
     * @param categoryLogo     分类图片logo
     * @return
     */
    @RequestMapping(value = "/product/productCategory/addProductCategory", method = {RequestMethod.POST})
    public Result addProductCategory(
            @RequestParam("category_name") String categoryName,
            @RequestParam(value = "category_parent_id", defaultValue = "0") Integer categoryParentId,
            @RequestParam(value = "category_level", defaultValue = "0") Integer categoryLevel,
            @RequestParam(value = "category_logo", required = false) MultipartFile categoryLogo);

    /**
     * 查询商品分类列表信息
     *
     * @param categoryParentId 父分类ID(0:一级分类）
     * @param categoryLevel    分类等级（0-一级分类1-二级分类2-三级分类）
     * @return
     */
    @RequestMapping(value = "/product/productCategory/productCategoryList/{parent_id}", method = {RequestMethod.GET})
    public Result productCategoryList(
            @RequestParam(value = "category_parent_id", required = false) Integer categoryParentId,
            @RequestParam(value = "category_level", required = false) Integer categoryLevel);

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
            @RequestParam(value = "category_logo",required = false) MultipartFile categoryLogo);

    /**
     * 删除商品分类信息
     *
     * @param categoryId 分类ID
     * @return
     */
    @RequestMapping(value = "/product/productCategory/delProductCategory", method = {RequestMethod.DELETE})
    public Result delProductCategory(
            @RequestParam("category_id") Integer categoryId);

    /**
     * 更换分类logo
     *
     * @param categoryId   分类ID
     * @param categoryLogo 分类Logo
     * @return
     */
    @RequestMapping(value = "/updateCategoryLogo",method = {RequestMethod.PUT})
    public Result updateCategoryLogo(
            @RequestParam("category_id") Integer categoryId,
            @RequestParam("category_logo") MultipartFile categoryLogo);
}
