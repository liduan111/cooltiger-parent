package com.kyj.cooltiger.product.service;

import com.kyj.cooltiger.feign.product.vo.StoreApplyIntoReqVo;
import com.kyj.cooltiger.feign.product.vo.StoreFreightVo;
import com.kyj.cooltiger.product.entity.StoreInfo;

import java.util.List;
import java.util.Map;

/**
 * @author liduan
 * Description: 店铺信息service接口
 * date: 2020/8/5 16:18
 */
public interface StoreInfoService {

    /**
     * 添加店铺入驻信息
     *
     * @param userId              用户ID
     * @param storeApplyIntoReqVo 店铺基本信息
     */
    public void addStoreIntoInfo(Integer userId, StoreApplyIntoReqVo storeApplyIntoReqVo);

    /**
     * 查询店铺列表
     *
     * @param pageNo   当前页
     * @param pageSize 分页单位
     * @param keyword  搜索关键字
     * @return
     */
    public Map<String, Object> getStoreList(Integer pageNo, Integer pageSize, String keyword);

    /**
     * 查询店铺信息
     *
     * @param storeId 店铺ID
     * @return
     */
    public Map<String, Object> getStoreInfo(Integer storeId);

    /**
     * 店铺信息审核
     *
     * @param storeId     店铺ID
     * @param auditStatus 审核结果（1-审核通过2-审核未通过）
     */
    public void storeInfoAudit(Integer storeId, Integer auditStatus);

    /**
     * 修改店铺信息
     *
     * @param storeId             店铺ID
     * @param storeApplyIntoReqVo 店铺信息
     * @return
     */
    public void updateStoreInfo(Integer storeId, StoreApplyIntoReqVo storeApplyIntoReqVo);

    /**
     * 根据店铺ID获取店铺信息
     *
     * @param storeId
     * @return
     */
    public StoreInfo getStoreInfoByStoreId(Integer storeId);

    /**
     * 获取店铺运费信息
     *
     * @param storeId
     * @return
     */
    public Map<String, Object> getStoreFreight(Integer storeId);

    /**
     * 添加/修改店铺运费信息
     *
     * @param storeFreightVo
     */
    public void editStoreFreight(StoreFreightVo storeFreightVo);
}
