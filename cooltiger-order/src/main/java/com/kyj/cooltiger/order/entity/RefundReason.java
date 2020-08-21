package com.kyj.cooltiger.order.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/8/20 9:16
 * 退款原因
 */
@Data
public class RefundReason  implements Serializable {

    private  static  final long serialVersionUID=1L;
    //退款原因类型ID
    private Integer reasonId;
    //售后类型（1-退款1-退货退款）
    private Integer aftersaleType;
    //是否已收到货（0-未收到货1-已收到货）
    private Integer received;
    //退款原因
    private String  reasonName;


}
