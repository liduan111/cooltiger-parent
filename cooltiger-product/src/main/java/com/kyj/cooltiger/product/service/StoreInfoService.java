package com.kyj.cooltiger.product.service;

import com.kyj.cooltiger.feign.product.vo.StoreApplyIntoReqVo;

import java.util.Map;

/**
 * @author liduan
 * Description: 店铺信息service接口
 * date: 2020/8/5 16:18
 */
public interface StoreInfoService {

    /**
     * 添加店铺入驻信息
     * @param userId 用户ID
     * @param storeApplyIntoReqVo 店铺信息
     */
    public void addStoreIntoInfo(Integer userId, StoreApplyIntoReqVo storeApplyIntoReqVo);

    /**
     * 查询店铺列表
     */
    public Map<String,Object> getStoreList();

    /**
     * 查询店铺信息
     * @param storeId
     * @return
     */
    public Map<String, Object> getStoreInfo(Integer storeId);

    /**
     * 店铺信息审核
     * @param storeId
     */
    public void storeInfoAudit(Integer storeId);

    /**
     * 修改店铺信息
     * @param storeId
     * @param storeApplyIntoReqVo
     */
    public void updateStoreInfo(Integer storeId, StoreApplyIntoReqVo storeApplyIntoReqVo);
}
