package com.kyj.cooltiger.product.controller;

import com.kyj.cooltiger.common.utils.Result;
import com.kyj.cooltiger.feign.product.client.ProductSkuClient;
import com.kyj.cooltiger.product.service.ProductSkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author liduan
 * Description: 商品sku controller
 * date: 2020/9/8 13:31
 */
@RestController
@RequestMapping("/product/productSku")
public class ProductSkuController implements ProductSkuClient {

    @Autowired
    private ProductSkuService productSkuService;

    /**
     * 获取商品sku信息
     *
     * @param skuId skuID
     * @return
     */
    @RequestMapping(value = "/getProductSku", method = {RequestMethod.GET})
    public Result getProductSku(
            @RequestParam("sku_id") Integer skuId){
        Map<String,Object> res = productSkuService.getProductSku(skuId);
        return Result.success(res.get("data"));
    }

    /**
     * 获取商品sku列表
     *
     * @param productId 商品ID
     * @return
     */
    @RequestMapping(value = "/getProductSkuList", method = {RequestMethod.GET})
    public Result getProductSkuList(@RequestParam("product_id") Integer productId){
        Map<String,Object> res = productSkuService.getProductSkuList(productId);
        return Result.success(res.get("data"));
    }
}
