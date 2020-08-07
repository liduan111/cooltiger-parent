package com.kyj.cooltiger.cooltigerproduct.mapper;

import com.kyj.cooltiger.cooltigerproduct.entity.ProductSku;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liduan
 * Description:
 * date: 2020/8/4 15:50
 */
@Repository
public interface ProductSkuMapper {

    /**
     * 添加商品sku
     * @param productSku
     */
    public void addProductSku(@Param("productSku") ProductSku productSku);

    /**
     * 删除商品sku信息
     * @param productId
     */
    public void deleteProductSku(@Param("productId") Integer productId);

    /**
     * 根据商品ID获取商品Sku列表
     * @param productId
     * @return
     */
    public List<ProductSku> getProductSkuListByProductId(@Param("productId") Integer productId);
}
