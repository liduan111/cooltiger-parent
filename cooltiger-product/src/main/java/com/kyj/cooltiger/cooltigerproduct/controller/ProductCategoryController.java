package com.kyj.cooltiger.cooltigerproduct.controller;

import com.kyj.cooltiger.cooltigercommon.excep.MyException;
import com.kyj.cooltiger.cooltigercommon.utils.Result;
import com.kyj.cooltiger.cooltigerfeign.product.client.ProductCategoryClient;
import com.kyj.cooltiger.cooltigerfeign.product.vo.ProductCategoryAddReqVo;
import com.kyj.cooltiger.cooltigerproduct.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    /**
     * 添加商品分类
     * @param parentId 分类父ID
     * @param categoryLists 分类信息
     * @return
     */
    @Override
    @RequestMapping(value = "/addProductCategory",method = {RequestMethod.POST})
    public Result addProductCategory(
            @RequestParam(value = "parent_id",defaultValue = "0") Integer parentId,
            @RequestBody List<ProductCategoryAddReqVo> categoryLists) {
        productCategoryService.addProductCategory(parentId,categoryLists);
        return Result.success();
    }

    /**
     * 查询商品分类列表信息
     * @param parentId 分类父ID
     * @return
     */
    @Override
    @RequestMapping(value = "/productCategoryList/{parent_id}",method = {RequestMethod.GET})
    public Result productCategoryList(
            @PathVariable("parent_id") Integer parentId){
        Map<String,Object> resMap = productCategoryService.getProductCategoryList(parentId);
        return Result.success(resMap.get("data"));
    }

    /**
     * 修改商品分类
     * @param categoryId 分类ID
     * @param category 分类信息
     * @return
     */
    @Override
    @RequestMapping(value = "/updateProductCategory",method = {RequestMethod.PUT})
    public Result updateProductCategory(
            @RequestParam("category_id") Integer categoryId,
            @RequestBody ProductCategoryAddReqVo category){
        productCategoryService.updateProductCategory(categoryId,category);
        return Result.success();
    }

    /**
     * 删除商品分类信息
     * @param categoryId 分类ID
     * @return
     */
    @Override
    @RequestMapping(value = "/delProductCategory",method = {RequestMethod.DELETE})
    public Result delProductCategory(
            @RequestParam(value = "category_id") Integer categoryId){
        productCategoryService.delProductCategory(categoryId);
        return Result.success();
    }

}
