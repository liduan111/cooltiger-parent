package com.kyj.cooltiger.order.entity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

/**
 * @author guoxq
 * Description: 订单信息表
 * @date 2020/8/17 16:15
 */
@Data
public class OrderInfo implements Serializable {
    /** 版本号 */
    private static final long serialVersionUID = 1L;

    //订单ID
    private Integer orderId;
    //订单编号
    private String orderCode;
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
    //订单状态（0-待付款1-待发货2-配送中3-已送达4-已完成5-已评价6-售后
    private Integer orderStatus;
    //支付付方式（1-微信2-支付宝3-网银）
    private Integer payType;
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
    //订单来源（0-pc1-小程序 2-app）
    private Integer sourceType;
    //删除状态(0-未删除1-已删除）
    private Integer deleted;
    //提交时间
    private Date createTime;
    //修改时间
    private Date modifiedTime;

}
