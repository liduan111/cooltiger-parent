package com.kyj.cooltiger.feign.product.controller;

import com.kyj.cooltiger.common.utils.Result;
import com.kyj.cooltiger.feign.product.client.StoreInfoClient;
import com.kyj.cooltiger.feign.product.vo.StoreApplyIntoReqVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author liduan
 * Description: 店铺信息controller
 * date: 2020/8/24 14:20
 */
@RestController
@RequestMapping("/store/storeInfo")
public class StoreInfoController {

    @Autowired
    private StoreInfoClient storeInfoClient;

    /**
     * 店铺申请入驻
     *
     * @param userId              申请人ID
     * @param storeLogo           店铺Logo
     * @param idCardMain          身份证正面照片
     * @param idCardBack          身份证反面照片
     * @param licenses            经营资质照片
     * @param storeApplyIntoReqVo 店铺基本信息
     * @return
     */
    @RequestMapping(value = "/storeApplyInto", method = {RequestMethod.POST})
    public Result storeApplyInto(
            @RequestParam("user_id") Integer userId,
            @RequestParam("store_logo") MultipartFile storeLogo,
            @RequestParam("id_card_main") MultipartFile idCardMain,
            @RequestParam("id_card_back") MultipartFile idCardBack,
            @RequestParam("licenses") MultipartFile[] licenses,
            StoreApplyIntoReqVo storeApplyIntoReqVo) {
        return storeInfoClient.storeApplyInto(userId, storeLogo, idCardMain, idCardBack, licenses, storeApplyIntoReqVo);
    }

    /**
     * 查询店铺列表
     *
     * @param pageNo   当前页
     * @param pageSize 分页单位
     * @param keyword  搜索关键字
     * @return
     */
    @RequestMapping(value = "/getStoreList", method = {RequestMethod.GET})
    public Result getStoreList(
            @RequestParam(value = "page_no", defaultValue = "1") Integer pageNo,
            @RequestParam(value = "page_size", defaultValue = "10") Integer pageSize,
            @RequestParam(value = "keyword", required = false) String keyword) {
        return storeInfoClient.getStoreList(pageNo, pageSize, keyword);
    }

    /**
     * 查询店铺信息
     *
     * @param storeId 店铺ID
     * @return
     */
    @RequestMapping(value = "/getStoreInfo", method = {RequestMethod.GET})
    public Result getStoreInfo(
            @RequestParam("store_id") Integer storeId) {
        return storeInfoClient.getStoreInfo(storeId);
    }

    /**
     * 店铺信息审核
     *
     * @param storeId     店铺ID
     * @param auditStatus 审核结果（1-审核通过2-审核未通过）
     * @return
     */
    @RequestMapping(value = "/storeInfoAudit", method = {RequestMethod.PUT})
    public Result storeInfoAudit(
            @RequestParam("store_id") Integer storeId,
            @RequestParam("audit_status") Integer auditStatus) {
        return storeInfoClient.storeInfoAudit(storeId, auditStatus);
    }

    /**
     * 修改店铺信息
     *
     * @param storeId             店铺ID
     * @param storeApplyIntoReqVo 店铺信息
     * @return
     */
    @RequestMapping(value = "/updateStoreInfo", method = {RequestMethod.PUT})
    public Result updateStoreInfo(
            @RequestParam("store_id") Integer storeId,
            @RequestBody StoreApplyIntoReqVo storeApplyIntoReqVo) {
        return storeInfoClient.updateStoreInfo(storeId, storeApplyIntoReqVo);
    }
}
