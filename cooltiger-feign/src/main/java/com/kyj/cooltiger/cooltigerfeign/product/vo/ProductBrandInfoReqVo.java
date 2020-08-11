package com.kyj.cooltiger.cooltigerfeign.product.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author liduan
 * Description: 商品品牌信息vo
 * date: 2020/8/11 15:59
 */
public class ProductBrandInfoReqVo {
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
    @JsonProperty("brand_drder")
    private Integer brandOrder;
    //品牌状态,0禁用,1启用
    @JsonProperty("brand_status")
    private Integer brandStatus;

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
}
