package com.kyj.cooltiger.cooltigerproduct.service;

import com.kyj.cooltiger.cooltigerfeign.product.vo.ProductBrandInfoReqVo;

/**
 * @author liduan
 * Description: 商品品牌service接口
 * date: 2020/8/11 15:38
 */
public interface ProductBrandInfoService {

    /**
     * 添加品牌信息
     * @param productBrandInfoReqVo
     * @return
     */
    public void addProductBrandInfo(ProductBrandInfoReqVo productBrandInfoReqVo);
}
