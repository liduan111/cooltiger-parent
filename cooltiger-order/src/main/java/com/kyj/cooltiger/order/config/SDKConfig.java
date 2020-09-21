package com.kyj.cooltiger.order.config;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;


/**
 * @author guoxq
 * @version 1.0
 * @date 2020/9/10 14:47
 * 杉德配置
 */
@Data
public class SDKConfig {

    public static Logger logger = LoggerFactory.getLogger(SDKConfig.class);

    /**通讯地址. */
    @Value("$sandsdk.url")
    private String url;
    /**商户号. */
    @Value("$sandsdk.mid")
    private String mid;
    /**平台商户号. */
    @Value("$sandsdk.plMid")
    private String plMid;
    /** 商户私钥证书路径. */
    @Value("$sandsdk.signCert.path")
    private String signCertPath;
    /** 商户私钥证书密码. */
    @Value("$sandsdk.signCert.pwd")
    private String signCertPwd;
    /** 杉德证书路径. */
    @Value("$sandsdk.sandCert.path")
    private String sandCertPath;

    /** 操作对象. */
    private static SDKConfig config = new SDKConfig();

    private SDKConfig() {
        super();
    }

    /**
     * 获取config对象.
     * @return
     */
    public static SDKConfig getConfig() {
        return config;
    }



}
