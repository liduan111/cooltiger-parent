package com.kyj.cooltiger.cooltigerproduct.mapper;

import com.kyj.cooltiger.cooltigerproduct.entity.ProductService;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author liduan
 * Description: 商品服务mapper
 * date: 2020/8/4 13:11
 */
@Mapper
public interface ProductServiceMapper {

    /**
     * 添加商品自有服务
     * @param productService
     */
    public void addProductService(@Param("productService") ProductService productService);

    /**
     * 删除商品自有服务
     * @param productId
     */
    public void deleteProductServiceByProductId(@Param("productId") Integer productId);
}
