package com.kyj.cooltiger.cooltigeroauth.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/7/27 10:51
 */
@Data
public class LoginSuccessinfo implements Serializable {

    private static final long serialVersionUID = 1L;
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
