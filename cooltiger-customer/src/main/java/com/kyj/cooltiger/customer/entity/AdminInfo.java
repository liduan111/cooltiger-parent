package com.kyj.cooltiger.customer.entity;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @author liduan
 * Description: 管理员信息表
 * date: 2020/9/14 14:50
 */
@Data
public class AdminInfo {

    private static final long seriableUUID=1L;

    //用户ID
    private Integer userId;
    //用户名
    private String username;
    //密码（MD5）
    private String password;
    //昵称
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
    //状态（0-禁用1-启用）
    private Integer status;
    //创建时间
    private Timestamp createTime;
    //修改时间
    private Timestamp modifiedTime;
}
