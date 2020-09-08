package com.kyj.cooltiger.feign.product.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author liduan
 * Description: 商品基本信息入参vo
 * date: 2020/8/31 13:06
 */
public class ProductBaseReqVo {

    //商品标题
    private String title;
    //一级分类ID
    @JsonProperty("category_one_id")
    private Integer categoryOneId;
    //二级分类ID
    @JsonProperty("category_two_id")
    private Integer categoryTwoId;
    //三级分类ID
    @JsonProperty("category_three_id")
    private Integer categoryThreeId;
    //品牌ID
    @JsonProperty("brand_id")
    private Integer brandId;
    //商品运费方式
    @JsonProperty("product_freight_type")
    private Integer productFreightType;
    //发货地ID
    @JsonProperty("address_from_id")
    private Integer addressFromId;
    //产地ID
    @JsonProperty("create_address_id")
    private Integer createAddressId;
    //预计送达时间
    @JsonProperty("about_deliver_time")
    private Integer aboutDeliverTime;
    //商品参数
    private List<Param> params;
    //上架状态：0下架1上架
    @JsonProperty("shelf_status")
    private Integer shelfStatus;
    //服务ID（多个用,分隔）
    @JsonProperty("service_ids")
    private String serviceIds;
    //自定义服务
    @JsonProperty("custom_services")
    private List<String> customServices;

    //商品参数
    public static class Param{
        //参数名称
        @JsonProperty("param_name")
        private String paramName;
        //商品参数值
        @JsonProperty("param_value")
        private String paramValue;

        public Param() {
        }

        public String getParamName() {
            return paramName;
        }

        public void setParamName(String paramName) {
            this.paramName = paramName;
        }

        public String getParamValue() {
            return paramValue;
        }

        public void setParamValue(String paramValue) {
            this.paramValue = paramValue;
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCategoryOneId() {
        return categoryOneId;
    }

    public void setCategoryOneId(Integer categoryOneId) {
        this.categoryOneId = categoryOneId;
    }

    public Integer getCategoryTwoId() {
        return categoryTwoId;
    }

    public void setCategoryTwoId(Integer categoryTwoId) {
        this.categoryTwoId = categoryTwoId;
    }

    public Integer getCategoryThreeId() {
        return categoryThreeId;
    }

    public void setCategoryThreeId(Integer categoryThreeId) {
        this.categoryThreeId = categoryThreeId;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public Integer getProductFreightType() {
        return productFreightType;
    }

    public void setProductFreightType(Integer productFreightType) {
        this.productFreightType = productFreightType;
    }

    public Integer getAddressFromId() {
        return addressFromId;
    }

    public void setAddressFromId(Integer addressFromId) {
        this.addressFromId = addressFromId;
    }

    public Integer getCreateAddressId() {
        return createAddressId;
    }

    public void setCreateAddressId(Integer createAddressId) {
        this.createAddressId = createAddressId;
    }

    public Integer getAboutDeliverTime() {
        return aboutDeliverTime;
    }

    public void setAboutDeliverTime(Integer aboutDeliverTime) {
        this.aboutDeliverTime = aboutDeliverTime;
    }

    public List<Param> getParams() {
        return params;
    }

    public void setParams(List<Param> params) {
        this.params = params;
    }

    public Integer getShelfStatus() {
        return shelfStatus;
    }

    public void setShelfStatus(Integer shelfStatus) {
        this.shelfStatus = shelfStatus;
    }

    public String getServiceIds() {
        return serviceIds;
    }

    public void setServiceIds(String serviceIds) {
        this.serviceIds = serviceIds;
    }

    public List<String> getCustomServices() {
        return customServices;
    }

    public void setCustomServices(List<String> customServices) {
        this.customServices = customServices;
    }
}
