package com.kyj.cooltiger.product.service;

import com.kyj.cooltiger.product.entity.ProductBrandInfo;

import java.util.Map;

/**
 * @author liduan
 * Description: 商品品牌service接口
 * date: 2020/8/11 15:38
 */
public interface ProductBrandInfoService {

    /**
     * 添加品牌信息
     *
     * @param brandName 品牌名称
     * @param brandDesc 品牌描述
     * @param brandOrder 排序
     * @param brandStatus 品牌状态
     * @param brandLogoUrl 品牌logourl
     * @return
     */
    public void addProductBrandInfo(String brandName, String brandDesc, Integer brandOrder, Integer brandStatus,
                                    String brandLogoUrl);

    /**
     * 查询品牌信息列表
     *
     * @param pageNo
     * @param pageSize
     * @param keyword
     * @return
     */
    public Map<String, Object> getProductBrandInfoList(Integer pageNo, Integer pageSize, String keyword);

    /**
     * 修改商品品牌信息
     *
     * @param brandId 品牌ID
     * @param brandName 品牌名称
     * @param brandDesc 品牌描述
     * @param brandOrder 排序
     * @param brandStatus 品牌状态 0-未启用1-已启用
     * @param brandLogoUrl 品牌logoUrl
     * @return
     */
    public void updateProductBrandInfo(Integer brandId, String brandName, String brandDesc, Integer brandOrder,
                                       Integer brandStatus, String brandLogoUrl);

    /**
     * 删除品牌信息
     *
     * @param brandId 品牌ID
     */
    public void delProductBrandInfo(Integer brandId);

    /**
     * 获取品牌信息
     *
     * @param brandId 品牌ID
     * @return
     */
    public ProductBrandInfo getProductBrandInfo(Integer brandId);
}
