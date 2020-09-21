package com.kyj.cooltiger.feign.customer.vo;

/**
 * @author liduan
 * Description: 管理员登录入参vo
 * date: 2020/9/15 9:46
 */
public class AdminLoginReqVo {

    //用户名
    private String username;
    //密码
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
