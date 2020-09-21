package com.kyj.cooltiger.order.mapper;

import com.kyj.cooltiger.feign.order.vo.OrderReviewListRespVo;
import com.kyj.cooltiger.order.entity.OrderReview;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/9/9 13:09
 */
@Mapper
public interface OrderReviewMapper {

    /**
     * 添加订单评论
     *
     * @param orderReview
     */
    public int insertOrderReview(@Param("orderReview") OrderReview orderReview);

    /**
     * 查询订单评价条数
     *
     * @param storeId   店铺ID
     * @param productId 商品ID
     * @param keyword   评价类型（1-好评2-中评3-差评）
     * @param skuId     商品skuID
     * @return
     */
    public int getOrderReviewCount(
            @Param("storeId") Integer storeId, @Param("productId") Integer productId,
            @Param("keyword") Integer keyword, @Param("skuId") Integer skuId);

    /**
     * 查询订单评价列表
     *
     * @param storeId   店铺ID
     * @param productId 商品ID
     * @param keyword   评价类型（1-好评2-中评3-差评）
     * @param skuId     商品skuID
     * @param pageStart
     * @param pageSize
     * @return
     */
    public List<OrderReviewListRespVo> getOrderReviewList(
            @Param("storeId") Integer storeId, @Param("productId") Integer productId,
            @Param("keyword") Integer keyword, @Param("skuId") Integer skuId,
            @Param("pageStart") int pageStart, @Param("pageSize") Integer pageSize);
}
