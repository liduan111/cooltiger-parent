package com.kyj.cooltiger.product.mapper;

import com.kyj.cooltiger.feign.product.vo.StoreInfoListRespVo;
import com.kyj.cooltiger.feign.product.vo.StoreReviewScoreResqVo;
import com.kyj.cooltiger.product.entity.StoreInfo;
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
     *
     * @param storeInfo
     */
    public int addStoreInfo(@Param("storeInfo") StoreInfo storeInfo);

    /**
     * 根据关键字查询总条数
     *
     * @param keyword
     * @return
     */
    public int getTotalCountByKeyword(@Param("keyword") String keyword);

    /**
     * 查询店铺列表
     *
     * @return
     */
    public List<StoreInfoListRespVo> getStoreListByKeyword(
            @Param("keyword") String keyword,@Param("pageStart") Integer pageStart,@Param("pageSize") Integer pageSize);

    /**
     * 查询店铺信息
     *
     * @param storeId
     * @return
     */
    public StoreInfo getStoreInfo(@Param("storeId") Integer storeId);

    /**
     * 更新店铺信息
     *
     * @param storeInfo
     */
    public void updateStoreInfo(@Param("storeInfo") StoreInfo storeInfo);

    /**
     * 根据店铺名称查询店铺个数
     *
     * @param storeName
     * @return
     */
    public int getStoreInfoCountByStoreName(@Param("storeName") String storeName);

    /**
     * 查询店铺评分信息
     *
     * @param storeId
     * @return
     */
    public StoreReviewScoreResqVo getStoreReviewInfo(@Param("storeId") Integer storeId);

}
