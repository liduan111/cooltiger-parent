package com.kyj.cooltiger.order.mapper;

import com.kyj.cooltiger.order.entity.AfterSale;
import com.kyj.cooltiger.order.entity.RefundApplication;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/8/20 11:10
 */
@Mapper
public interface AfterSaleMapper {
    /**
     * 查询售后列表
     * @param map
     * @return
     */
    List<AfterSale> querysalelist(Map<String, Object> map);

    /**
     *
     * @param refundId
     * @param orderId
     * @param userId
     * @return
     */
    AfterSale  querysaleorderId(@Param("refundId") Integer refundId, @Param("orderId")Integer orderId, @Param("userId")Integer userId);

    /**
     * 修改删除状态
     * @param afterSale1
     * @return
     */
    int  updatedeleted(@Param("afterSale1") AfterSale afterSale1);

    /**
     * 查看订单详情
     * @param refundId
     * @param orderId
     * @param userId
     * @return
     */
    AfterSale  looksaledetail(@Param("refundId") Integer refundId, @Param("orderId")Integer orderId, @Param("userId")Integer userId);

    /**
     * 退款类型
     * @param refundId
     * @param orderId
     * @param userId
     * @return
     */
    AfterSale   refundtype(@Param("refundId") Integer refundId, @Param("orderId")Integer orderId, @Param("userId")Integer userId);

    /**
     * 申请退款
     * @param refundId
     * @param orderId
     * @param userId
     * @return
     */
    RefundApplication  refundappplication(@Param("refundId") Integer refundId, @Param("orderId")Integer orderId, @Param("userId")Integer userId);


}
