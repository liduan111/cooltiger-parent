package com.kyj.cooltiger.oauth.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/9/7 11:43
 */
@Data
public class SearchRecordEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    //主键
    private Integer Id;
    //关键字
    private String keyword;
    //搜索时间
    private Long createTime;
    //用户Id
    private Long userId;
}
