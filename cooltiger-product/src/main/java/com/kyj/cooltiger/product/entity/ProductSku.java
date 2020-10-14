package com.kyj.cooltiger.product.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author liduan
 * Description: 商品sku表
 * date: 2020/8/4 15:40
 */
public class ProductSku implements Serializable {
    /** 版本号 */
    private static final long serialVersionUID = 1L;

    //skuID
    private Integer skuId;
    //商品sku编码
    private String skuCode;
    //商品ID
    private Integer productId;
    //规格值组合id（多个用,分隔）
    private String specValueIds;
    //商品销售价
    private Double salePrice;
    //商品库存
    private Integer stock;
    //重量（kg）
    private Double weight;
    //分销方式（1-固定金额2-百分比）
    private Integer distriType;
    //分销金额(元)|百分比值（%）
    private Double distriValue;
    //是否删除（0未删除1已删除）
    private Integer deleted;
    //商品录入时间
    private Timestamp createTime;
    //最后修改时间
    private Timestamp modifiedTime;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getSkuId() {
        return skuId;
    }

    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getSpecValueIds() {
        return specValueIds;
    }

    public void setSpecValueIds(String specValueIds) {
        this.specValueIds = specValueIds;
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

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
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
