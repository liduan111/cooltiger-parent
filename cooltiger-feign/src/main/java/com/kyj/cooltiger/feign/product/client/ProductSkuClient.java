package com.kyj.cooltiger.feign.product.client;

import com.kyj.cooltiger.common.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
}
