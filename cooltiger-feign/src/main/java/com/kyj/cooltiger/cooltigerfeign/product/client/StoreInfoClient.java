package com.kyj.cooltiger.cooltigerfeign.product.client;

import com.kyj.cooltiger.cooltigercommon.utils.Result;
import com.kyj.cooltiger.cooltigerfeign.product.vo.StoreApplyIntoReqVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author liduan
 * Description: 店铺信息FeignClient接口
 * date: 2020/8/5 15:59
 */
@FeignClient(name = "Product-Service")
@RequestMapping("/store/storeInfo")
public interface StoreInfoClient {

    /**
     * 店铺申请入驻
     * @param userId 申请人ID
     * @param storeApplyIntoReqVo 店铺信息
     * @return
     */
    @RequestMapping(value = "/storeApplyInto/{userId}",method = {RequestMethod.POST})
    public Result StoreApplyInto(
            @PathVariable("userId") Integer userId,
            @RequestParam("storeApplyIntoReqVo") StoreApplyIntoReqVo storeApplyIntoReqVo);

    /**
     * 查询店铺列表
     * @return
     */
    @RequestMapping(value = "/getStoreList",method = {RequestMethod.GET})
    public Result getStoreList();

    /**
     * 查询店铺信息
     * @param storeId
     * @return
     */
    @RequestMapping(value = "/getStoreInfo/{storeId}",method ={RequestMethod.GET})
    public Result getStoreInfo(@PathVariable("storeId") Integer storeId);

    /**
     * 店铺信息审核
     * @return
     */
    @RequestMapping(value = "/storeInfoAudit/{storeId}",method ={RequestMethod.PUT})
    public Result storeInfoAudit(@PathVariable("storeId") Integer storeId);
}
