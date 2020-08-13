package com.kyj.cooltiger.product.controller;

import com.kyj.cooltiger.common.utils.Result;
import com.kyj.cooltiger.feign.product.client.ProductParamModelClient;
import com.kyj.cooltiger.feign.product.vo.ProductParamModelReqVo;
import com.kyj.cooltiger.product.service.ProductParamModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author liduan
 * Description: 商品参数模板controller
 * date: 2020/8/12 16:54
 */
@RestController
@RequestMapping("/product/productParamModel")
public class ProductParamModelController implements ProductParamModelClient {

    @Autowired
    private ProductParamModelService productParamModelService;

    /**
     * 添加商品参数模板
     *
     * @param categoryId
     * @param paramModelReqVos
     * @return
     */
    @Override
    @RequestMapping(value = "/addProductParamModel", method = {RequestMethod.POST})
    public Result addProductParamModel(
            @RequestParam("category_id") Integer categoryId,
            @RequestBody List<ProductParamModelReqVo> paramModelReqVos) {
        productParamModelService.addProductParamModel(categoryId, paramModelReqVos);
        return Result.success();
    }

    /**
     * 查询商品参数模板
     *
     * @param categoryId
     * @return
     */
    @Override
    @RequestMapping(value = "/getProductParamModel", method = {RequestMethod.GET})
    public Result getProductParamModel(
            @RequestParam("category_id") Integer categoryId) {
        Map<String, Object> res = productParamModelService.getProductParamModel(categoryId);
        return Result.success(res.get("data"));
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
        productParamModelService.updateProductParamModel(categoryId,paramModelReqVos);
        return Result.success();
    }

    /**
     * 删除商品模板
     *
     * @param categoryId
     * @return
     */
    @RequestMapping(value = "/delProductParamModel",method = {RequestMethod.DELETE})
    public Result delProductParamModel(@RequestParam("category_id") Integer categoryId){
        productParamModelService.delProductParamModel(categoryId);
        return Result.success();
    }

}
