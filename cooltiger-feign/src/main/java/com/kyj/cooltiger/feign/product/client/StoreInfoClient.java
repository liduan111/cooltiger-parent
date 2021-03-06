package com.kyj.cooltiger.feign.product.client;

import com.kyj.cooltiger.common.utils.Result;
import com.kyj.cooltiger.feign.product.vo.StoreApplyIntoReqVo;
import com.kyj.cooltiger.feign.product.vo.StoreFreightVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author liduan
 * Description: 店铺信息FeignClient接口
 * date: 2020/8/5 15:59
 */
@FeignClient(name = "Product-Service")
public interface StoreInfoClient {

    /**
     * 生成店铺编码
     *
     * @return
     */
    @RequestMapping(value = "/product/storeInfo/getStoreCode", method = {RequestMethod.GET})
    public Result getStoreCode();

    /**
     * 上传店铺图片
     *
     * @param storeCode 店铺编码
     * @param pic       图片
     * @param picType   图片类型（1-店铺logo2-身份证3-经营资质）
     * @return
     */
    @RequestMapping(value = "/product/storeInfo/uploadStorePic", method = {RequestMethod.POST})
    public Result uploadStorePic(
            @RequestParam("store_code") String storeCode,
            @RequestParam("pic") MultipartFile pic,
            @RequestParam("pic_type") Integer picType);

    /**
     * 店铺申请入驻
     *
     * @param userId              申请人ID
     * @param storeApplyIntoReqVo 店铺基本信息
     * @return
     */
    @RequestMapping(value = "/product/storeInfo/storeApplyInto", method = {RequestMethod.POST})
    public Result storeApplyInto(
            @RequestParam("user_id") Integer userId,
            @RequestBody StoreApplyIntoReqVo storeApplyIntoReqVo);

    /**
     * 查询店铺列表
     *
     * @param pageNo   当前页
     * @param pageSize 分页单位
     * @param keyword  搜索关键字
     * @return
     */
    @RequestMapping(value = "/product/storeInfo/getStoreList", method = {RequestMethod.GET})
    public Result getStoreList(
            @RequestParam(value = "page_no", defaultValue = "1") Integer pageNo,
            @RequestParam(value = "page_size", defaultValue = "10") Integer pageSize,
            @RequestParam(value = "keyword", required = false) String keyword);

    /**
     * 查询店铺信息
     *
     * @param storeId 店铺ID
     * @return
     */
    @RequestMapping(value = "/product/storeInfo/getStoreInfo", method = {RequestMethod.GET})
    public Result getStoreInfo(@RequestParam("store_id") Integer storeId);

    /**
     * 店铺信息审核
     *
     * @param storeId     店铺ID
     * @param auditStatus 审核结果（1-审核通过2-审核未通过）
     * @return
     */
    @RequestMapping(value = "/product/storeInfo/storeInfoAudit", method = {RequestMethod.PUT})
    public Result storeInfoAudit(
            @RequestParam("store_id") Integer storeId,
            @RequestParam("audit_status") Integer auditStatus);

    /**
     * 修改店铺信息
     *
     * @param storeId             店铺ID
     * @param storeApplyIntoReqVo 店铺信息
     * @return
     */
    @RequestMapping(value = "/product/storeInfo/updateStoreInfo", method = {RequestMethod.PUT})
    public Result updateStoreInfo(
            @RequestParam("store_id") Integer storeId,
            @RequestBody StoreApplyIntoReqVo storeApplyIntoReqVo);

    /**
     * 获取店铺运费信息
     *
     * @param storeId 店铺ID
     * @return
     */
    @RequestMapping(value = "/product/storeInfo/getStoreFreight", method = {RequestMethod.GET})
    public Result getStoreFreight(
            @RequestParam("store_id") Integer storeId);

    /**
     * 添加/修改店铺运费信息
     *
     * @param storeFreightVo 店铺运费信息
     * @return
     */
    @RequestMapping(value = "/product/storeInfo/editStoreFreight", method = {RequestMethod.POST})
    public Result editStoreFreight(
            @RequestBody StoreFreightVo storeFreightVo);
}
