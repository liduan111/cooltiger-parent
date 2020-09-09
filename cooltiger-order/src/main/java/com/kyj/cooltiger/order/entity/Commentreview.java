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
public class Commentreview implements Serializable {

    private static final long seriableUUID=1L;

    //评论id
    private  Integer reviewId;
    //订单id
    private  Integer orderId;
    //skuid
    private  Integer skuId;
    //商品id
    private  Integer productId;
    //用户id
    private  Long userId;
    //商品标题
    private String title;
    //商品图片
    private  String picturl;
    //店铺id
    private  Integer storeId;
    //店铺名称
    private String storeName;
    //商品评价星级
    private Integer reviewStar;
    //物流服务星际
    private Integer logisticsStar;
    //店铺服务星际
    private Integer storeStar;
    //评论内容
    private String reviewContent;
    //评价时间
    private Date reviewTime;
    //回复状态
    private Integer replyStatus;
    //回复内容
    private String  replyContent;
    //回复时间
    private Date replyTime;
    //商品规格
    private String goodspev;

}
