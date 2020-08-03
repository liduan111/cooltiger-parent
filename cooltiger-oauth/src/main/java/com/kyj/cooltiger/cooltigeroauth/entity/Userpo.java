package com.kyj.cooltiger.cooltigeroauth.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/7/27 10:52
 */

@Data
public class Userpo implements UserDetails , Serializable {

    private static final long serialVersionUID = 1L;

    //主键
    private Long userId;
    //用户唯一标识
    private Long userCode;
    //会员名称
    private String username;
    //会员密码
    private String password;
    //性别
    private Integer gender;
    //年龄
    private Integer age;
    //注册时间
    private Date register_time;
    //最后登录时间
    private Date last_login_time;
    //最后登录Ip
    private String last_login_ip;
    //会员等级
    private Integer user_level_id;
    //昵称
    private String nickname;
    //手机号码
    private String mobile;
    //注册Ip
    private String register_ip;
    //头像
    private String avatar;
    //微信Id
    private String weixin_openid;

    //身份证号
    private String idCard;

    //是否实名认证 1：是 2：否
    private String isReal;

    //推广小程序二维码
    private String qrCode;
    //真实姓名
    private String realName;
    //城市
   //private String citys;
    //收货地址
   // private String address;
    //注册渠道
    private String registerchannel;

    private Set<? extends GrantedAuthority> authorities;//权限列表

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Userpo setUsername(String username) {
        this.username = username;
        return this;
    }

    public Userpo setPassword(String password) {
        this.password = password;
        return this;
    }

    public Userpo setAuthorities(Set<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public Userpo setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public Long getUserCode() {
        return userCode;
    }

    public Userpo setUserCode(Long userCode) {
        this.userCode = userCode;
        return this;
    }
}
