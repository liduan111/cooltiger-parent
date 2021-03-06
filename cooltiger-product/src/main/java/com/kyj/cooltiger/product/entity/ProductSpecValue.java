package com.kyj.cooltiger.product.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author liduan
 * Description: 商品规格值表
 * date: 2020/8/4 14:29
 */
public class ProductSpecValue implements Serializable {
    /** 版本号 */
    private static final long serialVersionUID = 1L;

    //商品规格值ID
    private Integer valueId;
    //商品规格值
    private String specValue;
    //商品规格名ID
    private Integer specNameId;
    //排序
    private Integer sort;
    //创建时间
    private Timestamp createTime;
    //修改时间
    private Timestamp modifiedTime;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getValueId() {
        return valueId;
    }

    public void setValueId(Integer valueId) {
        this.valueId = valueId;
    }

    public String getSpecValue() {
        return specValue;
    }

    public void setSpecValue(String specValue) {
        this.specValue = specValue;
    }

    public Integer getSpecNameId() {
        return specNameId;
    }

    public void setSpecNameId(Integer specNameId) {
        this.specNameId = specNameId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
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
