package com.kyj.cooltiger.feign.product.controller;

import com.kyj.cooltiger.feign.product.client.ProductSkuClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
