package com.kyj.cooltiger.order.service.impl;

import com.kyj.cooltiger.common.utils.PageUtil;
import com.kyj.cooltiger.feign.order.vo.OrderDetailListRespVo;
import com.kyj.cooltiger.feign.order.vo.OrderInfoListRespVo;
import com.kyj.cooltiger.order.mapper.OrderDetailMapper;
import com.kyj.cooltiger.order.mapper.OrderInfoMapper;
import com.kyj.cooltiger.order.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author guoxq
 * Description: 订单信息service实现类
 * @date 2020/8/17 16:11
 */
@Service
public class OrderInfoServiceImpl implements OrderInfoService {

    @Autowired
    private OrderInfoMapper orderInfoMapper;
    @Autowired
    private OrderDetailMapper orderDetailMapper;

    /**
     * 查询店铺订单列表信息
     *
     * @param storeId     店铺ID
     * @param userId      用户ID
     * @param orderStatus 订单状态（0-待付款1-待发货2-配送中3-已送达4-已完成5-已评价6-售后）
     * @param dateStart   开始时间
     * @param dateEnd     结束时间
     * @param keyword     关键词
     * @param pageNo      当前页
     * @param pageSize    分页单位
     * @return
     */
    @Override
    public Map<String, Object> getOrderList(Integer storeId, Integer userId, Integer orderStatus, String dateStart, String dateEnd, String keyword,
                                            Integer pageNo, Integer pageSize) {
        //查询总数
        int totalCount = orderInfoMapper.getOrderListTotalCount(storeId, userId, orderStatus, dateStart, dateEnd, keyword);
        //创建分页工具类对象
        PageUtil<Object> pageUtil = new PageUtil<>(pageNo, pageSize, totalCount);
        List<OrderInfoListRespVo> orderInfoListRespVoList = null;
        if (totalCount > 0) {
            int pageStart = (pageUtil.getPageNo() - 1) * pageUtil.getPageSize();
            orderInfoListRespVoList = orderInfoMapper.getOrderListByStoreId$UserId(storeId, userId, orderStatus, dateStart, dateEnd, keyword, pageStart, pageSize);
            List<OrderDetailListRespVo> orderDetailListRespVoList = null;
            for (OrderInfoListRespVo orderInfoListRespVo : orderInfoListRespVoList) {
                orderDetailListRespVoList = new ArrayList<>();
                orderDetailListRespVoList = orderDetailMapper.getOrderDetailListByOrderId(orderInfoListRespVo.getOrderId());
                orderInfoListRespVo.setOrderDetailListRespList(orderDetailListRespVoList);
            }
        }
        Map<String, Object> res = new HashMap<>();
        res.put("totalCount", totalCount);
        res.put("totalPage", pageUtil.getTotalPage());
        res.put("data", orderInfoListRespVoList);
        return res;
    }
}
