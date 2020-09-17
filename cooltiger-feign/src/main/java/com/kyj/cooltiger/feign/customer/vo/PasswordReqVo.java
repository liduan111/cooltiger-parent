package com.kyj.cooltiger.feign.customer.vo;

/**
 * @author liduan
 * Description: 修改密码请求入参
 * date: 2020/9/17 13:49
 */
public class PasswordReqVo {

    //旧密码
    private String oldPassword;
    //新密码
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
