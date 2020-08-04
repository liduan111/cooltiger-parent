package com.kyj.cooltiger.cooltigerproduct.mapper;

import com.kyj.cooltiger.cooltigerproduct.entity.ProductInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author liduan
 * Description: 商品信息Mapper
 * date: 2020/7/28 11:25
 */
@Repository
public interface ProductInfoMapper {

    /**
     * 根据店铺ID获取商品总条数
     * @param storeId
     * @return
     */
    public int getTotalCountByStoreId(@Param("storeId") String storeId);

    /**
     * 添加商品基本信息
     * @param productInfo
     */
    public void addProductInfo(@Param("productInfo") ProductInfo productInfo);
}
