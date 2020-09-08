package com.kyj.cooltiger.order.mapper;

import com.kyj.cooltiger.feign.order.vo.OrderDetailListRespVo;
import com.kyj.cooltiger.order.entity.OrderDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liduan
 * Description: 订单详情信息mapper
 * date: 2020/9/3 15:59
 */
@Mapper
public interface OrderDetailMapper {

    /**
     * 根据订单ID获取订单详情列表
     *
     * @param orderId
     * @return
     */
    public List<OrderDetailListRespVo> getOrderDetailListByOrderId(@Param("orderId") Integer orderId);

    /**
     * 批量插入订单详情信息
     *
     * @param orderDetails
     */
    public void batchInsertOrderDetail(@Param("list") List<OrderDetail> orderDetails);
}
