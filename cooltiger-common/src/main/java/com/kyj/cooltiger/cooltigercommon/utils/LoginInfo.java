package com.kyj.cooltiger.cooltigercommon.utils;

import java.io.Serializable;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/7/30 14:04
 */
public class LoginInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    private String code;
    private String avatarUrl;
    private int gender;
    private String nickName;
    private String language;
    private String city;
    private String province;
    //国家
    private String country;
    //商户id
    private Long merchantId;

    public Long getMerchantId() {
        return merchantId;
    }
    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getAvatarUrl() {
        return avatarUrl;
    }
    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
    public int getGender() {
        return gender;
    }
    public void setGender(int gender) {
        this.gender = gender;
    }
    public String getNickName() {
        return nickName;
    }
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getProvince() {
        return province;
    }
    public void setProvince(String province) {
        this.province = province;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

}
