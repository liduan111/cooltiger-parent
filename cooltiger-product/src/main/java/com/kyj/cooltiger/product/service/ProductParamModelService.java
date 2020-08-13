package com.kyj.cooltiger.product.service;

import com.kyj.cooltiger.feign.product.vo.ProductParamModelReqVo;

import java.util.List;
import java.util.Map;

/**
 * @author liduan
 * Description: 商品参数模板service接口
 * date: 2020/8/12 16:56
 */
public interface ProductParamModelService {

    /**
     * 添加商品参数模板
     *
     * @param categoryId
     * @param paramModelReqVos
     * @return
     */
    public void addProductParamModel(Integer categoryId, List<ProductParamModelReqVo> paramModelReqVos);

    /**
     * 查询商品参数模板
     *
     * @param categoryId
     * @return
     */
    public Map<String, Object> getProductParamModel(Integer categoryId);

    /**
     * 修改商品参数模板
     *
     * @param categoryId
     * @param paramModelReqVos
     */
    public void updateProductParamModel(Integer categoryId, List<ProductParamModelReqVo> paramModelReqVos);

    /**
     * 删除商品模板
     *
     * @param categoryId
     * @return
     */
    public void delProductParamModel(Integer categoryId);
}
