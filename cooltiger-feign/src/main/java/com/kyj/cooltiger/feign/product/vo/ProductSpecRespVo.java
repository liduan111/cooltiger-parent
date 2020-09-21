package com.kyj.cooltiger.feign.product.vo;

import java.util.List;

/**
 * @author liduan
 * Description: 商品规格返回vo
 * date: 2020/9/9 14:00
 */
public class ProductSpecRespVo {

    //规格名ID
    private Integer nameId;
    //规格名
    private String specName;
    //商品ID
    private Integer productId;
    //排序
    private Integer sort;
    //规格值
    private List<SpecValue> specValues;


    public class SpecValue{
        //商品规格值ID
        private Integer valueId;
        //商品规格值
        private String specValue;
        //商品规格名ID
        private Integer specNameId;
        //排序
        private Integer sort;

        public Integer getValueId() {
            return valueId;
        }

        public void setValueId(Integer valueId) {
            this.valueId = valueId;
        }

        public String getSpecValue() {
            return specValue;
        }

        public void setSpecValue(String specValue) {
            this.specValue = specValue;
        }

        public Integer getSpecNameId() {
            return specNameId;
        }

        public void setSpecNameId(Integer specNameId) {
            this.specNameId = specNameId;
        }

        public Integer getSort() {
            return sort;
        }

        public void setSort(Integer sort) {
            this.sort = sort;
        }
    }

    public Integer getNameId() {
        return nameId;
    }

    public void setNameId(Integer nameId) {
        this.nameId = nameId;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public List<SpecValue> getSpecValues() {
        return specValues;
    }

    public void setSpecValues(List<SpecValue> specValues) {
        this.specValues = specValues;
    }
}
