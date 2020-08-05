package com.kyj.cooltiger.cooltigerproduct.mapper;

import com.kyj.cooltiger.cooltigerproduct.entity.StoreInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author liduan
 * Description: 店铺信息mapper
 * date: 2020/8/5 16:54
 */
@Repository
public interface StoreInfoMapper {

    /**
     * 添加店铺信息
     * @param storeInfo
     */
    public void addStoreInfo(@Param("storeInfo") StoreInfo storeInfo);
}
