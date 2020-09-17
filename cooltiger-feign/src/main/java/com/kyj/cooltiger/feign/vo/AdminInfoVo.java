package com.kyj.cooltiger.feign.vo;

/**
 * @author liduan
 * Description: 用户信息vo
 * date: 2020/9/16 13:16
 */
public class AdminInfoVo {

    //用户ID
    private Integer userId;
    //用户名
    private String username;
    //头像
    private String avatar;
    //昵称
    private String nickname;
    //性别（1-男2-女）
    private Integer sex;
    //电话
    private String phone;
    //邮箱
    private String email;
    //所属店铺ID（0-系统管理员）
    private Integer storeId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
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

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }
}
