package com.kyj.cooltiger.product.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * @author liduan
 * Description: 国家地区表
 * date: 2020/8/13 13:42
 */
public class CountryRegion implements Serializable {
    /** 版本号 */
    private static final long serialVersionUID = 1L;

    //地区主键ID
    @JsonProperty("region_id")
    private Integer regionId;
    //地区名称
    @JsonProperty("regio_name")
    private String regionName;
    //行政地区编号
    @JsonProperty("region_code")
    private String regionCode;
    //地区父ID（国家父ID为0）
    @JsonProperty("pparent_id")
    private Integer parentId;
    //国旗URL
    @JsonProperty("national_flag_url")
    private String nationalFlagUrl;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

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

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getNationalFlagUrl() {
        return nationalFlagUrl;
    }

    public void setNationalFlagUrl(String nationalFlagUrl) {
        this.nationalFlagUrl = nationalFlagUrl;
    }
}
