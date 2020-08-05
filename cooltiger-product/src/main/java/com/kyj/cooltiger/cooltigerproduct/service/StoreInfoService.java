package com.kyj.cooltiger.cooltigerproduct.service;

import com.kyj.cooltiger.cooltigerfeign.product.vo.StoreApplyIntoReqVo;

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
}
