package com.kyj.cooltiger.feign.vo;

/**
 * @author liduan
 * Description: 用户信息vo
 * date: 2020/9/16 13:16
 */
public class UserInfoVo {

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
    //用户类型（1-管理员2-用户）
    private Integer userType;
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

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }
}
