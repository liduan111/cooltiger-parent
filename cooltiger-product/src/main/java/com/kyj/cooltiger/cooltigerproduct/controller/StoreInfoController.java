package com.kyj.cooltiger.cooltigerproduct.controller;

import com.kyj.cooltiger.cooltigercommon.utils.Result;
import com.kyj.cooltiger.cooltigerfeign.product.client.StoreInfoClient;
import com.kyj.cooltiger.cooltigerfeign.product.vo.StoreApplyIntoReqVo;
import com.kyj.cooltiger.cooltigerproduct.service.StoreInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author liduan
 * Description: 店铺信息controller
 * date: 2020/8/5 16:16
 */
@RestController
@RequestMapping("/store/storeInfo")
public class StoreInfoController implements StoreInfoClient {

    @Autowired
    private StoreInfoService storeInfoService;

    /**
     * 店铺申请入驻
     * @param userId 申请人ID
     * @param storeApplyIntoReqVo 店铺信息
     * @return
     */
    @Override
    @RequestMapping(value = "/storeApplyInto/{userId}",method = {RequestMethod.POST})
    public Result StoreApplyInto(
            @PathVariable("userId") Integer userId,
            @RequestBody StoreApplyIntoReqVo storeApplyIntoReqVo) {
        storeInfoService.addStoreIntoInfo(userId,storeApplyIntoReqVo);
        return Result.success();
    }

    /**
     * 查询店铺列表
     * @return
     */
    @Override
    @RequestMapping(value = "/getStoreList",method = {RequestMethod.GET})
    public Result getStoreList() {
        Map<String, Object> resMap = storeInfoService.getStoreList();
        return Result.success(resMap.get("datas"));
    }

    /**
     * 查询店铺信息
     * @param storeId
     * @return
     */
    @Override
    @RequestMapping(value = "/getStoreInfo/{storeId}",method ={RequestMethod.GET})
    public Result getStoreInfo(@PathVariable("storeId") Integer storeId) {
        Map<String, Object> resMap = storeInfoService.getStoreInfo(storeId);
        return Result.success(resMap.get("data"));
    }

    /**
     * 店铺信息审核
     * @return
     */
    @Override
    @RequestMapping(value = "/storeInfoAudit/{storeId}",method ={RequestMethod.PUT})
    public Result storeInfoAudit(@PathVariable("storeId") Integer storeId) {
        storeInfoService.storeInfoAudit(storeId);
        return Result.success();
    }


}
