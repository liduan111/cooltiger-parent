package com.kyj.cooltiger.feign.order.vo;

/**
 * @author liduan
 * Description: 订单详情列表返回vo
 * date: 2020/9/3 14:31
 */
public class OrderDetailListRespVo {

    //订单详情ID
    private Integer orderDetailId;
    //订单ID
    private Integer orderId;
    //商品ID
    private Integer productId;
    //商品标题
    private String productTitle;
    //商品skuID
    private Integer skuId;
    //sku图片url
    private String picUrl;
    //sku规格
    private String skuSpec;
    //商品数量
    private Integer skuNumber;
    //商品sku价格
    private Double skuPrice;
    //商品重量（kg）
    private Double skuWeight;

    public Integer getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(Integer orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getSkuId() {
        return skuId;
    }

    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public String getSkuSpec() {
        return skuSpec;
    }

    public void setSkuSpec(String skuSpec) {
        this.skuSpec = skuSpec;
    }

    public Integer getSkuNumber() {
        return skuNumber;
    }

    public void setSkuNumber(Integer skuNumber) {
        this.skuNumber = skuNumber;
    }

    public Double getSkuPrice() {
        return skuPrice;
    }

    public void setSkuPrice(Double skuPrice) {
        this.skuPrice = skuPrice;
    }

    public Double getSkuWeight() {
        return skuWeight;
    }

    public void setSkuWeight(Double skuWeight) {
        this.skuWeight = skuWeight;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
}
