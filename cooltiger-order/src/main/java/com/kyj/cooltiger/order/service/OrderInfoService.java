package com.kyj.cooltiger.order.service;

import com.kyj.cooltiger.feign.order.vo.OrderInfoRespVo;
import com.kyj.cooltiger.feign.order.vo.PlaceOrderReqVo;
import com.kyj.cooltiger.order.entity.OrderInfo;

import java.util.Map;

/**
 * @author guoxq
 * Description: 订单service接口
 * date 2020/8/17 16:10
 */
public interface OrderInfoService {

    /**
     * 查询店铺订单列表信息
     *
     * @param storeId      店铺ID
     * @param userId       用户ID
     * @param orderStatus  订单状态（0-待付款1-待发货2-配送中3-已送达4-已完成5-已评价6-售后）
     * @param reviewStatus 评价状态（0-未评价1-已评价）
     * @param dateStart    开始时间
     * @param dateEnd      结束时间
     * @param keyword      关键词
     * @param pageNo       当前页
     * @param pageSize     分页单位
     * @return
     */
    public Map<String, Object> getOrderList(
            Integer storeId, Integer userId, Integer orderStatus, Integer reviewStatus, String dateStart, String dateEnd, String keyword,
            Integer pageNo, Integer pageSize);

    /**
     * 查询订单详情
     *
     * @param orderId 订单ID
     * @return
     */
    public OrderInfoRespVo getOrderDetail(Integer orderId);

    /**
     * 用户下单
     *
     * @param userId          用户ID
     * @param placeOrderReqVo 下单信息
     * @param sourceType      订单来源（0-pc 1-小程序 2-app）
     * @return
     */
    public Map<String, Object> placeOrder(Integer userId, PlaceOrderReqVo placeOrderReqVo, Integer sourceType);

    /**
     * 根据订单id查询订单信息
     *
     * @return
     */
    OrderInfo queryorder(Integer orderId);
}
