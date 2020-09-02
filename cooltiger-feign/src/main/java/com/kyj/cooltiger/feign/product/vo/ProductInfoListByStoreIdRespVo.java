package com.kyj.cooltiger.feign.product.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author liduan
 * Description: 根据店铺ID查询商品列表返回vo
 * date: 2020/8/5 11:44
 */
public class ProductInfoListByStoreIdRespVo {

    //商品ID
    @JsonProperty("product_id")
    private Integer productId;
    //商品编码
    @JsonProperty("product_code")
    private String productCode;
    //商品标题
    private String title;
    //最后修改时间
    @JsonProperty("modified_time")
    private String modifiedTime;
    //图片url
    @JsonProperty("pic_url")
    private String picUrl;
    //商品销售价最低价
    @JsonProperty("min_price")
    private Double minPrice;
    //库存
    private Integer stock;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(String modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public Double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Double minPrice) {
        this.minPrice = minPrice;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
