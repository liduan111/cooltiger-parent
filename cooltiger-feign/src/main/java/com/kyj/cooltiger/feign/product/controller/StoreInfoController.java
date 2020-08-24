package com.kyj.cooltiger.feign.product.controller;

import com.kyj.cooltiger.common.utils.Result;
import com.kyj.cooltiger.feign.product.client.StoreInfoClient;
import com.kyj.cooltiger.feign.product.vo.StoreApplyIntoReqVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author liduan
 * Description:
 * date: 2020/8/24 14:20
 */
@RestController
@RequestMapping("/store/storeInfo")
public class StoreInfoController {

    @Autowired
    private StoreInfoClient storeInfoClient;

    /**
     * 店铺申请入驻
     * @param userId 申请人ID
     * @param storeApplyIntoReqVo 店铺信息
     * @return
     */
    @RequestMapping(value = "/storeApplyInto/{userId}",method = {RequestMethod.POST})
    public Result storeApplyInto(
            @PathVariable("userId") Integer userId,
            @RequestBody StoreApplyIntoReqVo storeApplyIntoReqVo){
        return storeInfoClient.storeApplyInto(userId, storeApplyIntoReqVo);
    }

    /**
     * 查询店铺列表
     * @return
     */
    @RequestMapping(value = "/getStoreList",method = {RequestMethod.GET})
    public Result getStoreList(){
        return storeInfoClient.getStoreList();
    }

    /**
     * 查询店铺信息
     * @param storeId
     * @return
     */
    @RequestMapping(value = "/getStoreInfo/{storeId}",method ={RequestMethod.GET})
    public Result getStoreInfo(@PathVariable("storeId") Integer storeId){
        return storeInfoClient.getStoreInfo(storeId);
    }

    /**
     * 店铺信息审核
     * @return
     */
    @RequestMapping(value = "/storeInfoAudit/{storeId}",method ={RequestMethod.PUT})
    public Result storeInfoAudit(@PathVariable("storeId") Integer storeId){
        return storeInfoClient.storeInfoAudit(storeId);
    }

    /**
     * 修改店铺信息
     * @param storeId
     * @param storeApplyIntoReqVo
     * @return
     */
    @RequestMapping(value = "/updateStoreInfo/{storeId}",method = {RequestMethod.PUT})
    public Result updateStoreInfo(
            @PathVariable("storeId") Integer storeId,
            @RequestBody StoreApplyIntoReqVo storeApplyIntoReqVo){
        return storeInfoClient.updateStoreInfo(storeId, storeApplyIntoReqVo);
    }
}
