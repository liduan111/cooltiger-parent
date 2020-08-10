package com.kyj.cooltiger.cooltigerproduct.mapper;

import com.kyj.cooltiger.cooltigerproduct.entity.ProductFreight;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author liduan
 * Description: 商品运费mapper
 * date: 2020/8/4 17:42
 */
@Mapper
public interface ProductFreightMapper {
    /**
     * 添加商品运费
     * @param productFreight
     */
    public void addProductFreight(@Param("productFreight") ProductFreight productFreight);

    /**
     * 删除商品运费
     * @param productId
     */
    public void deleteProductFreightByProductId(@Param("productId") Integer productId);
}
