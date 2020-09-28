package com.kyj.cooltiger.feign.order.client;

import com.kyj.cooltiger.common.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/9/25 13:59
 */
@FeignClient(name = "Order-Service")
public interface OrderPayClient {
    @RequestMapping(value = "/order/pay",method = RequestMethod.POST)
    public Result orderpay(@RequestParam(value = "orderId",required = false)Integer orderId,
                           @RequestParam(value = "userId",required = false)Integer userId);
}
