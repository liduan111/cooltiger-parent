package com.kyj.cooltiger.cooltigerproduct.mapper;

import com.kyj.cooltiger.cooltigerproduct.entity.ProductParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author liduan
 * Description: 商品参数mapper
 * date: 2020/8/4 13:35
 */
@Mapper
public interface ProductParamMapper {

    /**
     * 添加商品参数
     * @param productParam
     */
    public void addProductParam(@Param("productParam") ProductParam productParam);

    /**
     * 删除商品参数
     * @param productId
     */
    public void deleteProductParamByProductId(@Param("productId") Integer productId);
}
