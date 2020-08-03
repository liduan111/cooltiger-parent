package com.kyj.cooltiger.cooltigerproduct.mapper;

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
}
