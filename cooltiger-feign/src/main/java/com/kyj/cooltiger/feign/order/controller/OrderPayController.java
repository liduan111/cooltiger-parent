package com.kyj.cooltiger.feign.order.controller;

import com.kyj.cooltiger.common.utils.Result;
import com.kyj.cooltiger.feign.order.client.OrderPayClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/9/25 14:02
 */
@RestController
@RequestMapping("/order")
public class OrderPayController {
    @Autowired
    private OrderPayClient  orderPayClient;

    @RequestMapping(value = "/pay",method = RequestMethod.POST)
    public Result orderpay(@RequestParam(value = "orderId",required = false)Integer orderId,
                           @RequestParam(value = "userId",required = false)Integer userId){
        return  orderPayClient.orderpay(orderId,userId);
    }
}
