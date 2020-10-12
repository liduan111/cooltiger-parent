package com.kyj.cooltiger.feign.product.controller;

import com.kyj.cooltiger.common.utils.Result;
import com.kyj.cooltiger.feign.product.client.ProductSkuClient;
import com.kyj.cooltiger.feign.product.vo.ProductSkuReqVo;
import com.kyj.cooltiger.feign.product.vo.ProductSpecReqVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author liduan
 * Description: 商品skucontroller
 * date: 2020/9/8 13:28
 */
@RestController
@RequestMapping("/product/productSku")
public class ProductSkuController {

    @Autowired
    private ProductSkuClient productSkuClient;

    /**
     * 获取商品sku信息
     *
     * @param skuId skuID
     * @return
     */
    @RequestMapping(value = "/getProductSku", method = {RequestMethod.GET})
    public Result getProductSku(
            @RequestParam("sku_id") Integer skuId) {
        return productSkuClient.getProductSku(skuId);
    }

    /**
     * 获取商品sku列表
     *
     * @param productId 商品ID
     * @return
     */
    @RequestMapping(value = "/getProductSkuList", method = {RequestMethod.GET})
    public Result getProductSkuList(
            @RequestParam("product_id") Integer productId) {
        return productSkuClient.getProductSkuList(productId);
    }

    /**
     * 添加商品规格
     *
     * @param productId        商品ID
     * @param productSpecReqVo 商品规格参数
     * @return
     */
    @RequestMapping(value = "/addProductSpec", method = {RequestMethod.POST})
    public Result addProductSpec(
            @RequestParam("product_id") Integer productId,
            @RequestBody ProductSpecReqVo productSpecReqVo) {
        return productSkuClient.addProductSpec(productId, productSpecReqVo);
    }

    /**
     * 添加商品Sku信息
     *
     * @param productId       商品ID
     * @param productSkuReqVo 商品Sku信息
     * @return
     */
    @RequestMapping(value = "/addProductSkuInfo", method = {RequestMethod.POST})
    public Result addProductSkuInfo(
            @RequestParam("product_id") Integer productId,
            @RequestBody ProductSkuReqVo productSkuReqVo) {
        return productSkuClient.addProductSkuInfo(productId, productSkuReqVo);
    }


}
