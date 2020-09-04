package com.kyj.cooltiger.product.mapper;

import com.kyj.cooltiger.product.entity.ProductSku;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liduan
 * Description:
 * date: 2020/8/4 15:50
 */
@Mapper
public interface ProductSkuMapper {

    /**
     * 批量添加商品sku
     *
     * @param productSkuList
     */
    public void batchAddProductSku(@Param("list") List<ProductSku> productSkuList);

    /**
     * 删除商品sku信息
     *
     * @param productId
     */
    public void deleteProductSku(@Param("productId") Integer productId);

    /**
     * 根据商品ID获取商品Sku列表
     *
     * @param productId
     * @return
     */
    public List<ProductSku> getProductSkuListByProductId(@Param("productId") Integer productId);

    /**
     * 根据skuId获取信息
     *
     * @param skuId
     * @return
     */
    public ProductSku getProductSkuBySkuId(@Param("skuId") Integer skuId);
}
