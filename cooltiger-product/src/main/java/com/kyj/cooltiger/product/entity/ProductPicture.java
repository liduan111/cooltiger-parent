package com.kyj.cooltiger.product.entity;

import java.io.Serializable;

/**
 * @author liduan
 * Description: 商品图片表
 * date: 2020/8/4 16:48
 */
public class ProductPicture implements Serializable {
    /** 版本号 */
    private static final long serialVersionUID = 1L;

    //图片ID
    private Integer picId;
    //图片类型（0-商品图片1-商品sku图片）
    private Integer picType;
    //关联ID
    private Integer relationId;
    //图片url
    private String picUrl;
    //是否为主图（0-否1-是）
    private Integer isMain;
    //排序
    private Integer sort;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getPicId() {
        return picId;
    }

    public void setPicId(Integer picId) {
        this.picId = picId;
    }

    public Integer getPicType() {
        return picType;
    }

    public void setPicType(Integer picType) {
        this.picType = picType;
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

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
