package com.kyj.cooltiger.product.mapper;

import com.kyj.cooltiger.product.entity.StoreFreight;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author liduan
 * Description: 商品运费mapper
 * date: 2020/8/4 17:42
 */
@Mapper
public interface StoreFreightMapper {

    /**
     * 添加店铺运费
     *
     * @param storeFreight
     */
    public void addStoreFreight(@Param("storeFreight") StoreFreight storeFreight);

    /**
     * 根据店铺ID获取店铺运费信息
     *
     * @param storeId
     * @return
     */
    public StoreFreight getStoreFreightByStoreId(@Param("storeId") Integer storeId);
}
