package com.kyj.cooltiger.oauth.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/9/7 11:16
 */
@Data
public class KeywordsEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    //主键
    private Integer Id;
    //关键字
    private String keyword;
    //热销
    private Integer isHot;
    //默认
    private Integer isDefault;
    //显示
    private Integer isShow;
    //排序
    private Integer sortOrder;
    //类型
    private Integer type;
}
