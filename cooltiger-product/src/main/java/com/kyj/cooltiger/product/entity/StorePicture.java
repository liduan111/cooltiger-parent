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

    //商品图片ID
    private Integer id;
    //店铺ID
    private Integer storeId;
    //图片类型（1-营业资质2-合约内容）
    private Integer pictureType;
    //图片url
    private String url;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
