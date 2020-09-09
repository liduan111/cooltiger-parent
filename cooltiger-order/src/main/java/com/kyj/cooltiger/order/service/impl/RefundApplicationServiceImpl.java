package com.kyj.cooltiger.order.service.impl;

import com.kyj.cooltiger.order.entity.RefundApplication;
import com.kyj.cooltiger.order.mapper.RefundApplicationMapper;
import com.kyj.cooltiger.order.service.RefundApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/9/8 15:04
 */
@Service
public class RefundApplicationServiceImpl implements RefundApplicationService {

    @Autowired
    private RefundApplicationMapper refundApplicationMapper;

    @Override
    public boolean saves(Integer received, BigDecimal refundPrice, Integer orderId, Long userId, String refundDesc, Integer reasonId, String picturesurl) {

        RefundApplication refundApplication=new RefundApplication();
        refundApplication.setReceived(received);
        refundApplication.setRefundPrice(refundPrice);
        refundApplication.setOrderId(orderId);
        refundApplication.setUserId(userId);
        refundApplication.setRefundDesc(refundDesc);
        refundApplication.setReasonId(reasonId);
        refundApplication.setProofPicture(picturesurl);
        refundApplication.setDeleted(0);
        refundApplication.setHandleSatus(0);
        refundApplication.setCreateTime(new Date());
        if (refundApplication!=null||!refundApplication.equals("")){
            int i=refundApplicationMapper.saves(refundApplication);
            if(i>0){
                return true;
            }
        }
        return false;
    }

}
