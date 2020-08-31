package com.kyj.cooltiger.product.entity;

import java.io.Serializable;

/**
 * @author liduan
 * Description: 商品运费表
 * date: 2020/8/4 17:36
 */
public class ProductFreight implements Serializable {
    /** 版本号 */
    private static final long serialVersionUID = 1L;

    //商品运费ID
    private Integer id;
    //商品ID
    private Integer productId;
    //运费方式（0-包邮1-固定运费2-满减包邮3-满件包邮4-重量计费）
    private Integer productFreightType;
    //满减包邮|满件包邮条件（满多少元|满多少件）
    private Integer factor;
    //运费（固定运费|不满足满减包邮|不满足满件包邮|重量计费首重）
    private Double freightPrice;
    //重量计费_首重（kg）
    private Double firstWeight;
    //续重（元/kg）
    private Double continueWeight;
    //不足一千克是否按一千克计算（0-否1-是）
    private Integer whetherKg;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getProductFreightType() {
        return productFreightType;
    }

    public void setProductFreightType(Integer productFreightType) {
        this.productFreightType = productFreightType;
    }

    public Integer getFactor() {
        return factor;
    }

    public void setFactor(Integer factor) {
        this.factor = factor;
    }

    public Double getFreightPrice() {
        return freightPrice;
    }

    public void setFreightPrice(Double freightPrice) {
        this.freightPrice = freightPrice;
    }

    public Double getFirstWeight() {
        return firstWeight;
    }

    public void setFirstWeight(Double firstWeight) {
        this.firstWeight = firstWeight;
    }

    public Double getContinueWeight() {
        return continueWeight;
    }

    public void setContinueWeight(Double continueWeight) {
        this.continueWeight = continueWeight;
    }

    public Integer getWhetherKg() {
        return whetherKg;
    }

    public void setWhetherKg(Integer whetherKg) {
        this.whetherKg = whetherKg;
    }
}
