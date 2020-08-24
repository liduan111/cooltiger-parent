package com.kyj.cooltiger.feign.product.controller;

import com.kyj.cooltiger.common.utils.Result;
import com.kyj.cooltiger.feign.product.client.ProductParamModelClient;
import com.kyj.cooltiger.feign.product.vo.ProductParamModelReqVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author liduan
 * Description:
 * date: 2020/8/24 14:18
 */
@RestController
@RequestMapping("/product/productParamModel")
public class ProductParamModelController {

    @Autowired
    private ProductParamModelClient productParamModelClient;

    /**
     * 添加商品参数模板
     *
     * @param categoryId
     * @param paramModelReqVos
     * @return
     */
    @RequestMapping(value = "/addProductParamModel", method = {RequestMethod.POST})
    public Result addProductParamModel(
            @RequestParam("category_id") Integer categoryId,
            @RequestBody List<ProductParamModelReqVo> paramModelReqVos){
        return productParamModelClient.addProductParamModel(categoryId, paramModelReqVos);
    }

    /**
     * 查询商品参数模板
     *
     * @param categoryId
     * @return
     */
    @RequestMapping(value = "/getProductParamModel", method = {RequestMethod.GET})
    public Result getProductParamModel(
            @RequestParam("category_id") Integer categoryId){
        return productParamModelClient.getProductParamModel(categoryId);
    }

    /**
     * 修改商品参数模板
     *
     * @param paramModelReqVos
     * @return
     */
    @RequestMapping(value = "/updateProductParamModel", method = {RequestMethod.PUT})
    public Result updateProductParamModel(
            @RequestParam("category_id") Integer categoryId,
            @RequestBody List<ProductParamModelReqVo> paramModelReqVos){
        return productParamModelClient.updateProductParamModel(categoryId, paramModelReqVos);
    }

    /**
     * 删除商品模板
     *
     * @param categoryId
     * @return
     */
    @RequestMapping(value = "/delProductParamModel",method = {RequestMethod.DELETE})
    public Result delProductParamModel(@RequestParam("category_id") Integer categoryId){
        return productParamModelClient.delProductParamModel(categoryId);
    }
}
