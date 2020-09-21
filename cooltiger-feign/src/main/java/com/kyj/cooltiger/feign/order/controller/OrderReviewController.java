package com.kyj.cooltiger.feign.order.controller;

import com.kyj.cooltiger.common.utils.Result;
import com.kyj.cooltiger.feign.order.client.OrderReviewClient;
import com.kyj.cooltiger.feign.order.vo.OrderReviewReqVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author liduan
 * Description: 订单评价controller
 * date: 2020/9/10 14:25
 */
@RestController
@RequestMapping("/order/orderReview")
public class OrderReviewController {

    @Autowired
    private OrderReviewClient orderReviewClient;

    /**
     * 订单评价
     *
     * @param userId           用户ID
     * @param reviewPics       评价图片
     * @param orderReviewReqVo 评价参数
     * @return
     */
    @RequestMapping(value = "/commitOrderReview", method = RequestMethod.POST)
    public Result commitOrderReview(
            @RequestParam("user_id") Long userId,
            @RequestParam(value = "review_pics", required = false) MultipartFile[] reviewPics,
            OrderReviewReqVo orderReviewReqVo) {
        return orderReviewClient.commitOrderReview(userId, reviewPics, orderReviewReqVo);
    }

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
    @RequestMapping(value = "/getOrderReviewList", method = {RequestMethod.GET})
    public Result getOrderReviewList(
            @RequestParam("store_id") Integer storeId,
            @RequestParam(value = "product_id",required = false) Integer productId,
            @RequestParam(value = "keyword", required = false) Integer keyword,
            @RequestParam(value = "sku_id", required = false) Integer skuId,
            @RequestParam(value = "page_no", defaultValue = "1") Integer pageNo,
            @RequestParam(value = "page_size", defaultValue = "10") Integer pageSize) {
        return orderReviewClient.getOrderReviewList(storeId, productId, keyword, skuId, pageNo, pageSize);
    }
}
