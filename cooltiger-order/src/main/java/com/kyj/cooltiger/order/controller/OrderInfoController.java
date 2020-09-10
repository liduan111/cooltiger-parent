package com.kyj.cooltiger.order.controller;

import com.alibaba.fastjson.JSONObject;
import com.kyj.cooltiger.common.utils.Result;
import com.kyj.cooltiger.feign.order.client.OrderInfoClient;
import com.kyj.cooltiger.feign.order.vo.PlaceOrderReqVo;
import com.kyj.cooltiger.feign.order.vo.ProductSettlementReqVo;
import com.kyj.cooltiger.feign.order.vo.ProductSettlementRespVo;
import com.kyj.cooltiger.feign.product.client.ProductSkuClient;
import com.kyj.cooltiger.feign.product.client.StoreInfoClient;
import com.kyj.cooltiger.feign.product.vo.ProductSkuRespVo;
import com.kyj.cooltiger.order.service.OrderInfoService;
import org.apache.commons.beanutils.BeanMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @author guoxq
 * Description: 订单信息controller
 * @date 2020/8/17 16:09
 */
@RestController
@RequestMapping("/order/orderInfo")
public class OrderInfoController implements OrderInfoClient {

    @Autowired
    private OrderInfoService orderInfoService;
    @Autowired
    private StoreInfoClient storeInfoClient;
    @Autowired
    private ProductSkuClient productSkuClient;

    /**
     * 查询店铺订单列表信息
     *
     * @param storeId      店铺ID
     * @param userId       用户ID
     * @param orderStatus  订单状态（0-待付款1-待发货2-配送中3-已送达4-已完成5-已评价6-售后）
     * @param reviewStatus 评价状态（0-未评价1-已评价）
     * @param dateStart    开始时间
     * @param dateEnd      结束时间
     * @param keyword      关键词
     * @param pageNo       当前页
     * @param pageSize     分页单位
     * @return
     */
    @Override
    @RequestMapping(value = "/getOrderList", method = {RequestMethod.GET})
    public Result getOrderList(
            @RequestParam(value = "store_id", required = false) Integer storeId,
            @RequestParam(value = "user_id", required = false) Integer userId,
            @RequestParam(value = "order_status", required = false) Integer orderStatus,
            @RequestParam(value = "review_status", required = false) Integer reviewStatus,
            @RequestParam(value = "date_start", required = false) String dateStart,
            @RequestParam(value = "date_end", required = false) String dateEnd,
            @RequestParam(value = "keyword", required = false) String keyword,
            @RequestParam(value = "page_no", defaultValue = "1") Integer pageNo,
            @RequestParam(value = "page_size", defaultValue = "10") Integer pageSize) {
        Map<String, Object> res = orderInfoService.getOrderList(storeId, userId, orderStatus, reviewStatus, dateStart, dateEnd, keyword, pageNo, pageSize);
        return Result.success(res);
    }

