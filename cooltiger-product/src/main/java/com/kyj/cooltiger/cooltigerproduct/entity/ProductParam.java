package com.kyj.cooltiger.cooltigerproduct.entity;

import java.io.Serializable;
import java.sql.Date;

/**
 * @author liduan
 * Description: 商品参数表
 * date: 2020/8/4 13:29
 */
public class ProductParam implements Serializable {
    /** 版本号 */
    private static final long serialVersionUID = 1L;

    //商品参数ID
    private Integer id;
    //商品ID
    private Integer productId;
    //参数名称
    private String paramName;
    //商品参数值
    private String paramValue;
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

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

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
