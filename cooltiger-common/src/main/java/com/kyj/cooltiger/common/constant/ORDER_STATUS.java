package com.kyj.cooltiger.common.constant;

/**
 * @author liduan
 * Description:订单状态（0-待付款1-待发货2-配送中3-已送达4-已完成5-退款/售后6-已取消7-支付中）
 * date: 2020/9/7 14:17
 */
public class ORDER_STATUS {

    public static final int STAY_PAYMENT = 0;
    public static final int STAY_DELIVE = 1;
    public static final int IN_DELIVERY = 2;
    public static final int DELIVERED = 3;
    public static final int COMPLETED = 4;
    public static final int REFUND_AFTER = 5;
    public static final int CANCEL = 6;
    public static final int IN_PAYMENT = 7;

}
