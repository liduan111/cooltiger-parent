package com.kyj.cooltiger.order.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/9/9 14:05
 */
@Data
public class OrderReview implements Serializable {

    private static final long seriableUUID=1L;

    //评论id
    private  Integer reviewId;
    //用户id
    private  Long userId;
    //店铺id
    private  Integer storeId;
    //商品id
    private  Integer productId;
    //skuid
    private  Integer skuId;
    //订单id
    private  Integer orderId;
    //是否匿名评价（0-否1-是）
    private Integer anonymous;
    //商品评价星级（1-5星）
    private Integer reviewStar;
    //物流服务星级（1-5星
    private Integer logisticsStar;
    //店铺服务星级（1-5星）
    private Integer storeStar;
    //评价内容
    private String reviewContent;
    //评价时间
    private Date reviewTime;
    //回复状态（0-未回复1-已回复）
    private Integer replyStatus;
    //回复内容
    private String  replyContent;
    //回复时间
    private Date replyTime;

}
