package com.kyj.cooltiger.feign.order.vo;

/**
 * @author liduan
 * Description: 结算信息入参Vo
 * date: 2020/9/4 11:36
 */
public class ProductSettlementReqVo {

    //购物车ID
    private Integer cartId;
    //店铺ID
    private Integer storeId;
    //商品SkuID
    private Integer skuId;
    //商品数量
    private Integer skuNumber;

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getSkuId() {
        return skuId;
    }

    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
    }

    public Integer getSkuNumber() {
        return skuNumber;
    }

    public void setSkuNumber(Integer skuNumber) {
        this.skuNumber = skuNumber;
    }
}
