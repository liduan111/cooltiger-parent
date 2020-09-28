package com.kyj.cooltiger.order.controller;

import com.alibaba.fastjson.JSONObject;
import com.kyj.cooltiger.common.enums.SandProductCode;
import com.kyj.cooltiger.common.excep.MyException;
import com.kyj.cooltiger.common.sand.CertUtil;
import com.kyj.cooltiger.common.utils.Result;
import com.kyj.cooltiger.feign.order.client.OrderPayClient;
import com.kyj.cooltiger.order.config.SDKConfig;
import com.kyj.cooltiger.order.config.SandVerifySign;
import com.kyj.cooltiger.order.entity.OrderInfo;
import com.kyj.cooltiger.order.service.OrderInfoService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @author guoxq
 * @version 1.0
 * @date 2020/9/10 9:43
 */
@RestController
@RequestMapping(value = "/order")
public class PayController implements OrderPayClient{

    private static final Logger logger = LoggerFactory.getLogger(PayController.class);

    @Autowired
    private OrderInfoService orderInfoService;

    @RequestMapping(value = "/pay",method = RequestMethod.POST)
    public Result orderpay(@RequestParam(value = "orderId",required = false)Integer orderId,
                           @RequestParam(value = "userId",required = false)Integer userId)  {
        /*Integer orderId=Integer.valueOf(map.get("orderId").toString());
        Integer userId=Integer.valueOf(map.get("userId").toString());*/
        if (orderId==null){
            return  Result.error("500","订单id为空 ");
        }
        if (userId==null||userId==0){
            return  Result.error("500","用户id为空 ");
        }
        OrderInfo orderInfo=orderInfoService.queryorder(orderId);
        if (orderInfo==null){
            new MyException("500","订单不存在");
        }
        //接口报文规范中获取
       String reqAddr="/order/pay";
        //加载配置文件
        SDKConfig.getConfig().loadPropertiesFromSrc();
        try {
            //加载证书
            CertUtil.init(SDKConfig.getConfig().getSandCertPath(), SDKConfig.getConfig().getSignCertPath(), SDKConfig.getConfig().getSignCertPwd());
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        //请求头报文
        JSONObject jsonObject=new JSONObject();
        //版本号
        jsonObject.put("version", SandVerifySign.version);
        //接口名称
        jsonObject.put("method", SandVerifySign.ORDERPAY);
        //银行编号
        jsonObject.put("productId", SandProductCode.sand_wxxcx);
        //平台商户ID
        String plMid = SDKConfig.getConfig().getPlMid();
        //商户id
        jsonObject.put("mid", SDKConfig.getConfig().getMid());
        //平台商户存在时接入
        if (plMid != null && StringUtils.isNotEmpty(plMid)) {
            //接入类型设置为平台商户接入
            jsonObject.put("accessType", "2");
            jsonObject.put("plMid", plMid);
        } else {
            //接入类型设置为平台商户接入
            jsonObject.put("accessType", "1");                                                                //接入类型设置为普通商户接入
        }
        //渠道类型
        jsonObject.put("channelType", "08");
        //请求时间
        jsonObject.put("reqTime", SandVerifySign.getCurrentTime());

        JSONObject  body=new JSONObject();
        //商户订单号
        body.put("orderCode", SandVerifySign.getOrderCode());
        //订单金额
        body.put("totalAmount", "");
        //订单标题
        body.put("subject", "");
        //订单描述
        body.put("body", "");
        //订单超时时间
       /* if(map.get("txnTimeOut")==null || map.get("txnTimeOut")==""){
            body.put("txnTimeOut", SandVerifySign.getNextDayTime());
        }else {
           body.put("txnTimeOut",map.get("txnTimeOut"));
        }*/
        //客户端IP
        body.put("clientIp", "");
        //异步通知地址
        body.put("notifyUrl", "http://127.0.0.1/notify");
        //前台通知地址
        body.put("frontUrl", "http://127.0.0.1/frontNotify");
        JSONObject resp=SandVerifySign.requestServer(jsonObject, body, reqAddr);
        if(resp.getJSONObject("head").getString("respCode").equals("000000")) {
            logger.info("**下单成功");
            String credential = resp.getJSONObject("body").getString("credential");
            logger.info("生成的支付凭证为："+credential);
            return  Result.success(credential);

        }
        return  Result.error();
    }


}
