package com.kyj.cooltiger.product.service;

import java.util.Map;

/**
 * @author liduan
 * Description: 商品sku service
 * date: 2020/9/8 13:34
 */
public interface ProductSkuService {

    /**
     * 查询商品sku信息
     *
     * @param skuId
     * @return
     */
    public Map<String,Object> getProductSku(Integer skuId);

    /**
     * 查询商品sku列表
     *
     * @param productId
     * @return
     */
    public Map<String, Object> getProductSkuList(Integer productId);
}
