package com.kyj.cooltiger.product.service;

import com.kyj.cooltiger.feign.product.vo.ProductInfoAddReqVo;

import java.util.Map;

/**
 * @author liduan
 * Description: 商品信息service接口
 * date: 2020/7/28 11:21
 */
public interface ProductInfoService {

    /**
     * 根据店铺ID获取商品列表
     * @param storeId 店铺ID
     * @param pageNo 当前页
     * @param pageSize 分页单位
     * @param categoryId 类别ID
     * @param keyword 搜索关键字
     * @return
     */
    public Map<String,Object> getProductInfoListByStoreId(Integer storeId, Integer pageNo, Integer pageSize, Integer categoryId, String keyword);

    /**
     * 添加商品信息
     * @param storeId 店铺ID
     * @param productInfoAddReqVo 商品参数
     */
    public void addProductInfo(Integer storeId, ProductInfoAddReqVo productInfoAddReqVo);

    /**
     * 查询商品信息
     * @param productId
     * @return
     */
    public Map<String, Object> getProductInfo(Integer productId);

    /**
     * 商品下架
     * @param productId
     */
    public void productInfoDownShelf(Integer productId);

    /**
     * 商品审核
     * @param productId
     */
    public void productInfoAudit(Integer productId);

    /**
     * 删除商品信息
     * @param productId
     */
    public void deleteProductInfo(Integer productId);
}
