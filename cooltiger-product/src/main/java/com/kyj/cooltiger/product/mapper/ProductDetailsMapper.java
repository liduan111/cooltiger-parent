package com.kyj.cooltiger.product.mapper;

import com.kyj.cooltiger.product.entity.ProductDetails;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author liduan
 * Description:
 * date: 2020/8/4 18:10
 */
@Mapper
public interface ProductDetailsMapper {
    /**
     * 添加商品详情
     * @param productDetails
     */
    public void addProductDetails(@Param("productDetails") ProductDetails productDetails);

    /**
     * 删除商品详情
     * @param productId
     */
    public void deleteProductDetailsByProductId(@Param("productId") Integer productId);

    /**
     * 根据商品ID获取商品详情
     *
     * @param productId
     * @return
     */
    public ProductDetails getProductDetailsByProductId(@Param("productId") Integer productId);

    /**
     * 修改商品详情
     *
     * @param productDetails
     */
    public void updateProductDetails(@Param("productDetails") ProductDetails productDetails);
}
