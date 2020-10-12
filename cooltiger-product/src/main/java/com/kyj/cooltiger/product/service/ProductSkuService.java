package com.kyj.cooltiger.product.service;

import com.kyj.cooltiger.feign.product.vo.ProductSkuReqVo;
import com.kyj.cooltiger.feign.product.vo.ProductSpecReqVo;

import java.util.List;
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

    /**
     * 添加商品规格
     *
     * @param productId
     * @param specs
     */
    public Map<String,Integer> addProductSpec(Integer productId,List<ProductSpecReqVo.Spec> specs);

    /**
     * 添加商品sku信息
     *
     * @param productId       商品ID
     * @param productSkuReqVo 商品规格和sku参数
     */
    public void addProductSkuInfo(Integer productId, ProductSkuReqVo productSkuReqVo);
}
