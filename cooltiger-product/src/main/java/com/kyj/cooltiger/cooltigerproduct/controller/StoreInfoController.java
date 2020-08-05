package com.kyj.cooltiger.cooltigerproduct.controller;

import com.kyj.cooltiger.cooltigercommon.utils.Result;
import com.kyj.cooltiger.cooltigerfeign.product.client.StoreInfoClient;
import com.kyj.cooltiger.cooltigerfeign.product.vo.StoreApplyIntoReqVo;
import com.kyj.cooltiger.cooltigerproduct.service.StoreInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
            @RequestParam("storeApplyIntoReqVo") StoreApplyIntoReqVo storeApplyIntoReqVo) {
        storeInfoService.addStoreIntoInfo(userId,storeApplyIntoReqVo);
        return Result.success();
    }
}
