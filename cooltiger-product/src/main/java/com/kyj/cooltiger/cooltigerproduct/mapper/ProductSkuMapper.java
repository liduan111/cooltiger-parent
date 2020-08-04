package com.kyj.cooltiger.cooltigerproduct.mapper;

import com.kyj.cooltiger.cooltigerproduct.entity.ProductSku;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

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
}
