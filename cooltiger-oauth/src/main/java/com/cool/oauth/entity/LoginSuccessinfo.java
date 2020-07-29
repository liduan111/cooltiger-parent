package com.cool.oauth.entity;

import lombok.Data;
import java.util.List;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/7/27 10:51
 */
@Data
public class LoginSuccessinfo{
    /**
     * 用户编号
     */
    private String userId;

    /**
     * 用户手机号码
     */
    private String userPhone;

    /**
     * 角色信息
     */
    private List<String> roles;

    /**
     * 用户名
     */
    private String username;
}
