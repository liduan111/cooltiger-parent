package com.kyj.cooltiger.product.entity;

import java.io.Serializable;

/**
 * @author liduan
 * Description: 商品运费表
 * date: 2020/8/4 17:36
 */
public class StoreFreight implements Serializable {
    /** 版本号 */
    private static final long serialVersionUID = 1L;

    //商品运费ID
    private Integer freightId;
    //店铺ID
    private Integer storeId;
    //首重运费（元/1千克）
    private Double freightPrice;
    //续重（元/kg）
    private Double continuePrice;
    //不足一千克是否按一千克计算（0-否1-是）
    private Integer whetherKg;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

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
