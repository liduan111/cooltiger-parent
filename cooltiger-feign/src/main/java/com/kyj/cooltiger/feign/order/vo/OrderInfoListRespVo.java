package com.kyj.cooltiger.feign.order.vo;

import java.util.List;

/**
 * @author liduan
 * Description: 订单信息列表返回vo
 * date: 2020/9/3 13:54
 */
public class OrderInfoListRespVo {

    //订单ID
    private Integer orderId;
    //订单编号
    private String orderCode;
    //店铺ID
    private Integer storeId;
    //店铺名称
    private String storeName;
    //用户id
    private Integer userId;
    //用户名称
    private Integer userName;
    //订单状态（0-待付款1-待发货2-配送中3-已送达4-已完成5-已评价6-售后
    private Integer orderStatus;
    //订单总金额
    private Double totalPrice;
    //配送费用
    private Double freightPrice;
    //支付金额
    private Double payPrice;
    //订单来源（0-pc1-小程序 2-app）
    private Integer sourceType;
    //创建时间
    private String createTime;
    //订单详情List
    private List<OrderDetailListRespVo> orderDetailListRespList;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserName() {
        return userName;
    }

    public void setUserName(Integer userName) {
        this.userName = userName;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Double getFreightPrice() {
        return freightPrice;
    }

    public void setFreightPrice(Double freightPrice) {
        this.freightPrice = freightPrice;
    }

    public Double getPayPrice() {
        return payPrice;
    }

    public void setPayPrice(Double payPrice) {
        this.payPrice = payPrice;
    }

    public Integer getSourceType() {
        return sourceType;
    }

    public void setSourceType(Integer sourceType) {
        this.sourceType = sourceType;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public List<OrderDetailListRespVo> getOrderDetailListRespList() {
        return orderDetailListRespList;
    }

    public void setOrderDetailListRespList(List<OrderDetailListRespVo> orderDetailListRespList) {
        this.orderDetailListRespList = orderDetailListRespList;
    }
}
