package com.kyj.cooltiger.order.service;

import com.kyj.cooltiger.order.entity.AfterSale;
import com.kyj.cooltiger.order.entity.RefundApplication;

import java.util.List;
import java.util.Map;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/8/20 11:08
 */
public interface AfterSaleService {
    /**
     * 查询售后列表查询
     * @param map
     * @return
     */
    List<AfterSale>  querysalelist(Map<String,Object> map);

    /**
     * 删除记录
     * @param map
     * @return
     */
    boolean  deleterecord(Map<String,Object> map);

    /**
     * 查看退款详情
     * @param map
     * @return
     */
    AfterSale  looksaledetail(Map<String,Object>  map);

    /**
     * 退款类型
     * @param map
     * @return
     */
    AfterSale  refundtype(Map<String,Object>  map);

    /**+
     * 申请退款
     * @param map
     * @return
     */
    AfterSale refundappplication(Map<String,Object> map);


}
