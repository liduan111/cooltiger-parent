package com.kyj.cooltiger.order.service;

import com.kyj.cooltiger.order.entity.RefundReason;

import java.util.List;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/8/21 14:01
 */
public interface RefundReasonService {
    /**
     * 查询原因类型
     * @return
     */
    List<RefundReason>  refundReasonList();
}
