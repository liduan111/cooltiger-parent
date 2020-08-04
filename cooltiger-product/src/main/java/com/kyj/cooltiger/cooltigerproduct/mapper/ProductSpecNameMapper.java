package com.kyj.cooltiger.cooltigerproduct.mapper;

import com.kyj.cooltiger.cooltigerproduct.entity.ProductSpecName;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author liduan
 * Description: 商品规格名mapper
 * date: 2020/8/4 14:27
 */
@Repository
public interface ProductSpecNameMapper {

    /**
     * 添加商品规格名
     * @param productSpecName
     */
    public void addProductSpecName(@Param("productSpecName") ProductSpecName productSpecName);
}
