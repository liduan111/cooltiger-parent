package com.kyj.cooltiger.product.service.impl;

import com.kyj.cooltiger.common.excep.MyException;
import com.kyj.cooltiger.common.utils.CharUtil;
import com.kyj.cooltiger.feign.product.vo.StoreApplyIntoReqVo;
import com.kyj.cooltiger.feign.product.vo.StoreInfoListRespVo;
import com.kyj.cooltiger.feign.product.vo.StoreInfoRespVo;
import com.kyj.cooltiger.product.entity.StoreInfo;
import com.kyj.cooltiger.product.entity.StorePicture;
import com.kyj.cooltiger.product.mapper.StoreInfoMapper;
import com.kyj.cooltiger.product.mapper.StorePictureMapper;
import com.kyj.cooltiger.product.service.StoreInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liduan
 * Description: 店铺信息service实现类
 * date: 2020/8/5 16:19
 */
@Service
public class StoreInfoServiceImpl implements StoreInfoService {

    @Autowired
    private StoreInfoMapper storeInfoMapper;
    @Autowired
    private StorePictureMapper storePictureMapper;

    /**
     * 添加店铺入驻信息
     * @param userId 用户ID
     * @param storeApplyIntoReqVo 店铺信息
     */
    @Transactional
    @Override
    public void addStoreIntoInfo(Integer userId, StoreApplyIntoReqVo storeApplyIntoReqVo) {
        int count = storeInfoMapper.getStoreInfoCountByStoreName(storeApplyIntoReqVo.getStoreName());
        if (count > 0){
            throw new MyException("STORE_NAME_IS_EXIST","店铺名称已存在");
        }
        //插入店铺信息
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
        storeInfo.setBankCardNumber(storeApplyIntoReqVo.getBankCardNumber());
        storeInfo.setBankOfDeposit(storeApplyIntoReqVo.getBankOfDeposit());
        storeInfo.setAccountName(storeApplyIntoReqVo.getAccountName());
        storeInfo.setAuditStatus(0);
        storeInfo.setSignStatus(0);
        storeInfo.setDeleted(0);
        storeInfoMapper.addStoreInfo(storeInfo);
        //添加经营资质图片信息
        StorePicture storePicture = null;
        if(storeApplyIntoReqVo.getLicenseUrls() != null && !storeApplyIntoReqVo.getLicenseUrls().isEmpty()){
            for (String licenseUrl:storeApplyIntoReqVo.getLicenseUrls()){
                storePicture = new StorePicture();
                storePicture.setStoreId(storeInfo.getStoreId());
                storePicture.setPictureType(1);
                storePicture.setUrl(licenseUrl);
                storePictureMapper.addStorePicture(storePicture);
            }
        }
    }

    /**
     * 查询店铺列表
     */
    @Override
    public Map<String,Object> getStoreList() {
        List<StoreInfoListRespVo> storeInfoListRespVoLists = storeInfoMapper.getStoreList();
        Map<String, Object> res = new HashMap<>();
        res.put("datas",storeInfoListRespVoLists);
        return res;
    }

