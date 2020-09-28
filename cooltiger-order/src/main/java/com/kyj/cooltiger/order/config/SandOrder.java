package com.kyj.cooltiger.order.config;

import com.alibaba.fastjson.JSONObject;
import com.kyj.cooltiger.common.enums.SandProductCode;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/9/15 10:15
 */
public class SandOrder {
    private static final Logger logger = LoggerFactory.getLogger(SandOrder.class);

    public JSONObject jsonObject=new JSONObject();
    //请求体报文
    public JSONObject body = new JSONObject();
    /**
     *
     */
    public  void  setHeader() {
        //请求头报文

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
    }

    /**
     *
     */
    public  void setBody(SandProductCode mode) {

        //商户订单号
        body.put("orderCode", SandVerifySign.getOrderCode());
        //订单金额
        body.put("totalAmount", "");
        //订单标题
        body.put("subject", "");
        //订单描述
        body.put("body", "");
        //订单超时时间
        body.put("txnTimeOut", SandVerifySign.getNextDayTime());
        //客户端IP
        body.put("clientIp", " ");
        //异步通知地址
        body.put("notifyUrl", "http://127.0.0.1/notify");
        //前台通知地址
        body.put("frontUrl", "http://127.0.0.1/frontNotify");
        //商户门店编号
        body.put("storeId", "");
        //商户终端编号
        body.put("terminalId", "");
        //操作员编号
        body.put("operatorId", "");
        //清算模式
        body.put("clearCycle", "");
        //分账信息
        body.put("royaltyInfo", "");
        //风控信息域
        body.put("riskRateInfo", "");
        //业务扩展参数
        body.put("bizExtendParams", "");
        //商户扩展参数
        body.put("merchExtendParams", "");
        //扩展域
        body.put("extend", "");
        String payMode = "";
        JSONObject payExtra = new JSONObject();

        switch (mode) {
            case bank_pc:        //银行网关支付
                payMode = "bank_pc";
                payExtra.put("payType", "1");                //支付类型  1-借记卡  2-贷记卡  3-借/贷记卡
                payExtra.put("bankCode", "01030000");        //银行编码,具体编码见《杉德线上支付接口规范》 附录
                break;
            case sand_h5:        //银行卡H5支付
                payMode = "sand_h5";
                payExtra.put("“cardNo”", "6220000000000000001");    //银行卡卡号，选填
                break;
            case sand_wx:        //微信公众号支付
                payMode = "sand_wx";
                payExtra.put("subAppid", "wx8888888888888888");                //商户公众号Appid
                payExtra.put("userId", "otvxTs_JZ6SEiP0imdhpi50fuSZg");        //用户在商户公众号下得唯一标示openid
                break;
            case sand_alipay:    //支付宝服务窗支付
                payMode = "sand_alipay";
                payExtra.put("userId", "2088102150477652");                //付款支付宝用户号
                break;
            case sand_wxsdk:    //微信APP支付
                payMode = "sand_wxsdk";
                payExtra.put("appId", "wxd678efh567hg6787");            //微信开放平台会生成APP的唯一标识
                break;
            case sand_wxh5:    //微信H5支付
                payMode = "sand_wxh5";
                payExtra.put("ip", "x.x.x.x");            //付款人实际客户端IP地址,获取方式参照 https://pay.weixin.qq.com/wiki/doc/api/H5_sl.php?chapter=15_5
                JSONObject sceneInfo = new JSONObject();
                JSONObject h5Info = new JSONObject();
                h5Info.put("type", "Wap");
                h5Info.put("wap_url", "https://pay.qq.com");
                h5Info.put("wap_name", "腾讯充值");
                sceneInfo.put("h5_info", h5Info);
                payExtra.put("sceneInfo", sceneInfo);  //
                break;
            case sand_upsdk:    ////银联SDK
                payMode = "sand_wxsdk";
                break;

        }

        body.put("payMode", payMode);                    //支付模式
        body.put("payExtra", payExtra.toJSONString());    //支付扩展域
    }
}
