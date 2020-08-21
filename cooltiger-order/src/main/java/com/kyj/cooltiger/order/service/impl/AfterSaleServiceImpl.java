package com.kyj.cooltiger.order.service.impl;

import com.kyj.cooltiger.common.excep.MyException;
import com.kyj.cooltiger.order.entity.AfterSale;
import com.kyj.cooltiger.order.entity.RefundApplication;
import com.kyj.cooltiger.order.mapper.AfterSaleMapper;
import com.kyj.cooltiger.order.service.AfterSaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/8/20 11:09
 * 售后服务
 */
@Service
public class AfterSaleServiceImpl implements AfterSaleService {

    @Autowired
    private AfterSaleMapper afterSaleMapper;

    /**
     * 查询售后列表
     * @param map
     * @return
     */
    @Override
    public List<AfterSale> querysalelist(Map<String, Object> map) {
        return afterSaleMapper.querysalelist(map);
    }

    /**
     * 删除记录
     * @param map
     * @return
     */
    @Override
    public boolean deleterecord(Map<String, Object> map) {

        Integer  refundId=Integer.valueOf(map.get("refundId").toString());
        Integer  orderId=Integer.valueOf(map.get("orderId").toString());
        Integer  userId=Integer.valueOf(map.get("userId").toString());
        AfterSale  afterSale=afterSaleMapper.querysaleorderId(refundId,orderId,userId);
        if (afterSale.equals("")||afterSale==null){
            new MyException("SOURCE_NOT_EXIST","当前数据不存在");
        }
        AfterSale afterSale1=new AfterSale();
        afterSale1.setRefundId(afterSale.getRefundId());
        afterSale1.setOrderId(afterSale.getOrderId());
        afterSale1.setUserId(afterSale1.getUserId());
        afterSale1.setDeleted(1);
        afterSale1.setUpdateTime(new Date());
        if(afterSale1!=null||!afterSale1.equals("")){
            int i=afterSaleMapper.updatedeleted(afterSale1);
            if(i>0){
                return  true;
            }
        }
        return false;
    }

    /**
     * 退款类型
     * @param map
     * @return
     */
    @Override
    public AfterSale refundtype(Map<String, Object> map) {
        Integer  refundId=Integer.valueOf(map.get("refundId").toString());
        Integer  orderId=Integer.valueOf(map.get("orderId").toString());
        Integer  userId=Integer.valueOf(map.get("userId").toString());
        AfterSale  afterSale=afterSaleMapper.refundtype(refundId,orderId,userId);
        if (afterSale==null||afterSale.equals("")){
            new MyException("SOURCE_NOT_EXIST","当前数据不存在");
        }
        return afterSale;
    }

    /**
     * 申请退款
     * @param map
     * @return
     */
    @Override
    public RefundApplication refundappplication(Map<String, Object> map) {

        Integer  refundId=Integer.valueOf(map.get("refundId").toString());
        Integer  orderId=Integer.valueOf(map.get("orderId").toString());
        Integer  userId=Integer.valueOf(map.get("userId").toString());
        RefundApplication refundApplication=afterSaleMapper.refundappplication(refundId,orderId,userId);
        if (refundApplication==null||refundApplication.equals("")){
            new MyException("SOURCE_NOT_EXIST","当前数据不存在");
        }
        return refundApplication;
    }

    /**
     * 查看退款详情
     * @param map
     * @return
     */
    @Override
    public AfterSale looksaledetail(Map<String, Object> map) {

        Integer  refundId=Integer.valueOf(map.get("refundId").toString());
        Integer  orderId=Integer.valueOf(map.get("orderId").toString());
        Integer  userId=Integer.valueOf(map.get("userId").toString());
        AfterSale  afterSale=afterSaleMapper.looksaledetail(refundId,orderId,userId);

        return afterSale;
    }
}
