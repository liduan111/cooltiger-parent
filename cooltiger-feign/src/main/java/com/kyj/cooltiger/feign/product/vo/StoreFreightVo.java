package com.kyj.cooltiger.feign.product.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author liduan
 * Description: 店铺运费Vo
 * date: 2020/10/9 10:00
 */
public class StoreFreightVo {

    //商品运费ID
    @JsonProperty("freight_id")
    private Integer freightId;
    //店铺ID
    @JsonProperty("store_id")
    private Integer storeId;
    //首重运费（元/1千克）
    @JsonProperty("freight_price")
    private Double freightPrice;
    //续重运费（元/kg）
    @JsonProperty("continue_price")
    private Double continuePrice;
    //不足一千克是否按一千克计算（0-否1-是）
    @JsonProperty("whether_kg")
    private Integer whetherKg;

    public Integer getFreightId() {
        return freightId;
    }

    public void setFreightId(Integer freightId) {
        this.freightId = freightId;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Double getFreightPrice() {
        return freightPrice;
    }

    public void setFreightPrice(Double freightPrice) {
        this.freightPrice = freightPrice;
    }

    public Double getContinuePrice() {
        return continuePrice;
    }

    public void setContinuePrice(Double continuePrice) {
        this.continuePrice = continuePrice;
    }

    public Integer getWhetherKg() {
        return whetherKg;
    }

    public void setWhetherKg(Integer whetherKg) {
        this.whetherKg = whetherKg;
    }
}
