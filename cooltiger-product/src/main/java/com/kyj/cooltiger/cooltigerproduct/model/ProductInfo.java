package com.kyj.cooltiger.cooltigerproduct.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author liduan
 * Description: 商品信息表Model
 * date: 2020/7/28 15:16
 */
public class ProductInfo implements Serializable {
    /** 版本号 */
    private static final long serialVersionUID = 1L;

    /** 商品ID */
    private Integer productId;
    /** 商品编码 */
    private String productCode;
    /** 商品标题 */
    private String title;
    /** 商家ID */
    private Integer sellerId;
    /** 店铺ID */
    private Integer storeId;
    /** 品牌ID */
    private Integer brandId;
    /** 分类ID */
    private Integer categoryId;
    /** 产地ID */
    private Integer createAddressId;
    /** 发货地ID */
    private Integer addressFromId;
    /** 预计送达时间（单位/天） */
    private Integer aboutDeliverTime;
    /** 服务ID（多个用,分隔） */
    private String serviceIds;
    /** 上架状态：0下架1上架 */
    private Integer shelfStatus;
    /** 审核状态：0未审核1已审核 */
    private Integer auditStatus;
    /** 是否删除（0未删除1已删除） */
    private Integer deleted;
    /** 商品录入时间 */
    private Date createTime;
    /** 最后修改时间 */
    private Date modifiedTime;


}
