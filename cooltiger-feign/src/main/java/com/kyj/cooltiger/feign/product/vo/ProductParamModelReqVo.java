package com.kyj.cooltiger.feign.product.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author liduan
 * Description:
 * date: 2020/8/12 17:30
 */
public class ProductParamModelReqVo {

    //参数名称
    @JsonProperty("param_name")
    private String paramName;
    //是否必填（0-否1-是）
    private String required;

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public String getRequired() {
        return required;
    }

    public void setRequired(String required) {
        this.required = required;
    }
}
