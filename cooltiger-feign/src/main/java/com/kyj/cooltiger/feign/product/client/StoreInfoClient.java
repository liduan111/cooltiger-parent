package com.kyj.cooltiger.feign.product.client;

import com.kyj.cooltiger.common.utils.Result;
import com.kyj.cooltiger.feign.product.vo.StoreApplyIntoReqVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author liduan
 * Description: 店铺信息FeignClient接口
 * date: 2020/8/5 15:59
 */
@FeignClient(name = "Product-Service")
public interface StoreInfoClient {

    /**
     * 店铺申请入驻
     * @param userId 申请人ID
     * @param storeApplyIntoReqVo 店铺信息
     * @return
     */
    @RequestMapping(value = "/store/storeInfo/storeApplyInto/{userId}",method = {RequestMethod.POST})
    public Result storeApplyInto(
            @PathVariable("userId") Integer userId,
            @RequestBody StoreApplyIntoReqVo storeApplyIntoReqVo);

    /**
     * 查询店铺列表
     * @return
     */
    @RequestMapping(value = "/store/storeInfo/getStoreList",method = {RequestMethod.GET})
    public Result getStoreList();

    /**
     * 查询店铺信息
     * @param storeId
     * @return
     */
    @RequestMapping(value = "/store/storeInfo/getStoreInfo/{storeId}",method ={RequestMethod.GET})
    public Result getStoreInfo(@PathVariable("storeId") Integer storeId);

    /**
     * 店铺信息审核
     * @return
     */
    @RequestMapping(value = "/store/storeInfo/storeInfoAudit/{storeId}",method ={RequestMethod.PUT})
    public Result storeInfoAudit(@PathVariable("storeId") Integer storeId);

    /**
     * 修改店铺信息
     * @param storeId
     * @param storeApplyIntoReqVo
     * @return
     */
    @RequestMapping(value = "/store/storeInfo/updateStoreInfo/{storeId}",method = {RequestMethod.PUT})
    public Result updateStoreInfo(
            @PathVariable("storeId") Integer storeId,
            @RequestBody StoreApplyIntoReqVo storeApplyIntoReqVo);
}