    /**
     * 查询店铺信息
     * @param storeId
     * @return
     */
    @Override
    public Map<String, Object> getStoreInfo(Integer storeId) {
        StoreInfo storeInfo = storeInfoMapper.getStoreInfo(storeId);
        if (storeId == null){
            throw new MyException("STORE_INFO_NOT_EXIST","店铺信息不存在");
        }
        List<StorePicture> storePictureLists = storePictureMapper.getStorePictureList(storeId);
        StoreInfoRespVo storeInfoRespVo = new StoreInfoRespVo();
        storeInfoRespVo.setStoreId(storeInfo.getStoreId());
        storeInfoRespVo.setStoreCode(storeInfo.getStoreCode());
        storeInfoRespVo.setStoreName(storeInfo.getStoreName());
        storeInfoRespVo.setLogoUrl(storeInfo.getLogoUrl());
        storeInfoRespVo.setRelationName(storeInfo.getRelationName());
        storeInfoRespVo.setRelationTel(storeInfo.getRelationTel());
        storeInfoRespVo.setStoreAddress(storeInfo.getStoreAddress());
        storeInfoRespVo.setIdCardMainUrl(storeInfo.getIdCardMainUrl());
        storeInfoRespVo.setIdCardBackUrl(storeInfo.getIdCardBackUrl());
        storeInfoRespVo.setSaleCategory(storeInfo.getSaleCategory());
        storeInfoRespVo.setMainProducts(storeInfo.getMainProducts());
        storeInfoRespVo.setApplyUserId(storeInfo.getApplyUserId());
        storeInfoRespVo.setBankCardNumber(storeInfo.getBankCardNumber());
        storeInfoRespVo.setBankOfDeposit(storeInfo.getBankOfDeposit());
        storeInfoRespVo.setAccountName(storeInfo.getAccountName());
        storeInfoRespVo.setAuditStatus(storeInfo.getAuditStatus());
        storeInfoRespVo.setSignStatus(storeInfo.getSignStatus());
        storeInfoRespVo.setSignTimeStart(storeInfo.getSignTimeStart());
        storeInfoRespVo.setSignTimeEnd(storeInfo.getSignTimeEnd());
        storeInfoRespVo.setCreateTime(storeInfo.getCreateTime());
        storeInfoRespVo.setModifiedTime(storeInfo.getModifiedTime());
        List<StoreInfoRespVo.Picture> pictures = new ArrayList<StoreInfoRespVo.Picture>();
        StoreInfoRespVo.Picture picture = null;
        if(!storePictureLists.isEmpty()){
            for(StorePicture storePicture : storePictureLists){
                picture = storeInfoRespVo.new Picture();
                picture.setId(storePicture.getId());
                picture.setPictureType(storePicture.getPictureType());
                picture.setUrl(storePicture.getUrl());
                pictures.add(picture);
            }
        }
        storeInfoRespVo.setPictures(pictures);
        Map<String, Object> res = new HashMap<>();
        res.put("data",storeInfoRespVo);
        return res;
    }

    /**
     * 店铺信息审核
     * @param storeId
     */
    @Override
    public void storeInfoAudit(Integer storeId) {
        StoreInfo storeInfo = storeInfoMapper.getStoreInfo(storeId);
        if (storeId == null){
            throw new MyException("STORE_INFO_NOT_EXIST","店铺信息不存在");
        }
        storeInfo.setAuditStatus(1);
        storeInfoMapper.updateStoreInfo(storeInfo);
    }

    /**
     * 修改店铺信息
     * @param storeId
     * @param storeApplyIntoReqVo
     */
    @Override
    public void updateStoreInfo(Integer storeId, StoreApplyIntoReqVo storeApplyIntoReqVo) {
        StoreInfo storeInfo = storeInfoMapper.getStoreInfo(storeId);
        if (storeId == null){
            throw new MyException("STORE_INFO_NOT_EXIST","店铺信息不存在");
        }
        int count = storeInfoMapper.getStoreInfoCountByStoreName(storeApplyIntoReqVo.getStoreName());
        if (count > 0){
            throw new MyException("STORE_NAME_IS_EXIST","店铺名称已存在");
        }
        storeInfo.setStoreName(storeApplyIntoReqVo.getStoreName());
        storeInfo.setLogoUrl(storeApplyIntoReqVo.getLogoUrl());
        storeInfo.setRelationName(storeApplyIntoReqVo.getRelationName());
        storeInfo.setRelationTel(storeApplyIntoReqVo.getRelationTel());
        storeInfo.setStoreAddress(storeApplyIntoReqVo.getStoreAddress());
        storeInfo.setSaleCategory(storeApplyIntoReqVo.getSaleCategory());
        storeInfo.setMainProducts(storeApplyIntoReqVo.getMainProducts());
        storeInfo.setBankCardNumber(storeApplyIntoReqVo.getBankCardNumber());
        storeInfo.setBankOfDeposit(storeApplyIntoReqVo.getBankOfDeposit());
        storeInfo.setAccountName(storeApplyIntoReqVo.getAccountName());
        storeInfoMapper.updateStoreInfo(storeInfo);
    }
}
