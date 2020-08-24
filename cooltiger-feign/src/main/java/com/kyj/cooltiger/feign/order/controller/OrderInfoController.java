package com.kyj.cooltiger.feign.order.controller;

import com.kyj.cooltiger.common.utils.Result;
import com.kyj.cooltiger.feign.order.client.OrderInfoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liduan
 * Description:
 * date: 2020/8/24 11:16
 */
@RestController
@RequestMapping("/order/orderInfo")
public class OrderInfoController {

    @Autowired
    private OrderInfoClient orderInfoClient;

    @RequestMapping(value = "/hello",method = {RequestMethod.GET})
    public Result hello(){
        return orderInfoClient.hello();
    }
}
