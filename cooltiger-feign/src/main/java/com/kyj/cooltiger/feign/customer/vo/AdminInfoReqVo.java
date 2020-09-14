package com.kyj.cooltiger.feign.customer.vo;

/**
 * @author liduan
 * Description: 管理员信息入参
 * date: 2020/9/14 15:15
 */
public class AdminInfoReqVo {

    //用户名
    private String username;
    //密码
    private String password;
    //用户名称
    private String nickname;
    //头像
    private String avatar;
    //电话
    private String phone;
    //邮箱
    private String email;
    //性别（1-男2-女）
    private Integer sex;
    //所属店铺ID（0-系统管理员）
    private Integer storeId;

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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }
}
