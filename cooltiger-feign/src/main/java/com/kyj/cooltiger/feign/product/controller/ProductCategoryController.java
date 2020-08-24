package com.kyj.cooltiger.feign.product.controller;

import com.kyj.cooltiger.common.utils.Result;
import com.kyj.cooltiger.feign.product.client.ProductCategoryClient;
import com.kyj.cooltiger.feign.product.vo.ProductCategoryAddReqVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author liduan
 * Description:
 * date: 2020/8/24 14:11
 */
@RestController
@RequestMapping("/product/productCategory")
public class ProductCategoryController {

    @Autowired
    private ProductCategoryClient productCategoryClient;

    /**
     * 添加商品分类
     * @param parentId 分类父ID
     * @param categoryLists 分类信息
     * @return
     */
    @RequestMapping(value = "/addProductCategory",method = {RequestMethod.POST})
    public Result addProductCategory(
            @RequestParam(value = "parent_id",defaultValue = "0") Integer parentId,
            @RequestBody List<ProductCategoryAddReqVo> categoryLists){
        return productCategoryClient.addProductCategory(parentId, categoryLists);
    }

    /**
     * 查询商品分类列表信息
     * @param parentId 分类父ID
     * @return
     */
    @RequestMapping(value = "/productCategoryList/{parent_id}",method = {RequestMethod.GET})
    public Result productCategoryList(
            @PathVariable("parent_id") Integer parentId){
        return productCategoryClient.productCategoryList(parentId);
    }

    /**
     * 修改商品分类
     * @param categoryId 分类ID
     * @param category 分类信息
     * @return
     */
    @RequestMapping(value = "/updateProductCategory",method = {RequestMethod.PUT})
    public Result updateProductCategory(
            @RequestParam(value = "category_id") Integer categoryId,
            @RequestBody ProductCategoryAddReqVo category){
        return productCategoryClient.updateProductCategory(categoryId, category);
    }

    /**
     * 删除商品分类信息
     * @param categoryId 分类ID
     * @return
     */
    @RequestMapping(value = "/delProductCategory",method = {RequestMethod.DELETE})
    public Result delProductCategory(
            @RequestParam(value = "category_id") Integer categoryId){
        return productCategoryClient.delProductCategory(categoryId);
    }
}
