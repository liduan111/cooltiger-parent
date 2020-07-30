package com.kyj.cooltiger.cooltigeroauth.entity;

import lombok.Data;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.Date;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/7/28 15:50
 * token 实体类
 */
@Data
public class Tokenpo implements Serializable {
    private static final long serialVersionUID = 1L;

    //用户ID
    private Long userId;
    //token
    private String token;
    //过期时间
    private Date expireTime;
    //更新时间
    private Date updateTime;
}
