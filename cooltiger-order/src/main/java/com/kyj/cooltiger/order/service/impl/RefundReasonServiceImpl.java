package com.kyj.cooltiger.order.service.impl;

import com.kyj.cooltiger.order.entity.RefundApplication;
import com.kyj.cooltiger.order.entity.RefundReason;
import com.kyj.cooltiger.order.mapper.RefundReasonMapper;
import com.kyj.cooltiger.order.service.RefundReasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/8/21 14:01
 * 退款原因
 */
@Service
public class RefundReasonServiceImpl implements RefundReasonService {

    @Autowired
    private RefundReasonMapper refundReasonMapper;

    /**
     * 查询原因类型
     * @return
     */
    @Override
    public List<RefundReason> refundReasonList() {
        return refundReasonMapper. refundReasonList();
    }


}
