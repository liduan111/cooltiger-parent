package com.kyj.cooltiger.product.mapper;

import com.kyj.cooltiger.product.entity.ProductParamModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liduan
 * Description: 商品参数模板mapper
 * date: 2020/8/12 17:02
 */
@Mapper
public interface ProductParamModelMapper {

    /**
     * 根据分类ID查询参数模板
     *
     * @param categoryId
     * @return
     */
    public List<ProductParamModel> getProductParamModelByCategoryId(@Param("categoryId") Integer categoryId);

    /**
     * 批量添加参数模板
     *
     * @param productParamModelList
     */
    public void batchAddProductParamModel(@Param("productParamModelList") List<ProductParamModel> productParamModelList);

    /**
     * 删除商品模板
     *
     * @param categoryId
     * @return
     */
    public void delProductParamModel(@Param("categoryId") Integer categoryId);
}
