package com.kyj.cooltiger.cooltigerproduct.service;

/**
 * @author liduan
 * Description: 商品信息interface
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
    public Object getProductInfoListByStoreId(String storeId, Integer pageNo, Integer pageSize, Integer categoryId, String keyword);
}
