package com.kyj.cooltiger.cooltigerproduct.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author liduan
 * Description: 商品类别表
 * date: 2020/7/28 15:53
 */
public class ProductCategory implements Serializable {
    /** 版本号 */
    private static final long serialVersionUID = 1L;

    /** 分类ID */
    private Integer categoryId;
    /** 分类名称 */
    private String categoryName;
    /** 父分类ID(0:一级分类） */
    private Integer parentId;
    /** 分类状态(0-未启用 1-启用) */
    private Integer categoryStatus;
    /** 创建时间 */
    private Date createTime;
    /** 最后修改时间 */
    private Date modifiedTime;


}
