package com.kyj.cooltiger.product.service;

import com.kyj.cooltiger.feign.product.vo.ProductBrandInfoReqVo;

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
     * @param productBrandInfoReqVo
     * @return
     */
    public void addProductBrandInfo(ProductBrandInfoReqVo productBrandInfoReqVo);

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
     * 修改品牌信息
     *
     * @param brandId
     * @param productBrandInfoReqVo
     */
    public void updateProductBrandInfo(Integer brandId, ProductBrandInfoReqVo productBrandInfoReqVo);

    /**
     * 删除品牌信息
     *
     * @param brandId
     */
    public void delProductBrandInfo(Integer brandId);
}
