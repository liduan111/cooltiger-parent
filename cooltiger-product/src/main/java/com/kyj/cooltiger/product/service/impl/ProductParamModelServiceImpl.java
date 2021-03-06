package com.kyj.cooltiger.product.service.impl;

import com.kyj.cooltiger.common.excep.MyException;
import com.kyj.cooltiger.feign.product.vo.ProductParamModelReqVo;
import com.kyj.cooltiger.product.entity.ProductParamModel;
import com.kyj.cooltiger.product.mapper.ProductParamModelMapper;
import com.kyj.cooltiger.product.service.ProductParamModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        List<ProductParamModel> productParamModelList = productParamModelMapper.getProductParamModelByCategoryId(categoryId);
        ProductParamModel productParamModel = null;
        for (ProductParamModelReqVo productParamModelReqVo : paramModelReqVos) {
            productParamModel = new ProductParamModel();
            productParamModel.setParamName(productParamModelReqVo.getParamName());
            productParamModel.setRequired(productParamModelReqVo.getRequired());
            productParamModel.setCategoryId(categoryId);
            productParamModelList.add(productParamModel);
        }
        //批量插入
        productParamModelMapper.batchAddProductParamModel(productParamModelList);
    }

    /**
     * 查询商品参数模板
     *
     * @param categoryId
     * @return
     */
    @Override
    public Map<String, Object> getProductParamModel(Integer categoryId) {
        List<ProductParamModel> productParamModelList = productParamModelMapper.getProductParamModelByCategoryId(categoryId);
        Map<String, Object> resMap = new HashMap<>();
        resMap.put("data", productParamModelList);
        return resMap;
    }

    /**
     * 批量删除商品模板参数
     *
     * @param paramIds 参数ID（多个用,分隔）
     * @return
     */
    @Override
    public void batchDelProductModelParam(String paramIds) {
        productParamModelMapper.batchDelProductModelByParamIds(paramIds);
    }
}
