package com.kyj.cooltiger.product.service.impl;

import com.kyj.cooltiger.feign.product.vo.ProductParamModelReqVo;
import com.kyj.cooltiger.product.mapper.ProductParamModelMapper;
import com.kyj.cooltiger.product.service.ProductParamModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liduan
 * Description: 商品参数模板service
 * date: 2020/8/12 16:57
 */
@Service
public class ProductParamModelServiceImpl implements ProductParamModelService {
    @Autowired
    private ProductParamModelMapper productParamModelMapper;

    /**
     * 添加商品参数模板
     *
     * @param categoryId
     * @param paramModelReqVos
     * @return
     */
    @Override
    public void addProductParamModel(Integer categoryId, List<ProductParamModelReqVo> paramModelReqVos) {

    }
}
