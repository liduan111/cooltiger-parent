package com.kyj.cooltiger.order.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/8/20 10:57
 * 售后实体
 */
@Data
public class AfterSale implements Serializable {

    private static final long seriableUUID=1L;

    //退货退款id
    private  Integer refundId;
    //订单id
    private  Integer orderId;
    //用户id
    private  Long userId;
    //商品标题
    private String title;
    //店铺名称
    private String storeName;
    //退款金额
    private BigDecimal refundPrice;
    //是否删除 1：已删除  0：未删除
    private Integer deleted;
    //商品图片
    private  String picturl;
    //售后类型（1-退款2-退货退款）
    private Integer aftersaleType;
    //创建时间
    private Date createTime;
    //最后修改时间
    private Date updateTime;
    //退款编号
    private String refundCode;
    //商户处理时间
    private  Date handleTime;
    //是否已收到货（0-未收到货1-已收到货）
    private Integer received;



}
