package com.kyj.cooltiger.feign.product.vo;

/**
 * @author liduan
 * Description: 商品sku列表返回vo
 * date: 2020/9/9 10:08
 */
public class ProductSkuListRespVo {

    //skuID
    private Integer skuId;
    //商品sku编码
    private String skuCode;
    //sku图片url
    private String skuUrl;
    //商品ID
    private Integer productId;
    //规格值组合id（多个用,分隔）
    private String specValueIds;
    //规格值组合（多个用;分隔）
    private String specValues;
    //商品销售价
    private Double salePrice;
    //商品库存
    private Integer stock;
    //重量（kg）
    private Double weight;
    //分销方式（1-固定金额2-百分比）
    private Integer distriType;
    //分销金额(元)|百分比值（%）
    private Double distriValue;;

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

    public String getSkuUrl() {
        return skuUrl;
    }

    public void setSkuUrl(String skuUrl) {
        this.skuUrl = skuUrl;
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

    public String getSpecValues() {
        return specValues;
    }

    public void setSpecValues(String specValues) {
        this.specValues = specValues;
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
