package com.kyj.cooltiger.feign.order.vo;

import java.util.List;

/**
 * @author liduan
 * Description: 下单信息入参vo
 * date: 2020/9/7 11:00
 */
public class PlaceOrderReqVo {

    //省（直辖市）
    private String receiverProvince;
    //市(直辖区)
    private String receiverCity;
    //县（区）
    private String receiverRegion;
    //收货人详细地址
    private String receiverAddressDetail;
    //收货人
    private String receiverName;
    //收货人电话
    private String receiverMobile;
    //订单信息
    private List<OrderInfoVo> infos;
    //购物车ID
    private String CartIds;


    public class OrderInfoVo{
        //店铺ID
        private Integer storeId;
        //订单总金额
        private Double totalPrice;
        //配送费用
        private Double freightPrice;
        //支付金额
        private Double payPrice;
        //订单备注
        private String orderNote;
        //商品sku信息
        private List<OrderDetailVo> details;

        public Integer getStoreId() {
            return storeId;
        }

        public void setStoreId(Integer storeId) {
            this.storeId = storeId;
        }

        public Double getTotalPrice() {
            return totalPrice;
        }

        public void setTotalPrice(Double totalPrice) {
            this.totalPrice = totalPrice;
        }

        public Double getFreightPrice() {
            return freightPrice;
        }

        public void setFreightPrice(Double freightPrice) {
            this.freightPrice = freightPrice;
        }

        public Double getPayPrice() {
            return payPrice;
        }

        public void setPayPrice(Double payPrice) {
            this.payPrice = payPrice;
        }

        public String getOrderNote() {
            return orderNote;
        }

        public void setOrderNote(String orderNote) {
            this.orderNote = orderNote;
        }

        public List<OrderDetailVo> getDetails() {
            return details;
        }

        public void setDetails(List<OrderDetailVo> details) {
            this.details = details;
        }
    }

    public class OrderDetailVo{
        //商品ID
        private Integer productId;
        //商品标题
        private String productTitle;
        //商品skuID
        private Integer skuId;
        //sku图片url
        private String picUrl;
        //商品规格值（多个用;分隔）
        private String skuSpec;
        //商品sku价格
        private Double skuPrice;
        //商品数量
        private Integer skuNumber;
        //商品重量（kg）
        private Double skuWeight;

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

        public Integer getSkuId() {
            return skuId;
        }

        public void setSkuId(Integer skuId) {
            this.skuId = skuId;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getSkuSpec() {
            return skuSpec;
        }

        public void setSkuSpec(String skuSpec) {
            this.skuSpec = skuSpec;
        }

        public Double getSkuPrice() {
            return skuPrice;
        }

        public void setSkuPrice(Double skuPrice) {
            this.skuPrice = skuPrice;
        }

        public Integer getSkuNumber() {
            return skuNumber;
        }

        public void setSkuNumber(Integer skuNumber) {
            this.skuNumber = skuNumber;
        }

        public Double getSkuWeight() {
            return skuWeight;
        }

        public void setSkuWeight(Double skuWeight) {
            this.skuWeight = skuWeight;
        }
    }

    public String getReceiverProvince() {
        return receiverProvince;
    }

    public void setReceiverProvince(String receiverProvince) {
        this.receiverProvince = receiverProvince;
    }

    public String getReceiverCity() {
        return receiverCity;
    }

    public void setReceiverCity(String receiverCity) {
        this.receiverCity = receiverCity;
    }

    public String getReceiverRegion() {
        return receiverRegion;
    }

    public void setReceiverRegion(String receiverRegion) {
        this.receiverRegion = receiverRegion;
    }

    public String getReceiverAddressDetail() {
        return receiverAddressDetail;
    }

    public void setReceiverAddressDetail(String receiverAddressDetail) {
        this.receiverAddressDetail = receiverAddressDetail;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverMobile() {
        return receiverMobile;
    }

    public void setReceiverMobile(String receiverMobile) {
        this.receiverMobile = receiverMobile;
    }

    public List<OrderInfoVo> getInfos() {
        return infos;
    }

    public void setInfos(List<OrderInfoVo> infos) {
        this.infos = infos;
    }

    public String getCartIds() {
        return CartIds;
    }

    public void setCartIds(String cartIds) {
        CartIds = cartIds;
    }
}
