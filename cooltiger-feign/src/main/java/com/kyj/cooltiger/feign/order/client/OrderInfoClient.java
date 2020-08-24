package com.kyj.cooltiger.feign.order.client;

import com.kyj.cooltiger.common.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author liduan
 * Description: 订单信息client
 * date: 2020/8/18 15:25
 */
@FeignClient(name = "Order-Service")
public interface OrderInfoClient {

    @RequestMapping(value = "/order/orderInfo/hello",method = {RequestMethod.GET})
    public Result hello();
}
