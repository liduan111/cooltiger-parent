package com.kyj.cooltiger.feign.product.controller;

import com.kyj.cooltiger.common.utils.Result;
import com.kyj.cooltiger.feign.product.client.StoreInfoClient;
import com.kyj.cooltiger.feign.product.vo.StoreApplyIntoReqVo;
import com.kyj.cooltiger.feign.product.vo.StoreFreightVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author liduan
 * Description: 店铺信息controller
 * date: 2020/8/24 14:20
 */
@RestController
@RequestMapping("/product/storeInfo")
public class StoreInfoController {

    @Autowired
    private StoreInfoClient storeInfoClient;

    /**
     * 生成店铺编码
     *
     * @return
     */
    @RequestMapping(value = "/getStoreCode", method = {RequestMethod.GET})
    public Result getStoreCode() {
        return storeInfoClient.getStoreCode();
    }

    /**
     * 上传店铺图片
     *
     * @param storeCode 店铺编码
     * @param pic       图片
     * @param picType   图片类型（1-店铺logo2-身份证3-经营资质）
     * @return
     */
    @RequestMapping(value = "/uploadStorePic", method = {RequestMethod.POST})
    public Result uploadStorePic(
            @RequestParam("store_code") String storeCode,
            @RequestParam("pic") MultipartFile pic,
            @RequestParam("pic_type") Integer picType) {
        return storeInfoClient.uploadStorePic(storeCode, pic, picType);
    }

    /**
     * 店铺申请入驻
     *
     * @param userId              申请人ID
     * @param storeApplyIntoReqVo 店铺基本信息
     * @return
     */
    @RequestMapping(value = "/storeApplyInto", method = {RequestMethod.POST})
    public Result storeApplyInto(
            @RequestParam("user_id") Integer userId,
            @RequestBody StoreApplyIntoReqVo storeApplyIntoReqVo) {
        return storeInfoClient.storeApplyInto(userId, storeApplyIntoReqVo);
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

    /**
     * 获取店铺运费信息
     *
     * @param storeId 店铺ID
     * @return
     */
    @RequestMapping(value = "/getStoreFreight", method = {RequestMethod.GET})
    public Result getStoreFreight(
            @RequestParam("store_id") Integer storeId) {
        return storeInfoClient.getStoreFreight(storeId);
    }

    /**
     * 添加/修改店铺运费信息
     *
     * @param storeFreightVo 店铺运费信息
     * @return
     */
    @RequestMapping(value = "/editStoreFreight", method = {RequestMethod.POST})
    public Result editStoreFreight(
            @RequestBody StoreFreightVo storeFreightVo) {
        return storeInfoClient.editStoreFreight(storeFreightVo);
    }
}
