package com.kyj.cooltiger.product.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * @author liduan
 * Description: 商品类别表
 * date: 2020/7/28 15:53
 */
public class ProductCategory implements Serializable {
    /** 版本号 */
    private static final long serialVersionUID = 1L;

    /** 分类ID */
    @JsonProperty("category_id")
    private Integer categoryId;
    /** 分类名称 */
    @JsonProperty("category_name")
    private String categoryName;
    /** 父分类ID(0:一级分类） */
    @JsonProperty("parent_id")
    private Integer parentId;
    /** 类别图片url */
    @JsonProperty("logo_url")
    private String logoUrl;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }
}
