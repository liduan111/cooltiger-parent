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
    private Integer id;
    //商品规格名ID
    private Integer specNameId;
    //商品规格值
    private String value;
    //排序
    private Integer order;
    //创建时间
    private Timestamp createTime;
    //修改时间
    private Timestamp modifiedTime;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSpecNameId() {
        return specNameId;
    }

    public void setSpecNameId(Integer specNameId) {
        this.specNameId = specNameId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
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
