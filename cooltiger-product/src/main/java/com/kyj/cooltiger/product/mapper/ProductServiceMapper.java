package com.kyj.cooltiger.product.mapper;

import com.kyj.cooltiger.product.entity.ProductService;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liduan
 * Description: 商品服务mapper
 * date: 2020/8/4 13:11
 */
@Mapper
public interface ProductServiceMapper {

    /**
     * 添加商品自有服务
     *
     * @param productService
     */
    public void addProductService(@Param("productService") ProductService productService);

    /**
     * 删除商品自有服务
     *
     * @param productId
     */
    public void deleteProductServiceByProductId(@Param("productId") Integer productId);

    /**
     * 根据服务Ids查询服务
     *
     * @param serviceIds
     * @return
     */
    public List<ProductService> getProductServiceByIds(@Param("serviceIds") String serviceIds);

    /**
     * 根据商品Id查询服务
     *
     * @param productId
     * @return
     */
    public List<ProductService> getProductServiceByProductId(@Param("productId") Integer productId);
}
