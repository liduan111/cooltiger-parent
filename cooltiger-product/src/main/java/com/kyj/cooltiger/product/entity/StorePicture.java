package com.kyj.cooltiger.product.entity;

import java.io.Serializable;

/**
 * @author liduan
 * Description: 店铺图片信息表
 * date: 2020/8/6 9:25
 */
public class StorePicture implements Serializable {
    /** 版本号 */
    private static final long serialVersionUID = 1L;

    //图片ID
    private Integer picId;
    //店铺ID
    private Integer storeId;
    //图片类型（1-营业资质2-合约内容）
    private Integer pictureType;
    //图片url
    private String picUrl;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getPicId() {
        return picId;
    }

    public void setPicId(Integer picId) {
        this.picId = picId;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getPictureType() {
        return pictureType;
    }

    public void setPictureType(Integer pictureType) {
        this.pictureType = pictureType;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
}
