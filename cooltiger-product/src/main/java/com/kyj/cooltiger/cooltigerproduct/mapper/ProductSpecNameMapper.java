package com.kyj.cooltiger.cooltigerproduct.mapper;

import com.kyj.cooltiger.cooltigerproduct.entity.ProductSpecName;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liduan
 * Description: 商品规格名mapper
 * date: 2020/8/4 14:27
 */
@Mapper
public interface ProductSpecNameMapper {

    /**
     * 添加商品规格名
     * @param productSpecName
     */
    public void addProductSpecName(@Param("productSpecName") ProductSpecName productSpecName);

    /**
     * 查询商品规格名集合
     * @param productId
     * @return
     */
    public List<ProductSpecName> getProductSpecNameListByProductId(@Param("productId") Integer productId);

    /**
     * 删除商品规格名
     * @param productId
     */
    public void deleteProductSpecNameByProductId(@Param("productId") Integer productId);
}
