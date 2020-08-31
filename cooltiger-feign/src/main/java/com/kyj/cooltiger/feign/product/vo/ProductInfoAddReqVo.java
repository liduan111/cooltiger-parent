package com.kyj.cooltiger.feign.product.vo;

import java.util.List;

/**
 * @author liduan
 * Description: 添加商品入参vo
 * date: 2020/8/3 10:05
 */
public class ProductInfoAddReqVo {

    //商品标题
    private String title;
    //分类ID
    private Integer categoryId;
    //品牌ID
    private Integer brandId;
    //商品运费
    private ProductFreight productFreight;
    //发货地ID
    private Integer addressFromId;
    //产地ID
    private Integer createAddressId;
    //预计送达时间
    private Integer aboutDeliverTime;
    //服务ID（多个用,分隔）
    private String serviceIds;
    //自定义服务
    private List<String> customService;
    //商品参数
    private List<ProductParamReq> productParams;
    //上架状态：0下架1上架
    private Integer shelfStatus;
    //规格
    private List<Spec> specs;
    //商品sku
    private List<Sku> skus;
    //商品图片
    private List<ProductPicture> productPictures;
    //商品详情
    private String details;


    //商品运费
    public class ProductFreight{
        //运费方式（0-包邮1-固定运费2-满减包邮3-满件包邮4-重量计费）
        private Integer productFreightType;
        //满减包邮|满件包邮条件（满多少元|满多少件）
        private Integer condition;
        //运费（固定运费|不满足满减包邮|不满足满件包邮|重量计费首重）
        private Double preightPrice;
        //重量计费_首重（kg）
        private Double firsWeight;
        //续重（元/kg）
        private Double continueWeight;
        //不足一千克是否按一千克计算（0-否1-是）
        private Integer whetherKg;

        public Integer getProductFreightType() {
            return productFreightType;
        }

        public void setProductFreightType(Integer productFreightType) {
            this.productFreightType = productFreightType;
        }

        public Integer getCondition() {
            return condition;
        }

        public void setCondition(Integer condition) {
            this.condition = condition;
        }

        public Double getPreightPrice() {
            return preightPrice;
        }

        public void setPreightPrice(Double preightPrice) {
            this.preightPrice = preightPrice;
        }

        public Double getFirsWeight() {
            return firsWeight;
        }

        public void setFirsWeight(Double firsWeight) {
            this.firsWeight = firsWeight;
        }

        public Double getContinueWeight() {
            return continueWeight;
        }

        public void setContinueWeight(Double continueWeight) {
            this.continueWeight = continueWeight;
        }

        public Integer getWhetherKg() {
            return whetherKg;
        }

        public void setWhetherKg(Integer whetherKg) {
            this.whetherKg = whetherKg;
        }
    }

    //商品参数
    public class ProductParamReq{
        //参数名称
        private String paramName;
        //商品参数值
        private String paramValue;

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

    //规格
    public class Spec{
        //规格名
        private String specName;
        //规格值
        private List<String> specValues;

        public String getSpecName() {
            return specName;
        }

        public void setSpecName(String specName) {
            this.specName = specName;
        }

        public List<String> getSpecValues() {
            return specValues;
        }

        public void setSpecValues(List<String> specValues) {
            this.specValues = specValues;
        }
    }

    public class Sku{
        //商品sku名称
        private String skuName;
        //图片url
        private String url;
        //规格值组合
        private List<String> specValues;
        //商品销售价
        private Double salePrice;
        //商品库存
        private Integer stock;
        //重量
        private Double weight;
        //分销方式（1-固定金额2-百分比）
        private Integer distriType;
        //百分比值（%）
        private Integer distriRatio;
        //分销金额
        private Double distriAmount;

        public String getSkuName() {
            return skuName;
        }

        public void setSkuName(String skuName) {
            this.skuName = skuName;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public List<String> getSpecValues() {
            return specValues;
        }

        public void setSpecValues(List<String> specValues) {
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

        public Integer getDistriRatio() {
            return distriRatio;
        }

        public void setDistriRatio(Integer distriRatio) {
            this.distriRatio = distriRatio;
        }

        public Double getDistriAmount() {
            return distriAmount;
        }

        public void setDistriAmount(Double distriAmount) {
            this.distriAmount = distriAmount;
        }
    }

    public class ProductPicture{
        //图片url
        private String url;
        //是否为主图（0-否1-是）
        private Integer isMain;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public Integer getIsMain() {
            return isMain;
        }

        public void setIsMain(Integer isMain) {
            this.isMain = isMain;
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public ProductFreight getProductFreight() {
        return productFreight;
    }

    public void setProductFreight(ProductFreight productFreight) {
        this.productFreight = productFreight;
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

    public String getServiceIds() {
        return serviceIds;
    }

    public void setServiceIds(String serviceIds) {
        this.serviceIds = serviceIds;
    }

    public List<String> getCustomService() {
        return customService;
    }

    public void setCustomService(List<String> customService) {
        this.customService = customService;
    }

    public List<ProductParamReq> getProductParams() {
        return productParams;
    }

    public void setProductParams(List<ProductParamReq> productParams) {
        this.productParams = productParams;
    }

    public Integer getShelfStatus() {
        return shelfStatus;
    }

    public void setShelfStatus(Integer shelfStatus) {
        this.shelfStatus = shelfStatus;
    }

    public List<Spec> getSpecs() {
        return specs;
    }

    public void setSpecs(List<Spec> specs) {
        this.specs = specs;
    }

    public List<Sku> getSkus() {
        return skus;
    }

    public void setSkus(List<Sku> skus) {
        this.skus = skus;
    }

    public List<ProductPicture> getProductPictures() {
        return productPictures;
    }

    public void setProductPictures(List<ProductPicture> productPictures) {
        this.productPictures = productPictures;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
