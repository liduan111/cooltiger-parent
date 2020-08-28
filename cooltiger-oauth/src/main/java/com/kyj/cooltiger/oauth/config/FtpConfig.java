package com.kyj.cooltiger.oauth.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/8/25 15:49
 * ftp配置类
 */
@Component
@Data
public class FtpConfig {
    @Value("${FTP.ADDRESS}")
    private String host;
    @Value("${FTP.PORT}")
    private Integer port;
    @Value("${FTP.USERNAME}")
    private String userName;
    @Value("${FTP.PASSWORD}")
    private String passWord;
    @Value("${FTP.BASEPATH}")
    private String basePath;
    @Value("${IMAGE.BASE.URL}")
    private String imageBaseUrl;
}
