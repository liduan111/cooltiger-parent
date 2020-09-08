package com.kyj.cooltiger.product.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author liduan
 * Description: 商品服务表
 * date: 2020/8/4 13:05
 */
public class ProductService  implements Serializable {
    /** 版本号 */
    private static final long serialVersionUID = 1L;

    //商品服务ID
    private Integer serviceId;
    //服务名称
    private String serviceName;
    //服务详情
    private String serviceDetail;
    //服务类型（0-通用服务1-商品自有服务）
    private Integer serviceType;
    //添加服务的商品ID
    private Integer productId;
    //创建时间
    private Timestamp createTime;
    //最后修改时间
    private Timestamp modifiedTime;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceDetail() {
        return serviceDetail;
    }

    public void setServiceDetail(String serviceDetail) {
        this.serviceDetail = serviceDetail;
    }

    public Integer getServiceType() {
        return serviceType;
    }

    public void setServiceType(Integer serviceType) {
        this.serviceType = serviceType;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
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
