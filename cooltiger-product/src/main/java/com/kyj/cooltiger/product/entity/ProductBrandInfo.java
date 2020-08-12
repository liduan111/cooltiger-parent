package com.kyj.cooltiger.product.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author liduan
 * Description: 商品品牌表
 * date: 2020/8/11 15:32
 */
public class ProductBrandInfo implements Serializable {
    /** 版本号 */
    private static final long serialVersionUID = 1L;

    //品牌ID
    @JsonProperty("brand_id")
    private Integer brandId;
    //品牌名称
    @JsonProperty("brand_name")
    private String brandName;
    //品牌logo URL
    @JsonProperty("brand_logo_url")
    private String brandLogoUrl;
    //品牌描述
    @JsonProperty("brand_desc")
    private String brandDesc;
    //排序
    @JsonProperty("brand_order")
    private Integer brandOrder;
    //品牌状态,0禁用,1启用
    @JsonProperty("brand_status")
    private Integer brandStatus;
    //创建时间
    @JsonProperty(value = "create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp createTime;
    //最后修改时间
    @JsonProperty(value = "modified_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp modifiedTime;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandLogoUrl() {
        return brandLogoUrl;
    }

    public void setBrandLogoUrl(String brandLogoUrl) {
        this.brandLogoUrl = brandLogoUrl;
    }

    public String getBrandDesc() {
        return brandDesc;
    }

    public void setBrandDesc(String brandDesc) {
        this.brandDesc = brandDesc;
    }

    public Integer getBrandOrder() {
        return brandOrder;
    }

    public void setBrandOrder(Integer brandOrder) {
        this.brandOrder = brandOrder;
    }

    public Integer getBrandStatus() {
        return brandStatus;
    }

    public void setBrandStatus(Integer brandStatus) {
        this.brandStatus = brandStatus;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Timestamp modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
}
