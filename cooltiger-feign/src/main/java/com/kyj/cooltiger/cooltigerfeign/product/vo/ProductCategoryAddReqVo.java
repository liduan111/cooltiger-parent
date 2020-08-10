package com.kyj.cooltiger.cooltigerfeign.product.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author liduan
 * Description: 添加商品类别Vo
 * date: 2020/8/10 11:45
 */
public class ProductCategoryAddReqVo {

    /** 分类名称 */
    @JsonProperty("category_name")
    private String categoryName;
    /** 类别图片url */
    @JsonProperty("logo_url")
    private String logoUrl;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }
}
