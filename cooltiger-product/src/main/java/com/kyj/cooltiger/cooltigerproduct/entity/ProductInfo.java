package com.kyj.cooltiger.cooltigerproduct.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author liduan
 * Description: 商品信息表
 * date: 2020/7/28 15:16
 */
public class ProductInfo implements Serializable {
    /** 版本号 */
    private static final long serialVersionUID = 1L;

    /** 商品ID */
    private Integer productId;
    /** 商品编码 */
    private String productCode;
    /** 商品标题 */
    private String title;
    /** 店铺ID */
    private Integer storeId;
    /** 品牌ID */
    private Integer barandId;
    /** 一级分类ID */
    private Integer categoryOneId;
    /** 二级分类ID */
    private Integer categoryTwoId;
    /** 三级分类ID */
    private Integer categoryThreeId;
    /** 发货地ID */
    private Integer addressFromId;
    /** 产地ID */
    private Integer createAddressId;
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
    private Timestamp createTime;
    /** 最后修改时间 */
    private Timestamp modifiedTime;

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getBarandId() {
        return barandId;
    }

    public void setBarandId(Integer barandId) {
        this.barandId = barandId;
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

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Timestamp modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
}
