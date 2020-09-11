package com.kyj.cooltiger.feign.product.vo;

/**
 * @author liduan
 * Description: 店铺评分信息返回vo
 * date: 2020/9/11 14:17
 */
public class StoreReviewScoreResqVo {

    //店铺ID
    private Integer storeId;
    //店铺名称
    private String storeName;
    //店铺logourl
    private String storeLogoUrl;
    //店铺商品评分
    private String reviewStar;
    //店铺物流服务评分
    private String logisticsStar;
    //店铺服务评分
    private String storeStar;

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreLogoUrl() {
        return storeLogoUrl;
    }

    public void setStoreLogoUrl(String storeLogoUrl) {
        this.storeLogoUrl = storeLogoUrl;
    }

    public String getReviewStar() {
        return reviewStar;
    }

    public void setReviewStar(String reviewStar) {
        this.reviewStar = reviewStar;
    }

    public String getLogisticsStar() {
        return logisticsStar;
    }

    public void setLogisticsStar(String logisticsStar) {
        this.logisticsStar = logisticsStar;
    }

    public String getStoreStar() {
        return storeStar;
    }

    public void setStoreStar(String storeStar) {
        this.storeStar = storeStar;
    }
}
