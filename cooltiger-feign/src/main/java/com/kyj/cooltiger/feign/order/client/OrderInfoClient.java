package com.kyj.cooltiger.feign.order.client;

import com.kyj.cooltiger.common.utils.Result;
import com.kyj.cooltiger.feign.order.vo.ProductSettlementReqVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author liduan
 * Description: 订单信息client
 * date: 2020/8/18 15:25
 */
@FeignClient(name = "Order-Service")
public interface OrderInfoClient {

    /**
     * 查询店铺订单列表信息
     *
     * @param storeId     店铺ID
     * @param userId      用户ID
     * @param orderStatus 订单状态（0-待付款1-待发货2-配送中3-已送达4-已完成5-已评价6-售后）
     * @param dateStart   开始时间
     * @param dateEnd     结束时间
     * @param keyword     关键词
     * @param pageNo      当前页
     * @param pageSize    分页单位
     * @return
     */
    @RequestMapping(value = "/order/orderInfo/getOrderList", method = {RequestMethod.GET})
    public Result getOrderList(
            @RequestParam(value = "store_id", required = false) Integer storeId,
            @RequestParam(value = "user_id", required = false) Integer userId,
            @RequestParam(value = "order_status", required = false) Integer orderStatus,
            @RequestParam(value = "date_start", required = false) String dateStart,
            @RequestParam(value = "date_end", required = false) String dateEnd,
            @RequestParam(value = "keyword", required = false) String keyword,
            @RequestParam(value = "page_no", defaultValue = "1") Integer pageNo,
            @RequestParam(value = "page_size", defaultValue = "10") Integer pageSize);

    /**
     * 购物车或商品结算
     *
     * @param userId                     用户ID
     * @param productSettlementReqVoList 结算信息入参
     * @return
     */
    @RequestMapping(value = "/order/orderInfo/settlement", method = {RequestMethod.POST})
    public Result settlement(
            @RequestParam("user_id") Integer userId,
            @RequestBody List<ProductSettlementReqVo> productSettlementReqVoList);
}
