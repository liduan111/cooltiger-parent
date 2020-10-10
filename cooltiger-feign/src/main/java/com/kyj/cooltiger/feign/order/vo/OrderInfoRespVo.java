package com.kyj.cooltiger.feign.order.vo;

import java.util.Date;
import java.util.List;

/**
 * @author liduan
 * Description: 订单信息返回vo
 * date: 2020/10/10 14:31
 */
public class OrderInfoRespVo {

    //订单ID
    private Integer orderId;
    //订单编号
    private String orderCode;
    //店铺ID
    private Integer storeId;
    //用户id
    private Integer userId;
    //省（直辖市）
    private String receiverProvince;
    //市(直辖区)
    private String receiverCity;
    //县（区）
    private String receiverRegion;
    //收货人详细地址
    private String receiverAddressDetail;
    //收货人
    private String receiverName;
    //收货人电话
    private String receiverMobile;
    //订单总金额
    private Double totalPrice;
    //配送费用
    private Double freightPrice;
    //支付金额
    private Double payPrice;
    //订单备注
    private String orderNote;
    //订单状态（0-待付款1-待发货2-配送中3-已送达4-已完成5-退款/售后6-已取消7-支付中）
    private Integer orderStatus;
    //支付付方式（1-微信2-支付宝3-网银）
    private Integer payType;
    //交易订单号（第三方订单号）
    private String outerTradeNo;
    //支付时间
    private Date payTime;
    //快递公司
    private String expressComp;
    //快递单号
    private String expressNumber;
    //发货时间
    private Date sendTime;
    //确认收货时间
    private Date confirmReceiveTime;
    //评价状态（0-未评价1-已评价）
    private Integer reviewStatus;
    //订单来源（0-pc1-小程序 2-app）
    private Integer sourceType;
    //删除状态(0-未删除1-已删除）
    private Integer deleted;
    //创建时间
    private Date createTime;
    //修改时间
    private Date modifiedTime;
    //订单详情List
    private List<OrderDetailListRespVo> details;

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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getReceiverProvince() {
        return receiverProvince;
    }

    public void setReceiverProvince(String receiverProvince) {
        this.receiverProvince = receiverProvince;
    }

    public String getReceiverCity() {
        return receiverCity;
    }

    public void setReceiverCity(String receiverCity) {
        this.receiverCity = receiverCity;
    }

    public String getReceiverRegion() {
        return receiverRegion;
    }

    public void setReceiverRegion(String receiverRegion) {
        this.receiverRegion = receiverRegion;
    }

    public String getReceiverAddressDetail() {
        return receiverAddressDetail;
    }

    public void setReceiverAddressDetail(String receiverAddressDetail) {
        this.receiverAddressDetail = receiverAddressDetail;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverMobile() {
        return receiverMobile;
    }

    public void setReceiverMobile(String receiverMobile) {
        this.receiverMobile = receiverMobile;
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

    public String getOrderNote() {
        return orderNote;
    }

    public void setOrderNote(String orderNote) {
        this.orderNote = orderNote;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getOuterTradeNo() {
        return outerTradeNo;
    }

    public void setOuterTradeNo(String outerTradeNo) {
        this.outerTradeNo = outerTradeNo;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public String getExpressComp() {
        return expressComp;
    }

    public void setExpressComp(String expressComp) {
        this.expressComp = expressComp;
    }

    public String getExpressNumber() {
        return expressNumber;
    }

    public void setExpressNumber(String expressNumber) {
        this.expressNumber = expressNumber;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Date getConfirmReceiveTime() {
        return confirmReceiveTime;
    }

    public void setConfirmReceiveTime(Date confirmReceiveTime) {
        this.confirmReceiveTime = confirmReceiveTime;
    }

    public Integer getReviewStatus() {
        return reviewStatus;
    }

    public void setReviewStatus(Integer reviewStatus) {
        this.reviewStatus = reviewStatus;
    }

    public Integer getSourceType() {
        return sourceType;
    }

    public void setSourceType(Integer sourceType) {
        this.sourceType = sourceType;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public List<OrderDetailListRespVo> getDetails() {
        return details;
    }

    public void setDetails(List<OrderDetailListRespVo> details) {
        this.details = details;
    }
}
