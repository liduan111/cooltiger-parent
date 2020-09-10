package com.kyj.cooltiger.feign.order.vo;

import java.util.Date;

/**
 * @author liduan
 * Description: 订单评论入参vo
 * date: 2020/9/10 9:19
 */
public class OrderReviewReqVo {

    //店铺ID
    private Integer store_id;
    //商品ID
    private Integer product_id;
    //商品skuID
    private Integer sku_id;
    //订单ID
    private Integer order_id;
    //是否匿名评价（0-否1-是）
    private Integer anonymous;
    //商品评价星级（1-5星）
    private Integer review_star;
    //物流服务星级（1-5星）
    private Integer logistics_star;
    //店铺服务星级（1-5星）
    private Integer store_star;
    //评价内容
    private String review_content;

    public Integer getStore_id() {
        return store_id;
    }

    public void setStore_id(Integer store_id) {
        this.store_id = store_id;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public Integer getSku_id() {
        return sku_id;
    }

    public void setSku_id(Integer sku_id) {
        this.sku_id = sku_id;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public Integer getAnonymous() {
        return anonymous;
    }

    public void setAnonymous(Integer anonymous) {
        this.anonymous = anonymous;
    }

    public Integer getReview_star() {
        return review_star;
    }

    public void setReview_star(Integer review_star) {
        this.review_star = review_star;
    }

    public Integer getLogistics_star() {
        return logistics_star;
    }

    public void setLogistics_star(Integer logistics_star) {
        this.logistics_star = logistics_star;
    }

    public Integer getStore_star() {
        return store_star;
    }

    public void setStore_star(Integer store_star) {
        this.store_star = store_star;
    }

    public String getReview_content() {
        return review_content;
    }

    public void setReview_content(String review_content) {
        this.review_content = review_content;
    }
}