    /**
     * 购物车或商品结算
     *
     * @param userId                     用户ID
     * @param productSettlementReqVoList 结算信息入参
     * @return
     */
    @Override
    @RequestMapping(value = "/settlement", method = {RequestMethod.POST})
    public Result settlement(
            @RequestParam("user_id") Integer userId,
            @RequestBody List<ProductSettlementReqVo> productSettlementReqVoList) {
        //店铺ID集合
        Set<Integer> storeIds = new HashSet<>();
        for (ProductSettlementReqVo productSettlementReqVo : productSettlementReqVoList) {
            storeIds.add(productSettlementReqVo.getStoreId());
        }
        List<ProductSettlementRespVo> respVoList = new ArrayList<>();
        ProductSettlementRespVo productSettlementRespVo = null;
        List<ProductSettlementRespVo.Sku> skuList = null;
        ProductSettlementRespVo.Sku sku = null;
        for (Integer storeId : storeIds) {
            productSettlementRespVo = new ProductSettlementRespVo();
            skuList = new ArrayList<>();
            Result storeInfo = storeInfoClient.getStoreInfo(storeId);
            Map storeInfoMap = new BeanMap(storeInfo.getData());
            productSettlementRespVo.setStoreId(storeId);
            productSettlementRespVo.setStoreName((String) storeInfoMap.get("storeName"));
            for (ProductSettlementReqVo productSettlementReqVo : productSettlementReqVoList) {
                if (storeId.equals(productSettlementReqVo.getStoreId())) {
                    sku = productSettlementRespVo.new Sku();
                    sku.setCartId(productSettlementReqVo.getCartId());
                    ProductSkuRespVo productSkuRespVo = (ProductSkuRespVo) productSkuClient.getProductSku(productSettlementReqVo.getSkuId()).getData();
                    sku.setProductId(productSkuRespVo.getProductId());
                    sku.setProductTitle(productSkuRespVo.getProductTitle());
                    sku.setProductFreightType(productSkuRespVo.getProductFreightType());
                    sku.setSkuId(productSkuRespVo.getSkuId());
                    sku.setSkuUrl(productSkuRespVo.getSkuUrl());
                    sku.setSkuSpecValues(productSkuRespVo.getSpecValues());
                    sku.setSalePrice(productSkuRespVo.getSalePrice());
                    sku.setSkuNumber(productSettlementReqVo.getSkuNumber());
                    skuList.add(sku);
                }
            }
            productSettlementRespVo.setSkus(skuList);
            respVoList.add(productSettlementRespVo);
        }
        //计算金额
        int totalCount = 0;
        double totalPrice = 0d;
        for (ProductSettlementRespVo respVo : respVoList) {
            Integer smallCount = 0;
            double smallPrice = 0d;
            double frightPrice = 0d;
            double totalWeight = 0d;
            Map freightMap = null;
            for (ProductSettlementRespVo.Sku sku1 : respVo.getSkus()) {
                double salePrice = sku1.getSalePrice().doubleValue();
                int skuNumber = sku1.getSkuNumber().intValue();
                smallCount += skuNumber;
                smallPrice += salePrice * skuNumber;
                if (sku1.getProductFreightType().equals(1)) {
                    double weight = sku1.getWeight().doubleValue();
                    totalWeight += weight * skuNumber;
                }
            }
            //重量计费
            if (totalWeight > 0) {
                freightMap = new BeanMap(storeInfoClient.getStoreFreight(respVo.getStoreId()).getData());
                frightPrice += (double) freightMap.get("freightPrice");
                double continuePrice = (double) freightMap.get("continuePrice");
                Integer whetherKg = (Integer) freightMap.get("whetherKg");
                if (totalWeight > 1) {
                    double contiuneWeight = totalWeight - 1;
                    if (whetherKg.equals(0)) {
                        frightPrice += continuePrice * contiuneWeight;
                    } else {
                        frightPrice += continuePrice * Math.ceil(contiuneWeight);
                    }
                }
            }
            respVo.setSmallCount(smallCount);
            respVo.setSmallPrice(smallPrice);
            respVo.setFreightPrice(frightPrice);
            totalCount += smallCount;
            totalPrice += smallPrice;
        }
        Map<String, Object> res = new HashMap<>();
        res.put("data", respVoList);
        res.put("totalCount", totalCount);
        res.put("totalPrice", totalPrice);
        return Result.success(res);
    }

    /**
     * 用户下单
     *
     * @param userId          用户ID
     * @param sourceType      订单来源（0-pc 1-小程序 2-app）
     * @param placeOrderReqVo 下单信息
     * @return
     */
    @Override
    @RequestMapping(value = "/placeOrder", method = {RequestMethod.POST})
    public Result placeOrder(
            @RequestParam("user_id") Integer userId,
            @RequestParam("source_type") Integer sourceType,
            @RequestBody PlaceOrderReqVo placeOrderReqVo) {
        Map<String, Object> res = orderInfoService.placeOrder(userId, placeOrderReqVo, sourceType);
        return Result.success(res.get("data"));
    }
}
