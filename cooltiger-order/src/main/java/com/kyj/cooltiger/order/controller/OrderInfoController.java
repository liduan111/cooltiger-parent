package com.kyj.cooltiger.order.controller;

import com.kyj.cooltiger.common.utils.Result;
import com.kyj.cooltiger.feign.order.client.OrderInfoClient;
import com.kyj.cooltiger.order.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author guoxq
 * Description: 订单信息controller
 * @date 2020/8/17 16:09
 */
@RestController
@RequestMapping("/order/orderInfo")
public class OrderInfoController implements OrderInfoClient {

    @Autowired
    private OrderInfoService orderInfoService;

    @Override
    @RequestMapping(value = "/hello",method = {RequestMethod.GET})
    public Result hello() {
        return Result.success("hello");
    }

    /**
     * 创建订单
     * @return
     */
    @RequestMapping(value = "/createorder")
    public Result  createorder(){
        return  Result.error("500","服务器出错");
    }

}
