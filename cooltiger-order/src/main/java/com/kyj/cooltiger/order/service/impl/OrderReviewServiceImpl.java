package com.kyj.cooltiger.order.service.impl;

import com.kyj.cooltiger.common.excep.MyException;
import com.kyj.cooltiger.common.utils.PageUtil;
import com.kyj.cooltiger.feign.order.vo.OrderReviewListRespVo;
import com.kyj.cooltiger.feign.order.vo.OrderReviewReqVo;
import com.kyj.cooltiger.order.entity.OrderInfo;
import com.kyj.cooltiger.order.entity.OrderReview;
import com.kyj.cooltiger.order.entity.OrderReviewPicture;
import com.kyj.cooltiger.order.mapper.OrderInfoMapper;
import com.kyj.cooltiger.order.mapper.OrderReviewMapper;
import com.kyj.cooltiger.order.mapper.OrderReviewPictureMapper;
import com.kyj.cooltiger.order.service.OrderReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/9/9 13:08
 */
@Service
public class OrderReviewServiceImpl implements OrderReviewService {

    @Autowired
    private OrderReviewMapper orderReviewMapper;
    @Autowired
    private OrderInfoMapper orderInfoMapper;
    @Autowired
    private OrderReviewPictureMapper orderReviewPictureMapper;

    /**
     * 添加订单评价信息
     *
     * @param userId           用户ID
     * @param orderReviewReqVo 评价信息
     * @param picUrls          评价图片url
     */
    @Transactional
    @Override
    public void commitOrderReview(Long userId, OrderReviewReqVo orderReviewReqVo, List<String> picUrls) {
        OrderInfo orderInfo = orderInfoMapper.getOrderInfoByOrderId(orderReviewReqVo.getOrder_id());
        if (orderInfo == null) {
            throw new MyException("ORDER_INFO_NOT_EXIST", "订单信息不存在");
        }
        OrderReview orderReview = new OrderReview();
        orderReview.setUserId(userId);
        orderReview.setStoreId(orderReviewReqVo.getStore_id());
        orderReview.setProductId(orderReviewReqVo.getProduct_id());
        orderReview.setSkuId(orderReviewReqVo.getSku_id());
        orderReview.setOrderId(orderReviewReqVo.getOrder_id());
        orderReview.setAnonymous(orderReviewReqVo.getAnonymous());
        orderReview.setReviewStar(orderReviewReqVo.getReview_star());
        orderReview.setLogisticsStar(orderReviewReqVo.getLogistics_star());
        orderReview.setStoreStar(orderReviewReqVo.getStore_star());
        orderReview.setReviewContent(orderReviewReqVo.getReview_content());
        orderReview.setReviewTime(new Date());
        orderReview.setReplyStatus(0);
        orderReviewMapper.insertOrderReview(orderReview);
        orderInfo.setReviewStatus(1);
        orderInfo.setModifiedTime(new Date());
        orderInfoMapper.updateOrderInfo(orderInfo);
        if (picUrls != null) {
            List<OrderReviewPicture> pictures = new ArrayList<>();
            OrderReviewPicture picture = null;
            for (String picUrl : picUrls) {
                picture = new OrderReviewPicture();
                picture.setReview_id(orderReview.getReviewId());
                picture.setPic_url(picUrl);
                pictures.add(picture);
            }
            orderReviewPictureMapper.batchInsertOrderReviewPicture(pictures);
        }
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
    @Override
    public Map<String, Object> getOrderReviewList(Integer storeId, Integer productId, Integer keyword, Integer skuId, Integer pageNo, Integer pageSize) {
        int totalCount = orderReviewMapper.getOrderReviewCount(storeId,productId,keyword,skuId);
        PageUtil<Object> pageUtil = new PageUtil<>(pageNo, pageSize, totalCount);
        List<OrderReviewListRespVo> orderReviewListRespVos = null;
        if (totalCount > 0){
            int pageStart = (pageUtil.getPageNo() - 1) * pageUtil.getPageSize();
            orderReviewListRespVos = orderReviewMapper.getOrderReviewList(storeId,productId,keyword,skuId,pageStart,pageSize);
        }
        Map<String, Object> res = new HashMap<>();
        return res;
    }
}
