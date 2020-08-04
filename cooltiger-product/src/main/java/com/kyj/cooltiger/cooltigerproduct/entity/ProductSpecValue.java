package com.kyj.cooltiger.cooltigerproduct.entity;

import java.io.Serializable;
import java.sql.Date;

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
    private Date createTime;
    //修改时间
    private Date modifiedTime;

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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
}
