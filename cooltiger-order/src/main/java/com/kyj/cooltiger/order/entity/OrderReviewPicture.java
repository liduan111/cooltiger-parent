package com.kyj.cooltiger.order.entity;

import lombok.Data;

/**
 * @author liduan
 * Description: 订单评价图片表
 * date: 2020/9/10 10:55
 */
@Data
public class OrderReviewPicture {
    private static final long seriableUUID=1L;

    //评价图片ID
    private Integer pic_id;
    //评价ID
    private Integer review_id;
    //图片url
    private String pic_url;
}
