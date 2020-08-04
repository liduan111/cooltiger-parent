package com.kyj.cooltiger.cooltigerproduct.mapper;

import com.kyj.cooltiger.cooltigerproduct.entity.ProductSpecValue;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author liduan
 * Description: 商品规格值mapper
 * date: 2020/8/4 14:32
 */
@Repository
public interface ProductSpecValueMapper {

    /**
     * 添加商品规格值
     * @param productSpecValue
     */
    public void addProductSpecValue(@Param("productSpecValue") ProductSpecValue productSpecValue);
}
