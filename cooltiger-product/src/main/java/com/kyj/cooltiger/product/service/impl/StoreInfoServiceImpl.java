package com.kyj.cooltiger.product.service.impl;

import com.kyj.cooltiger.common.constant.DELETED;
import com.kyj.cooltiger.common.constant.PRODUCT_IMAGE_TYPE;
import com.kyj.cooltiger.common.constant.STORE_AUDIT_STATUS;
import com.kyj.cooltiger.common.excep.MyException;
import com.kyj.cooltiger.common.utils.PageUtil;
import com.kyj.cooltiger.feign.product.vo.StoreApplyIntoReqVo;
import com.kyj.cooltiger.feign.product.vo.StoreFreightVo;
import com.kyj.cooltiger.feign.product.vo.StoreInfoListRespVo;
import com.kyj.cooltiger.feign.product.vo.StoreInfoRespVo;
import com.kyj.cooltiger.product.entity.StoreFreight;
import com.kyj.cooltiger.product.entity.StoreInfo;
import com.kyj.cooltiger.product.entity.StorePicture;
import com.kyj.cooltiger.product.mapper.StoreFreightMapper;
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
    @Autowired
    private StoreFreightMapper storeFreightMapper;

    /**
     * 添加店铺入驻信息
     *
     * @param userId              用户ID
     * @param storeApplyIntoReqVo 店铺基本信息
     */
    @Transactional
    @Override
    public void addStoreIntoInfo(Integer userId, StoreApplyIntoReqVo storeApplyIntoReqVo) {
        int count = storeInfoMapper.getStoreInfoCountByStoreName(storeApplyIntoReqVo.getStoreName());
        if (count > 0) {
            throw new MyException("STORE_NAME_IS_EXIST", "店铺名称已存在");
        }
        //插入店铺信息
        StoreInfo storeInfo = new StoreInfo();
        storeInfo.setStoreCode(storeApplyIntoReqVo.getStoreCode());
        storeInfo.setStoreName(storeApplyIntoReqVo.getStoreName());
        storeInfo.setStoreLogoUrl(storeApplyIntoReqVo.getStoreLogoUrl());
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
        storeInfo.setAuditStatus(STORE_AUDIT_STATUS.NOT_AUDIT);
        storeInfo.setSignStatus(DELETED.NOT);
        storeInfo.setDeleted(DELETED.NOT);
        storeInfoMapper.addStoreInfo(storeInfo);
        //添加经营资质图片信息
        List<StorePicture> storePictures = null;
        if (storeApplyIntoReqVo.getLicenseUrls() != null && !storeApplyIntoReqVo.getLicenseUrls().isEmpty()) {
            storePictures = new ArrayList<>();
            StorePicture storePicture = null;
            for (String licenseUrl : storeApplyIntoReqVo.getLicenseUrls()) {
                storePicture = new StorePicture();
                storePicture.setStoreId(storeInfo.getStoreId());
                storePicture.setPictureType(PRODUCT_IMAGE_TYPE.INFO);
                storePicture.setPicUrl(licenseUrl);
                storePictures.add(storePicture);
            }
            //批量插入经营资质图片信息
            storePictureMapper.addStorePicture(storePictures);
        }
    }

    /**
     * 查询店铺列表
     *
     * @param pageNo   当前页
     * @param pageSize 分页单位
     * @param keyword  搜索关键字
     * @return
     */
    @Override
    public Map<String, Object> getStoreList(Integer pageNo, Integer pageSize, String keyword) {
        //查询总条数
        int totalCount = storeInfoMapper.getTotalCountByKeyword(keyword);
        //创建分页工具类对象
        PageUtil<Object> pageUtil = new PageUtil<>(pageNo, pageSize, totalCount);
        List<StoreInfoListRespVo> storeInfoListRespVoLists = null;
        if (totalCount > 0) {
            int pageStart = (pageUtil.getPageNo() - 1) * pageUtil.getPageSize();
            storeInfoListRespVoLists = storeInfoMapper.getStoreListByKeyword(keyword, pageStart, pageSize);
        }
        Map<String, Object> res = new HashMap<>();
        res.put("totalCount", pageUtil.getTotalCount());
        res.put("totalPage", pageUtil.getTotalPage());
        res.put("datas", storeInfoListRespVoLists);
        return res;
    }

    /**
     * 查询店铺信息
     *
     * @param storeId
     * @return
     */
    @Override
    public Map<String, Object> getStoreInfo(Integer storeId) {
        StoreInfo storeInfo = storeInfoMapper.getStoreInfo(storeId);
        if (storeId == null) {
            throw new MyException("STORE_INFO_NOT_EXIST", "店铺信息不存在");
        }
        List<StorePicture> storePictureLists = storePictureMapper.getStorePictureList(storeId);
        StoreInfoRespVo storeInfoRespVo = new StoreInfoRespVo();
        storeInfoRespVo.setStoreId(storeInfo.getStoreId());
        storeInfoRespVo.setStoreCode(storeInfo.getStoreCode());
        storeInfoRespVo.setStoreName(storeInfo.getStoreName());
        storeInfoRespVo.setLogoUrl(storeInfo.getStoreLogoUrl());
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
        if (!storePictureLists.isEmpty()) {
            for (StorePicture storePicture : storePictureLists) {
                picture = storeInfoRespVo.new Picture();
                picture.setId(storePicture.getPicId());
                picture.setPictureType(storePicture.getPictureType());
                picture.setUrl(storePicture.getPicUrl());
                pictures.add(picture);
            }
        }
        storeInfoRespVo.setPictures(pictures);
        Map<String, Object> res = new HashMap<>();
        res.put("data", storeInfoRespVo);
        return res;
    }

    /**
     * 店铺信息审核
     *
     * @param storeId     店铺ID
     * @param auditStatus 审核结果（1-审核通过2-审核未通过）
     */
    @Override
    public void storeInfoAudit(Integer storeId, Integer auditStatus) {
        StoreInfo storeInfo = storeInfoMapper.getStoreInfo(storeId);
        if (storeInfo == null) {
            throw new MyException("STORE_INFO_NOT_EXIST", "店铺信息不存在");
        }
        if (!storeInfo.getAuditStatus().equals(STORE_AUDIT_STATUS.NOT_AUDIT)) {
            throw new MyException("STORE_IS_AUDIT", "店铺已审核");
        } else if (auditStatus.equals(STORE_AUDIT_STATUS.AUDIT_YES)) {
            storeInfo.setAuditStatus(STORE_AUDIT_STATUS.AUDIT_YES);
        } else if (auditStatus.equals(STORE_AUDIT_STATUS.AUDIT_NOT)) {
            storeInfo.setAuditStatus(STORE_AUDIT_STATUS.AUDIT_NOT);
        } else {
            throw new MyException("PARAM_REEOR", "参数错误");
        }
        storeInfoMapper.updateStoreInfo(storeInfo);
    }

    /**
     * 修改店铺信息
     *
     * @param storeId             店铺ID
     * @param storeApplyIntoReqVo 店铺信息
     * @return
     */
    @Override
    public void updateStoreInfo(Integer storeId, StoreApplyIntoReqVo storeApplyIntoReqVo) {
        StoreInfo storeInfo = storeInfoMapper.getStoreInfo(storeId);
        if (storeInfo == null) {
            throw new MyException("STORE_INFO_NOT_EXIST", "店铺信息不存在");
        }
        int count = storeInfoMapper.getStoreInfoCountByStoreName(storeApplyIntoReqVo.getStoreName());
        if (!storeInfo.getStoreName().equals(storeApplyIntoReqVo.getAccountName()) && count > 0) {
            throw new MyException("STORE_NAME_IS_EXIST", "店铺名称已存在");
        }
        storeInfo.setStoreName(storeApplyIntoReqVo.getStoreName());
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

    /**
     * 根据店铺ID获取店铺信息
     *
     * @param storeId
     * @return
     */
    @Override
    public StoreInfo getStoreInfoByStoreId(Integer storeId) {
        StoreInfo storeInfo = storeInfoMapper.getStoreInfo(storeId);
        if (storeInfo == null) {
            throw new MyException("STORE_INFO_NOT_EXIST", "店铺信息不存在");
        }
        return storeInfo;
    }

    /**
     * 获取店铺运费信息
     *
     * @param storeId
     * @return
     */
    @Override
    public Map<String, Object> getStoreFreight(Integer storeId) {
        StoreFreight storeFreight = storeFreightMapper.getStoreFreightByStoreId(storeId);
        Map<String,Object> res = new HashMap<>();
        res.put("data",storeFreight);
        return res;
    }

    /**
     * 添加/修改店铺运费信息
     *
     * @param storeFreightVo
     */
    @Override
    public void editStoreFreight(StoreFreightVo storeFreightVo) {
        StoreFreight storeFreight = new StoreFreight();
        storeFreight.setFreightId(storeFreightVo.getFreightId());
        storeFreight.setStoreId(storeFreightVo.getStoreId());
        storeFreight.setFreightPrice(storeFreightVo.getFreightPrice());
        storeFreight.setContinuePrice(storeFreightVo.getContinuePrice());
        storeFreight.setWhetherKg(storeFreightVo.getWhetherKg());
        if (storeFreight.getFreightId() == null){
            storeFreightMapper.addStoreFreight(storeFreight);
        }else {
            storeFreightMapper.updateStoreFreight(storeFreight);
        }
    }
}
