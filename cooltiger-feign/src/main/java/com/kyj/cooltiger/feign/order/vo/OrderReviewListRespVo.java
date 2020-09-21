package com.kyj.cooltiger.feign.order.vo;

import java.util.List;

/**
 * @author liduan
 * Description: 订单评价列表返回vo
 * date: 2020/9/10 16:12
 */
public class OrderReviewListRespVo {

    //评价ID
    private Integer reviewId;
    //用户ID
    private Long userId;
    //用户头像url
    private String avatar;
    //用户昵称
    private String nickName;
    //是否匿名评价（0-否1-是）
    private Integer anonymous;
    //商品规格
    private String skuSpec;
    //评价内容
    private String reviewContent;
    //评价时间
    private String reviewTime;
    //评价图片url
    private List<String> picUrls;

    public Integer getReviewId() {
        return reviewId;
    }

    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getAnonymous() {
        return anonymous;
    }

    public void setAnonymous(Integer anonymous) {
        this.anonymous = anonymous;
    }

    public String getSkuSpec() {
        return skuSpec;
    }

    public void setSkuSpec(String skuSpec) {
        this.skuSpec = skuSpec;
    }

    public String getReviewContent() {
        return reviewContent;
    }

    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent;
    }

    public String getReviewTime() {
        return reviewTime;
    }

    public void setReviewTime(String reviewTime) {
        this.reviewTime = reviewTime;
    }

    public List<String> getPicUrls() {
        return picUrls;
    }

    public void setPicUrls(List<String> picUrls) {
        this.picUrls = picUrls;
    }
}
