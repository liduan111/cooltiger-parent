package com.kyj.cooltiger.order.mapper;

import com.kyj.cooltiger.feign.order.vo.OrderInfoListRespVo;
import com.kyj.cooltiger.order.entity.OrderInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author guoxq
 * Description: 订单信息mapper
 * date 2020/8/17 16:57
 */
@Mapper
public interface OrderInfoMapper {

    /**
     * 查询订单列表总数
     *
     * @param storeId     店铺ID
     * @param userId      用户ID
     * @param orderStatus 订单状态
     * @param dateStart   开始时间
     * @param dateEnd     结束时间
     * @param keyword     关键词
     * @return
     */
    public int getOrderListTotalCount(
            @Param("storeId") Integer storeId, @Param("userId") Integer userId,
            @Param("orderStatus") Integer orderStatus, @Param("dateStart") String dateStart,
            @Param("dateEnd") String dateEnd, @Param("keyword") String keyword);

    /**
     * 查询订单信息列表
     *
     * @param storeId     店铺ID
     * @param userId      用户ID
     * @param orderStatus 订单状态
     * @param dateStart   开始时间
     * @param dateEnd     结束时间
     * @param keyword     关键词
     * @param pageStart   分页起始
     * @param pageSize    分页单位
     * @return
     */
    public List<OrderInfoListRespVo> getOrderListByStoreId$UserId(
            @Param("storeId") Integer storeId, @Param("userId") Integer userId,
            @Param("orderStatus") Integer orderStatus, @Param("dateStart") String dateStart,
            @Param("dateEnd") String dateEnd, @Param("keyword") String keyword,
            @Param("pageStart") int pageStart, @Param("pageSize") Integer pageSize);

    /**
     * 插入订单信息
     *
     * @param orderInfo 订单信息
     */
    public int insertOrderInfo(@Param("orderInfo") OrderInfo orderInfo);
}
