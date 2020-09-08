package com.kyj.cooltiger.feign.product.vo;

import java.util.List;

/**
 * @author liduan
 * Description: 商品信息返回vo
 * date: 2020/9/8 9:22
 */
public class ProductItemRespVo {
    /** 商品ID */
    private Integer productId;
    /** 商品编码 */
    private String productCode;
    /** 商品标题 */
    private String title;
    /** 商品最低价 */
    private Double minPrice;
    /** 店铺ID */
    private Integer storeId;
    /** 店铺名称 */
    private Integer storeName;
    /** 品牌ID */
    private Integer brandId;
    /** 品牌名称 */
    private Integer brandName;
    /** 商品运费方式 */
    private Integer productFreightType;
    /** 一级分类ID */
    private Integer categoryOneId;
    /** 一级分类 */
    private Integer categoryOneName;
    /** 二级分类ID */
    private Integer categoryTwoId;
    /** 二级分类 */
    private Integer categoryTwoName;
    /** 三级分类ID */
    private Integer categoryThreeId;
    /** 三级分类 */
    private Integer categoryThreeName;
    /** 发货地ID */
    private Integer addressFromId;
    /** 发货地 */
    private Integer addressFromName;
    /** 产地ID */
    private Integer createAddressId;
    /** 产地 */
    private Integer createAddressName;
    /** 预计送达时间（单位/天） */
    private Integer aboutDeliverTime;
    /** 服务ID（多个用,分隔） */
    private String serviceIds;
    /** 上架状态：0下架1上架 */
    private Integer shelfStatus;
    /** 审核状态：0未审核1已审核 */
    private Integer auditStatus;
    /** 是否删除（0未删除1已删除） */
    private Integer deleted;
    /** 商品录入时间 */
    private String createTime;
    /** 最后修改时间 */
    private String modifiedTime;
    /** 服务 **/
    private List<Service> services;
    /** 商品图片 **/
    private List<ProductPic> productPics;



    public class Service{
        //服务ID
        private Integer serviceId;
        //服务名称
        private String serviceName;

        public Integer getServiceId() {
            return serviceId;
        }

        public void setServiceId(Integer serviceId) {
            this.serviceId = serviceId;
        }

        public String getServiceName() {
            return serviceName;
        }

        public void setServiceName(String serviceName) {
            this.serviceName = serviceName;
        }
    }

    public class ProductPic{
        //图片ID
        private Integer picId;
        //关联ID
        private Integer relationId;
        //图片url
        private String picUrl;
        //是否为主图（0-否1-是）
        private Integer isMain;

        public Integer getPicId() {
            return picId;
        }

        public void setPicId(Integer picId) {
            this.picId = picId;
        }

        public Integer getRelationId() {
            return relationId;
        }

        public void setRelationId(Integer relationId) {
            this.relationId = relationId;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public Integer getIsMain() {
            return isMain;
        }

        public void setIsMain(Integer isMain) {
            this.isMain = isMain;
        }
    }


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

    public Double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Double minPrice) {
        this.minPrice = minPrice;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getStoreName() {
        return storeName;
    }

    public void setStoreName(Integer storeName) {
        this.storeName = storeName;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public Integer getBrandName() {
        return brandName;
    }

    public void setBrandName(Integer brandName) {
        this.brandName = brandName;
    }

    public Integer getProductFreightType() {
        return productFreightType;
    }

    public void setProductFreightType(Integer productFreightType) {
        this.productFreightType = productFreightType;
    }

    public Integer getCategoryOneId() {
        return categoryOneId;
    }

    public void setCategoryOneId(Integer categoryOneId) {
        this.categoryOneId = categoryOneId;
    }

    public Integer getCategoryOneName() {
        return categoryOneName;
    }

    public void setCategoryOneName(Integer categoryOneName) {
        this.categoryOneName = categoryOneName;
    }

    public Integer getCategoryTwoId() {
        return categoryTwoId;
    }

    public void setCategoryTwoId(Integer categoryTwoId) {
        this.categoryTwoId = categoryTwoId;
    }

    public Integer getCategoryTwoName() {
        return categoryTwoName;
    }

    public void setCategoryTwoName(Integer categoryTwoName) {
        this.categoryTwoName = categoryTwoName;
    }

    public Integer getCategoryThreeId() {
        return categoryThreeId;
    }

    public void setCategoryThreeId(Integer categoryThreeId) {
        this.categoryThreeId = categoryThreeId;
    }

    public Integer getCategoryThreeName() {
        return categoryThreeName;
    }

    public void setCategoryThreeName(Integer categoryThreeName) {
        this.categoryThreeName = categoryThreeName;
    }

    public Integer getAddressFromId() {
        return addressFromId;
    }

    public void setAddressFromId(Integer addressFromId) {
        this.addressFromId = addressFromId;
    }

    public Integer getAddressFromName() {
        return addressFromName;
    }

    public void setAddressFromName(Integer addressFromName) {
        this.addressFromName = addressFromName;
    }

    public Integer getCreateAddressId() {
        return createAddressId;
    }

    public void setCreateAddressId(Integer createAddressId) {
        this.createAddressId = createAddressId;
    }

    public Integer getCreateAddressName() {
        return createAddressName;
    }

    public void setCreateAddressName(Integer createAddressName) {
        this.createAddressName = createAddressName;
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

    public Integer getShelfStatus() {
        return shelfStatus;
    }

    public void setShelfStatus(Integer shelfStatus) {
        this.shelfStatus = shelfStatus;
    }

    public Integer getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(String modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public List<ProductPic> getProductPics() {
        return productPics;
    }

    public void setProductPics(List<ProductPic> productPics) {
        this.productPics = productPics;
    }
}
