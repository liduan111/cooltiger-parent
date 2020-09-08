package com.kyj.cooltiger.feign.order.vo;

import java.util.List;

/**
 * @author liduan
 * Description: 结算信息返回vo
 * date: 2020/9/4 13:14
 */
public class ProductSettlementRespVo {

    //店铺ID
    private Integer StoreId;
    //店铺名称
    private String StoreName;
    //运费
    private Double freightPrice;
    //小计件数
    private Integer smallCount;
    //小计金额
    private Double smallPrice;
    //sku信息
    private List<Sku> skus;


    public class Sku{
        //购物车ID
        private Integer cartId;
        //商品ID
        private Integer productId;
        //商品标题
        private String productTitle;
        //商品运费方式（0-免邮1-重量计费）
        private Integer productFreightType;
        //skuID
        private Integer skuId;
        //sku图片url
        private String skuUrl;
        //商品规格
        private String skuSpecValues;
        //商品sku单价
        private Double salePrice;
        //商品数量
        private Integer skuNumber;
        //商品重量
        private Double weight;

        public Integer getCartId() {
            return cartId;
        }

        public void setCartId(Integer cartId) {
            this.cartId = cartId;
        }

        public Integer getProductId() {
            return productId;
        }

        public void setProductId(Integer productId) {
            this.productId = productId;
        }

        public String getProductTitle() {
            return productTitle;
        }

        public void setProductTitle(String productTitle) {
            this.productTitle = productTitle;
        }

        public Integer getProductFreightType() {
            return productFreightType;
        }

        public void setProductFreightType(Integer productFreightType) {
            this.productFreightType = productFreightType;
        }

        public Integer getSkuId() {
            return skuId;
        }

        public void setSkuId(Integer skuId) {
            this.skuId = skuId;
        }

        public String getSkuUrl() {
            return skuUrl;
        }

        public void setSkuUrl(String skuUrl) {
            this.skuUrl = skuUrl;
        }

        public String getSkuSpecValues() {
            return skuSpecValues;
        }

        public void setSkuSpecValues(String skuSpecValues) {
            this.skuSpecValues = skuSpecValues;
        }

        public Double getSalePrice() {
            return salePrice;
        }

        public void setSalePrice(Double salePrice) {
            this.salePrice = salePrice;
        }

        public Integer getSkuNumber() {
            return skuNumber;
        }

        public void setSkuNumber(Integer skuNumber) {
            this.skuNumber = skuNumber;
        }

        public Double getWeight() {
            return weight;
        }

        public void setWeight(Double weight) {
            this.weight = weight;
        }
    }

    public Integer getStoreId() {
        return StoreId;
    }

    public void setStoreId(Integer storeId) {
        StoreId = storeId;
    }

    public String getStoreName() {
        return StoreName;
    }

    public void setStoreName(String storeName) {
        StoreName = storeName;
    }

    public Double getFreightPrice() {
        return freightPrice;
    }

    public void setFreightPrice(Double freightPrice) {
        this.freightPrice = freightPrice;
    }

    public Integer getSmallCount() {
        return smallCount;
    }

    public void setSmallCount(Integer smallCount) {
        this.smallCount = smallCount;
    }

    public Double getSmallPrice() {
        return smallPrice;
    }

    public void setSmallPrice(Double smallPrice) {
        this.smallPrice = smallPrice;
    }

    public List<Sku> getSkus() {
        return skus;
    }

    public void setSkus(List<Sku> skus) {
        this.skus = skus;
    }
}
