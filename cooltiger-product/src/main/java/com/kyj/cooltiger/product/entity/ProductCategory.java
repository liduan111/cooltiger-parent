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
    @JsonProperty("category_parent_id")
    private Integer categoryParentId;
    /** 分类等级（0-一级分类1-二级分类2-三级分类） */
    @JsonProperty("category_level")
    private Integer categoryLevel;
    /** 类别图片url */
    @JsonProperty("category_logo_url")
    private String categoryLogoUrl;

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

    public Integer getCategoryParentId() {
        return categoryParentId;
    }

    public void setCategoryParentId(Integer categoryParentId) {
        this.categoryParentId = categoryParentId;
    }

    public Integer getCategoryLevel() {
        return categoryLevel;
    }

    public void setCategoryLevel(Integer categoryLevel) {
        this.categoryLevel = categoryLevel;
    }

    public String getCategoryLogoUrl() {
        return categoryLogoUrl;
    }

    public void setCategoryLogoUrl(String categoryLogoUrl) {
        this.categoryLogoUrl = categoryLogoUrl;
    }
}
