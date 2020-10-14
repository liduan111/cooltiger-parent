package com.kyj.cooltiger.feign.product.client;

import com.kyj.cooltiger.common.utils.Result;
import com.kyj.cooltiger.feign.product.vo.ProductSkuReqVo;
import com.kyj.cooltiger.feign.product.vo.ProductSpecReqVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author liduan
 * Description: 商品sku client
 * date: 2020/9/8 13:30
 */
@FeignClient(name = "Product-Service")
public interface ProductSkuClient {

    /**
     * 获取商品sku信息
     *
     * @param skuId skuID
     * @return
     */
    @RequestMapping(value = "/product/productSku/getProductSku", method = {RequestMethod.GET})
    public Result getProductSku(
            @RequestParam("sku_id") Integer skuId);

    /**
     * 获取商品sku列表
     *
     * @param productId 商品ID
     * @return
     */
    @RequestMapping(value = "/product/productSku/getProductSkuList", method = {RequestMethod.GET})
    public Result getProductSkuList(@RequestParam("product_id") Integer productId);

    /**
     * 添加商品规格
     *
     * @param productId        商品ID
     * @param productSpecReqVo 商品规格参数
     * @return
     */
    @RequestMapping(value = "/product/productSku/addProductSpec", method = {RequestMethod.POST})
    public Result addProductSpec(
            @RequestParam("product_id") Integer productId,
            @RequestBody ProductSpecReqVo productSpecReqVo);

    /**
     * 添加商品Sku信息
     *
     * @param productId        商品ID
     * @param productSkuReqVos 商品Sku信息
     * @return
     */
    @RequestMapping(value = "/addProductSkuInfo", method = {RequestMethod.POST})
    public Result addProductSkuInfo(
            @RequestParam("product_id") Integer productId,
            @RequestBody List<ProductSkuReqVo> productSkuReqVos);

}
