package com.kyj.cooltiger.feign.customer.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author liduan
 * Description: 修改密码请求入参
 * date: 2020/9/17 13:49
 */
public class PasswordReqVo {

    //旧密码
    @JsonProperty("old_password")
    private String oldPassword;
    //新密码
    @JsonProperty("new_psaaword")
    private String newPassword;

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
