package com.kyj.cooltiger.cooltigerproduct.entity;

import java.io.Serializable;
import java.sql.Date;

/**
 * @author liduan
 * Description: 商品规格名表
 * date: 2020/8/4 14:23
 */
public class ProductSpecName implements Serializable {
    /** 版本号 */
    private static final long serialVersionUID = 1L;

    //规格名ID
    private Integer id;
    //规格名
    private String name;
    //商品ID
    private Integer productId;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
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
