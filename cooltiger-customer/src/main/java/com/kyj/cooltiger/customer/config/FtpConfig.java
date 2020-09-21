package com.kyj.cooltiger.customer.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author liduan
 * Description: Ftp配置类
 * date: 2020/8/19 9:52
 */
@Component
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

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    public String getImageBaseUrl() {
        return imageBaseUrl;
    }

    public void setImageBaseUrl(String imageBaseUrl) {
        this.imageBaseUrl = imageBaseUrl;
    }
}
