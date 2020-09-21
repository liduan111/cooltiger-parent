package com.kyj.cooltiger.order.controller;

import com.alibaba.fastjson.JSONObject;
import com.kyj.cooltiger.common.enums.SandProductCode;
import com.kyj.cooltiger.common.utils.Result;
import com.kyj.cooltiger.order.config.SDKConfig;
import com.kyj.cooltiger.order.config.SandOrder;
import com.kyj.cooltiger.order.config.SandVerifySign;
import com.kyj.cooltiger.order.service.OrderInfoService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/9/10 9:43
 */
@RestController
@RequestMapping(value = "/order/pay")
public class PayController {

    private static final Logger logger = LoggerFactory.getLogger(PayController.class);


    @Autowired
    private OrderInfoService orderInfoService;

    @RequestMapping(value = "/pay",method = RequestMethod.POST)
    public Result orderpay(@RequestParam(value = "orderId",required = false)Integer orderId,
                           @RequestParam(value = "userId",required = false)Integer userId){
        if (orderId==null||orderId==0){
            return  Result.error("500","订单id为空 ");
        }
        if (userId==null||userId==0){
            return  Result.error("500","用户id为空 ");
        }
        //orderInfoService.queryOrder();

        //接口报文规范中获取
        String reqAddr="/order/pay";
       SandOrder  sandOrder=new SandOrder();
       sandOrder.setHeader();

        sandOrder.body.put("orderCode", SandVerifySign.getOrderCode());                           //商户订单号
        sandOrder.body.put("totalAmount","");                                  //订单金额
        sandOrder.body.put("subject","");                                             //订单标题
        sandOrder.body.put("body", "");                                         //订单描述
       /* if(map.get("txnTimeOut")==null || map.get("txnTimeOut")==""){
            sandOrder.body.put("txnTimeOut", SandVerifySign.getNextDayTime());                          //订单超时时间
        }else {
            sandOrder.body.put("txnTimeOut",""); 			                     //订单超时时间
        }*/

        sandOrder.body.put("payMode","");                                           //支付模式
        JSONObject payExtra=new JSONObject();
        payExtra.put("payType", "");//***********************需要修改
        payExtra.put("bankCode","");//***********************需要修改
        //payExtra.put("subAppid", map.get("subAppid"));
        //payExtra.put("userId", map.get("userId"));
        /*demo.body.put("payExtra", payExtra);    							//支付扩展域。
        demo.body.put("clientIp", map.get("clientIp"));                                    //客户端IP
        demo.body.put("notifyUrl", map.get("notifyUrl"));                         //异步通知地址
        demo.body.put("frontUrl", map.get("frontUrl"));                     //前台通知地址
        demo.body.put("storeId", map.get("storeId"));                                                  //商户门店编号
        demo.body.put("terminalId", map.get("terminalId"));                                               //商户终端编号
        demo.body.put("operatorId", map.get("operatorId"));                                               //操作员编号
        demo.body.put("clearCycle", "");                                               //清算模式
        demo.body.put("royaltyInfo", "");                                              //分账信息
        demo.body.put("riskRateInfo", "");                                             //风控信息域
        demo.body.put("bizExtendParams", map.get("bizExtendParams"));                                          //业务扩展参数
        demo.body.put("merchExtendParams", map.get("merchExtendParams"));                                        //商户扩展参数
        demo.body.put("extend", map.get("extend"));                                                   //扩展域

        JSONObject orderCreateResp = DemoBase.requestServer(demo.header, demo.body, reqAddr);*/


        return  Result.error();
    }

}
