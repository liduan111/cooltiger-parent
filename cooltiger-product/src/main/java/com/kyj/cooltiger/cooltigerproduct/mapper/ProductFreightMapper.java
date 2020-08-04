package com.kyj.cooltiger.cooltigerproduct.mapper;

import com.kyj.cooltiger.cooltigerproduct.entity.ProductFreight;
import org.apache.ibatis.annotations.Param;

/**
 * @author liduan
 * Description: 商品运费mapper
 * date: 2020/8/4 17:42
 */
public interface ProductFreightMapper {
    /**
     * 添加商品运费
     * @param productFreight
     */
    public void addProductFreight(@Param("productFreight") ProductFreight productFreight);
}
