package com.kyj.cooltiger.common.enums;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/9/11 9:57
 * 杉德支付银行代码编号
 */
public enum SandProductCode {

    sand_alipay("00000006","支付宝扫码"),
    bank_pc("00000007","网银B2C"),
    sand_h5("00000008","银行卡H5支付"),
    sand_wx("00002020","微信公众号支付"),
    sand_wxxcx("00002021","微信小程序"),
    sand_wxsdk("00000024","微信sdk支付"),
    sand_wxh5("00000025","微信H5支付"),
    sand_upsdk("00000030","银联SDK"),
    sand_wxsm("00000005","微信扫码"),
    sand_dspub("00000001","代收对公"),
    bank_dspri("00000002","代收对私"),
    sand_dbds("00002026","单笔对私代收"),
    sand_plds("00002028","批量对私代收"),
    sand_syt("00002000","杉德收银台"),
    sand_ht("00000018","后台绑卡快捷"),
    sand_baogr("00001002","杉德宝个人账户余额支付"),
    sand_baokj("00001003","杉德宝-快捷"),
    sand_rzsign("00000035","认证签约"),
    sand_rz("00000036","认证支付"),
    sand_bao("00001000","杉德宝"),
     ;

    private String procode;
    private String productName;

    SandProductCode(String procode, String productName) {
        this.procode = procode;
        this.productName = productName;
    }

    public String getCode() {
        return procode;
    }

}
