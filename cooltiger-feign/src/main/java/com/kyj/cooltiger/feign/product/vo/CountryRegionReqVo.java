package com.kyj.cooltiger.feign.product.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author liduan
 * Description: 国家地区入参vo
 * date: 2020/8/13 14:13
 */
public class CountryRegionReqVo {

    //地区名称
    @JsonProperty("region_name")
    private String regionName;
    //行政地区编号
    @JsonProperty("region_code")
    private String regionCode;
    //国旗URL
    @JsonProperty("national_flag_url")
    private String nationalFlagUrl;

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public String getNationalFlagUrl() {
        return nationalFlagUrl;
    }

    public void setNationalFlagUrl(String nationalFlagUrl) {
        this.nationalFlagUrl = nationalFlagUrl;
    }
}
