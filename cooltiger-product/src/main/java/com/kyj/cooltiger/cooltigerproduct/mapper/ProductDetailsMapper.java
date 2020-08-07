package com.kyj.cooltiger.cooltigerproduct.mapper;

import com.kyj.cooltiger.cooltigerproduct.entity.ProductDetails;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author liduan
 * Description:
 * date: 2020/8/4 18:10
 */
@Repository
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
}
