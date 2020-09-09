package com.kyj.cooltiger.feign.order.controller;

import com.kyj.cooltiger.common.utils.Result;
import com.kyj.cooltiger.feign.order.client.AfterSaleClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/9/8 17:20
 */
@RestController
@RequestMapping("/order/aftersale")
public class AfterSaleController {
    @Autowired
    private AfterSaleClient afterSaleClient;

    /**
     * 售后列表查询
     * @param map
     * @return
     */
    @RequestMapping(value = "/salelist",method = RequestMethod.GET)
    public Result getaftersale(@RequestBody Map<String,Object> map){
        return  afterSaleClient.getaftersale(map);
    }

    /**
     * 删除记录
     * @param map
     * @return
     */
    @RequestMapping(value = "/deleterecord",method = RequestMethod.DELETE)
    public Result deleterecord(@RequestBody Map<String,Object> map){
        return afterSaleClient.deleterecord(map);
    }

    /**
     * 退款类型
     * @param map
     * @return
     */
    @RequestMapping(value = "/refundtype",method = RequestMethod.GET)
    public  Result  refundtype(@RequestBody Map<String,Object> map){
        return afterSaleClient.refundtype(map);
    }

    /**
     * 申请退款页面
     * @param map
     * @return
     */
    @RequestMapping(value = "/refundappplication",method = RequestMethod.GET)
    public  Result  getrefundappplication(@RequestBody Map<String,Object> map){
        return  afterSaleClient.getrefundappplication(map);
    }

    /**
     * tijiao申请退款
     * @param received
     * @param refundPrice
     * @param orderId
     * @param userId
     * @param refundDesc
     * @param reasonId
     * @param proofPicture
     * @return
     */
    @RequestMapping(value = "/refundreason",method = RequestMethod.POST)
    public  Result saverefund(@RequestParam(value = "received",required = false)Integer received,
                              @RequestParam(value = "refundPrice",required = false) BigDecimal refundPrice,
                              @RequestParam(value = "orderId",required = false)Integer orderId,
                              @RequestParam(value = "userId",required = false) Long userId,
                              @RequestParam(value = "refundDesc",required = false) String refundDesc,
                              @RequestParam(value = "reasonId",required = false) Integer reasonId,
                              @RequestParam(value = "proofPicture",required = false) MultipartFile proofPicture){
        return afterSaleClient.saverefund(received,refundPrice,orderId,userId,refundDesc,reasonId,proofPicture);
    }


}
