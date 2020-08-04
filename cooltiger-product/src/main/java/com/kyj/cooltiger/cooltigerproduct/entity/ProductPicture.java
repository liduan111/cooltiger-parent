package com.kyj.cooltiger.cooltigerproduct.entity;

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
    private Integer id;
    //图片类型（0-商品图片1-商品sku图片）
    private Integer type;
    //关联ID
    private Integer relationId;
    //图片url
    private String url;
    //是否为主图（0-否1-是）
    private Integer isMain;
    //排序
    private Integer order;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getRelationId() {
        return relationId;
    }

    public void setRelationId(Integer relationId) {
        this.relationId = relationId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getIsMain() {
        return isMain;
    }

    public void setIsMain(Integer isMain) {
        this.isMain = isMain;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }
}
