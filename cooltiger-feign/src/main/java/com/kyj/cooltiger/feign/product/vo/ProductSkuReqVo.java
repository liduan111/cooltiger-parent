package com.kyj.cooltiger.feign.product.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author liduan
 * Description: 商品sku入参vo
 * date: 2020/8/31 16:08
 */
public class ProductSkuReqVo {
    //规格
    private List<Spec> specs;
    //商品sku
    private List<Sku> skus;

    //规格
    public static class Spec{
        //规格名
        @JsonProperty("spec_name")
        private String specName;
        //规格值
        @JsonProperty("spec_values")
        private List<String> specValues;

        public Spec() {
        }

        public String getSpecName() {
            return specName;
        }

        public void setSpecName(String specName) {
            this.specName = specName;
        }

        public List<String> getSpecValues() {
            return specValues;
        }

        public void setSpecValues(List<String> specValues) {
            this.specValues = specValues;
        }
    }

    public static class Sku{
        //规格值组合
        @JsonProperty("spec_values")
        private List<String> specValues;
        //图片url
        private String url;
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
        //百分比值（%）
        @JsonProperty("distri_ratio")
        private Integer distriRatio;
        //分销金额
        @JsonProperty("distri_amount")
        private Double distriAmount;

        public Sku() {
        }

        public List<String> getSpecValues() {
            return specValues;
        }

        public void setSpecValues(List<String> specValues) {
            this.specValues = specValues;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
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

        public Integer getDistriRatio() {
            return distriRatio;
        }

        public void setDistriRatio(Integer distriRatio) {
            this.distriRatio = distriRatio;
        }

        public Double getDistriAmount() {
            return distriAmount;
        }

        public void setDistriAmount(Double distriAmount) {
            this.distriAmount = distriAmount;
        }
    }

    public List<Spec> getSpecs() {
        return specs;
    }

    public void setSpecs(List<Spec> specs) {
        this.specs = specs;
    }

    public List<Sku> getSkus() {
        return skus;
    }

    public void setSkus(List<Sku> skus) {
        this.skus = skus;
    }
}
