package com.kyj.cooltiger.feign.product.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author liduan
 * Description: 商品规格入参vo
 * date: 2020/10/12 9:56
 */
public class ProductSpecReqVo {
    //规格
    private List<Spec> specs;
    //商品sku
    private List<ProductSkuReqVo> skus;

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



    public List<Spec> getSpecs() {
        return specs;
    }

    public void setSpecs(List<Spec> specs) {
        this.specs = specs;
    }

    public List<ProductSkuReqVo> getSkus() {
        return skus;
    }

    public void setSkus(List<ProductSkuReqVo> skus) {
        this.skus = skus;
    }
}
