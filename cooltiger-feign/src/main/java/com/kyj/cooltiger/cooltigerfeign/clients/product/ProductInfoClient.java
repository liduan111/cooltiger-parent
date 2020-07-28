package com.kyj.cooltiger.cooltigerfeign.clients.product;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author liduan
 * Description: 商品信息ProductInfo FeignClient接口
 * date: 2020/7/28 14:44
 */
@FeignClient(name = "Product-Service")
public interface ProductInfoClient {

    /**
     * 测试方法
     * @param id
     * @return
     */
    @RequestMapping(value = "/hello/{id}",method = {RequestMethod.GET})
    public String hello(@PathVariable("id") String id);
}
