package com.kyj.cooltiger.cooltigerproduct.mapper;

import com.kyj.cooltiger.cooltigerfeign.product.vo.StoreInfoListRespVo;
import com.kyj.cooltiger.cooltigerproduct.entity.StoreInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liduan
 * Description: 店铺信息mapper
 * date: 2020/8/5 16:54
 */
@Mapper
public interface StoreInfoMapper {

    /**
     * 添加店铺信息
     * @param storeInfo
     */
    public void addStoreInfo(@Param("storeInfo") StoreInfo storeInfo);

    /**
     * 查询店铺列表
     * @return
     */
    public List<StoreInfoListRespVo> getStoreList();

    /**
     * 查询店铺信息
     * @param storeId
     * @return
     */
    public StoreInfo getStoreInfo(@Param("storeId") Integer storeId);

    /**
     * 更新店铺信息
     * @param storeInfo
     */
    public void updateStoreInfo(@Param("storeInfo") StoreInfo storeInfo);
}
