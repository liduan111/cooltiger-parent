package com.kyj.cooltiger.order.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author liduan
 * Description: 订单详情表
 * date: 2020/8/18 15:29
 */
@Data
public class OrderDetail implements Serializable {
    /** 版本号 */
    private static final long serialVersionUID = 1L;

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

}
