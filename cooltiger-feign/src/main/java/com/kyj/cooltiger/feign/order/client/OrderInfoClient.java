package com.kyj.cooltiger.feign.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author liduan
 * Description: 订单信息client
 * date: 2020/8/18 15:25
 */
@FeignClient(name = "Order-Service")
@RequestMapping("/order/orderInfo")
public interface OrderInfoClient {
}
