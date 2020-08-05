package com.kyj.cooltiger.cooltigerproduct.service.impl;

import com.kyj.cooltiger.cooltigercommon.utils.CharUtil;
import com.kyj.cooltiger.cooltigerfeign.product.vo.StoreApplyIntoReqVo;
import com.kyj.cooltiger.cooltigerproduct.entity.StoreInfo;
import com.kyj.cooltiger.cooltigerproduct.mapper.StoreInfoMapper;
import com.kyj.cooltiger.cooltigerproduct.service.StoreInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liduan
 * Description: 店铺信息service实现类
 * date: 2020/8/5 16:19
 */
@Service
public class StoreInfoServiceImpl implements StoreInfoService {

    @Autowired
    private StoreInfoMapper storeInfoMapper;

    /**
     * 添加店铺入驻信息
     * @param userId 用户ID
     * @param storeApplyIntoReqVo 店铺信息
     */
    @Override
    public void addStoreIntoInfo(Integer userId, StoreApplyIntoReqVo storeApplyIntoReqVo) {
        StoreInfo storeInfo = new StoreInfo();
        storeInfo.setStoreCode(CharUtil.getRandomNum(8));
        storeInfo.setStoreName(storeApplyIntoReqVo.getStoreName());
        storeInfo.setLogoUrl(storeApplyIntoReqVo.getLogoUrl());
        storeInfo.setRelationName(storeApplyIntoReqVo.getRelationName());
        storeInfo.setRelationTel(storeApplyIntoReqVo.getRelationTel());
        storeInfo.setStoreAddress(storeApplyIntoReqVo.getStoreAddress());
        storeInfo.setIdCardMainUrl(storeApplyIntoReqVo.getIdCardMainUrl());
        storeInfo.setIdCardBackUrl(storeApplyIntoReqVo.getIdCardBackUrl());
        storeInfo.setSaleCategory(storeApplyIntoReqVo.getSaleCategory());
        storeInfo.setMainProducts(storeApplyIntoReqVo.getMainProducts());
        storeInfo.setApplyUserId(userId);
        storeInfo.setAuditStatus(0);
        storeInfo.setSignStatus(0);
        storeInfo.setDeleted(0);
        storeInfoMapper.addStoreInfo(storeInfo);
    }
}
