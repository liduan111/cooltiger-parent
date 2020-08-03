package com.kyj.cooltiger.cooltigeroauth.annotation;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/7/31 16:17
 * 请求小程序接口
 */
public interface UserConstantInterface {

    // 请求的网址
    public static final String WX_LOGIN_URL = "https://api.weixin.qq.com/sns/jscode2session";
    // appid
    public static final String WX_LOGIN_APPID = "wx76f37efb12075c29";
    // 密匙
    public static final String WX_LOGIN_SECRET = "66c0e0156659968c8734708e538a5f90";
    // 固定参数
    public static final String WX_LOGIN_GRANT_TYPE = "authorization_code";

}
