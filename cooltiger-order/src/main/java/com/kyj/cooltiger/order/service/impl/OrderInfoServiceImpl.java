package com.kyj.cooltiger.order.service.impl;

import com.kyj.cooltiger.common.constant.DELETED;
import com.kyj.cooltiger.common.constant.ORDER_STATUS;
import com.kyj.cooltiger.common.utils.CharUtil;
import com.kyj.cooltiger.common.utils.PageUtil;
import com.kyj.cooltiger.feign.oauth.client.ShopCartClient;
import com.kyj.cooltiger.feign.order.vo.OrderDetailListRespVo;
import com.kyj.cooltiger.feign.order.vo.OrderInfoListRespVo;
import com.kyj.cooltiger.feign.order.vo.PlaceOrderReqVo;
import com.kyj.cooltiger.order.entity.OrderDetail;
import com.kyj.cooltiger.order.entity.OrderInfo;
import com.kyj.cooltiger.order.mapper.OrderDetailMapper;
import com.kyj.cooltiger.order.mapper.OrderInfoMapper;
import com.kyj.cooltiger.order.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author guoxq
 * Description: 订单信息service实现类
 * @date 2020/8/17 16:11
 */
@Service
public class OrderInfoServiceImpl implements OrderInfoService {

    @Autowired
    private OrderInfoMapper orderInfoMapper;
    @Autowired
    private OrderDetailMapper orderDetailMapper;
    @Autowired
    private ShopCartClient shopCartClient;

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
    @Override
    public Map<String, Object> getOrderList(Integer storeId, Integer userId, Integer orderStatus, String dateStart, String dateEnd, String keyword,
                                            Integer pageNo, Integer pageSize) {
        //查询总数
        int totalCount = orderInfoMapper.getOrderListTotalCount(storeId, userId, orderStatus, dateStart, dateEnd, keyword);
        //创建分页工具类对象
        PageUtil<Object> pageUtil = new PageUtil<>(pageNo, pageSize, totalCount);
        List<OrderInfoListRespVo> orderInfoListRespVoList = null;
        if (totalCount > 0) {
            int pageStart = (pageUtil.getPageNo() - 1) * pageUtil.getPageSize();
            orderInfoListRespVoList = orderInfoMapper.getOrderListByStoreId$UserId(storeId, userId, orderStatus, dateStart, dateEnd, keyword, pageStart, pageSize);
            List<OrderDetailListRespVo> orderDetailListRespVoList = null;
            for (OrderInfoListRespVo orderInfoListRespVo : orderInfoListRespVoList) {
                orderDetailListRespVoList = orderDetailMapper.getOrderDetailListByOrderId(orderInfoListRespVo.getOrderId());
                orderInfoListRespVo.setOrderDetailListRespList(orderDetailListRespVoList);
            }
        }
        Map<String, Object> res = new HashMap<>();
        res.put("totalCount", totalCount);
        res.put("totalPage", pageUtil.getTotalPage());
        res.put("data", orderInfoListRespVoList);
        return res;
    }

    /**
     * 用户下单
     *
     * @param userId          用户ID
     * @param placeOrderReqVo 下单信息
     * @param sourceType      订单来源（0-pc 1-小程序 2-app）
     * @return
     */
    @Override
    public Map<String, Object> placeOrder(Integer userId, PlaceOrderReqVo placeOrderReqVo, Integer sourceType) {
        Date now = new Date();
        OrderInfo orderInfo = null;
        List<OrderDetail> orderDetails = null;
        OrderDetail orderDetail = null;
        List<Integer> orderIds = new ArrayList<>();
        for (PlaceOrderReqVo.OrderInfoVo info : placeOrderReqVo.getInfos()) {
            orderInfo = new OrderInfo();
            orderInfo.setOrderCode(CharUtil.getTimeStampRandom(12));
            orderInfo.setStoreId(info.getStoreId());
            orderInfo.setUserId(userId);
            orderInfo.setReceiverProvince(placeOrderReqVo.getReceiverProvince());
            orderInfo.setReceiverCity(placeOrderReqVo.getReceiverCity());
            orderInfo.setReceiverRegion(placeOrderReqVo.getReceiverRegion());
            orderInfo.setReceiverAddressDetail(placeOrderReqVo.getReceiverAddressDetail());
            orderInfo.setReceiverName(placeOrderReqVo.getReceiverName());
            orderInfo.setReceiverMobile(placeOrderReqVo.getReceiverMobile());
            orderInfo.setTotalPrice(info.getTotalPrice());
            orderInfo.setFreightPrice(info.getFreightPrice());
            orderInfo.setPayPrice(info.getPayPrice());
            orderInfo.setOrderNote(info.getOrderNote());
            orderInfo.setOrderStatus(ORDER_STATUS.STAY_PAYMENT);
            orderInfo.setReviewStatus(DELETED.NOT);
            orderInfo.setSourceType(sourceType);
            orderInfo.setDeleted(DELETED.NOT);
            orderInfo.setCreateTime(now);
            orderInfo.setModifiedTime(now);
            orderInfoMapper.insertOrderInfo(orderInfo);
            orderIds.add(orderInfo.getOrderId());
            orderDetails = new ArrayList<>();
            for (PlaceOrderReqVo.OrderDetailVo detail : info.getDetails()){
                orderDetail = new OrderDetail();
                orderDetail.setOrderId(orderInfo.getOrderId());
                orderDetail.setProductId(detail.getProductId());
                orderDetail.setProductTitle(detail.getProductTitle());
                orderDetail.setSkuId(detail.getSkuId());
                orderDetail.setPicUrl(detail.getPicUrl());
                orderDetail.setSkuSpec(detail.getSkuSpec());
                orderDetail.setSkuPrice(detail.getSkuPrice());
                orderDetail.setSkuNumber(detail.getSkuNumber());
                orderDetail.setSkuWeight(detail.getSkuWeight());
                orderDetails.add(orderDetail);
            }
            orderDetailMapper.batchInsertOrderDetail(orderDetails);
        }
        if (placeOrderReqVo.getCartIds() != null && placeOrderReqVo.getCartIds() != ""){
            shopCartClient.deleteAllgoods(placeOrderReqVo.getCartIds());
        }
        Map<String,Object> res = new HashMap<>();
        res.put("data",orderIds);
        return res;
    }
}