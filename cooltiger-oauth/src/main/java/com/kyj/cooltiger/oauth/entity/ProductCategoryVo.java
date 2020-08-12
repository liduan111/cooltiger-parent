package com.kyj.cooltiger.oauth.entity;


import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/8/6 13:12
 * 商品分类实体
 */
@Data
public class ProductCategoryVo implements Serializable {

    private  static  final long serianl=1L;
    //分类ID
    private Long categoryId;
    //分类名称
    private String categoryName;
    //类别图片url
    private String logoUrl;
    //父分类ID(0:一级分类）
    private Integer parentId;
    //分类状态(0-未启用 1-启用)
    private Integer  categoryStatus;
    //创建时间
    private Timestamp createTime;
    //最后修改时间
    private Timestamp  modifiedTime;

}
