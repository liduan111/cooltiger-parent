package com.kyj.cooltiger.order.service;

import java.math.BigDecimal;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/9/8 15:04
 */
public interface RefundApplicationService {

    boolean  saves(Integer received, BigDecimal refundPrice, Integer orderId, Long userId, String refundDesc, Integer reasonId, String picturesurl);

}
