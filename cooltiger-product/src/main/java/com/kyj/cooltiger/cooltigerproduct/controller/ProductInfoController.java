package com.kyj.cooltiger.cooltigerproduct.controller;

import com.kyj.cooltiger.cooltigerfeign.clients.goods.GoodsCilent;
import com.kyj.cooltiger.cooltigerfeign.clients.product.ProductInfoClient;
import com.kyj.cooltiger.cooltigerproduct.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liduan
 * Description: 商品信息Controller
 * date: 2020/7/28 11:18
 */
@RestController
@RequestMapping("/product/productInfo")
public class ProductInfoController implements ProductInfoClient {

    @Autowired
    private ProductInfoService productInfoService;

    /**
     * 测试方法
     * @param id
     * @return
     */
    @Override
    @RequestMapping(value = "/hello/{id}",method = {RequestMethod.GET})
    public String hello(@PathVariable("id") String id){
        return "hello";
    }

}
