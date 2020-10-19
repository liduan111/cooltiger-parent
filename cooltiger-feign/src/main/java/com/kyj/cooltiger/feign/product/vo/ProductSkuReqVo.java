package com.kyj.cooltiger.feign.product.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author liduan
 * Description: 商品sku入参vo
 * date: 2020/8/31 16:08
 */
public class ProductSkuReqVo {
    //规格值ID组合（多个,分隔）
    @JsonProperty("spec_value_ids")
    private String specValueIds;
    //规格值组合（多个,分隔）
    @JsonProperty("spec_values")
    private String specValues;
    //图片url
    @JsonProperty("pic_url")
    private String picUrl;
    //商品销售价
    @JsonProperty("sale_price")
    private Double salePrice;
    //商品库存
    private Integer stock;
    //重量
    private Double weight;
    //分销方式（1-固定金额2-百分比）
    @JsonProperty("distri_type")
    private Integer distriType;
    //分销金额(元)|百分比值（%）
    @JsonProperty("distri_value")
    private Double distriValue;

    public String getSpecValueIds() {
        return specValueIds;
    }

    public void setSpecValueIds(String specValueIds) {
        this.specValueIds = specValueIds;
    }

    public String getSpecValues() {
        return specValues;
    }

    public void setSpecValues(String specValues) {
        this.specValues = specValues;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Integer getDistriType() {
        return distriType;
    }

    public void setDistriType(Integer distriType) {
        this.distriType = distriType;
    }

    public Double getDistriValue() {
        return distriValue;
    }

    public void setDistriValue(Double distriValue) {
        this.distriValue = distriValue;
    }
}
