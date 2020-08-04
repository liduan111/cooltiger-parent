package com.kyj.cooltiger.cooltigerproduct.entity;

import java.io.Serializable;

/**
 * @author liduan
 * Description: 商品详情表
 * date: 2020/8/4 18:07
 */
public class ProductDetails implements Serializable {
    /** 版本号 */
    private static final long serialVersionUID = 1L;

    //商品详情ID
    private Integer detailsId;
    //商品ID
    private Integer productId;
    //商品详情
    private String details;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getDetailsId() {
        return detailsId;
    }

    public void setDetailsId(Integer detailsId) {
        this.detailsId = detailsId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
