package com.kyj.cooltiger.order.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/8/19 13:52
 * 退款实体类
 */
@Data
public class RefundApplication implements Serializable {

    private  static final long seriableid=1L;

    //退货退款id
    private  Integer refundId;
    //订单id
    private  Integer orderId;
   //用户id
    private  Long userId;
    //退款原因id
    private  Integer reasonId;
    //退款金额
    private BigDecimal refundPrice;
    //退款说明
    private String refundDesc;
    //凭证图片  多个用逗号隔开
    private String  proofPicture;
    //处理状态（0-未处理1-已处理）
    private Integer handleSatus;
    //是否同意（0-拒绝1-同意）
    private Integer isAgree;
    //创建时间
    private Date createTime;
    //最后修改时间
    private Date updateTime;
    //是否删除 1：已删除  0：未删除
    private Integer deleted;
    //退款编号
    private String refundCode;
    //商户处理时间
    private  Date handleTime;
    //是否已收到货（0-未收到货1-已收到货）
    private Integer received;








}
