package com.kyj.cooltiger.product.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author liduan
 * Description: 商品参数模板表
 * date: 2020/8/12 16:58
 */
public class ProductParamModel implements Serializable {
    /**
     * 版本号
     */
    private static final long serialVersionUID = 1L;

    //商品参数ID
    @JsonProperty("param_id")
    private Integer paramId;
    //参数名称
    @JsonProperty("param_name")
    private String paramName;
    //是否必填（0-否1-是）
    private Integer required;
    //类别ID
    @JsonProperty("category_id")
    private Integer categoryId;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getParamId() {
        return paramId;
    }

    public void setParamId(Integer paramId) {
        this.paramId = paramId;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public Integer getRequired() {
        return required;
    }

    public void setRequired(Integer required) {
        this.required = required;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

}
