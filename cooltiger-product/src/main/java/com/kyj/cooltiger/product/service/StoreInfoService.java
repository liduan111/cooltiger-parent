package com.kyj.cooltiger.product.service;

import com.kyj.cooltiger.feign.product.vo.StoreApplyIntoReqVo;
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
     * @param storeCode           店铺编码
     * @param storeLogoUrl        店铺logoUrl
     * @param idCardMainUrl       身份证正面图片url
     * @param idCardBackUrl       身份证反面图片url
     * @param licenseUrls         经营资质图片url
     * @param storeApplyIntoReqVo 店铺基本信息
     */
    public void addStoreIntoInfo(Integer userId, String storeCode, String storeLogoUrl, String idCardMainUrl, String idCardBackUrl, List<String> licenseUrls, StoreApplyIntoReqVo storeApplyIntoReqVo);

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
}
