package com.kyj.cooltiger.order.service;

import com.kyj.cooltiger.feign.order.vo.OrderReviewReqVo;
import com.kyj.cooltiger.order.entity.OrderReview;

import java.util.List;
import java.util.Map;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/9/9 11:53
 */
public interface OrderReviewService {

    /**
     * 添加订单评价信息
     *
     * @param userId           用户ID
     * @param orderReviewReqVo 评价信息
     * @param picUrls          评价图片url
     */
    public void commitOrderReview(Long userId, OrderReviewReqVo orderReviewReqVo, List<String> picUrls);

    /**
     * 查询商品评价列表
     *
     * @param storeId   店铺ID
     * @param productId 商品ID
     * @param keyword   评价类型（1-好评2-中评3-差评）
     * @param skuId     商品skuID
     * @param pageNo    当前页码
     * @param pageSize  分页单位
     * @return
     */
    public Map<String, Object> getOrderReviewList(Integer storeId, Integer productId, Integer keyword, Integer skuId, Integer pageNo, Integer pageSize);
}
