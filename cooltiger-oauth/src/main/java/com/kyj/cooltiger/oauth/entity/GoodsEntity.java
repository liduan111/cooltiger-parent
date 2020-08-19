package com.kyj.cooltiger.oauth.entity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/8/19 9:12
 */
@Data
public class GoodsEntity implements Serializable {
    /** 版本号 */
    private static final long serialVersionUID = 1L;

    /** 商品ID */
    private Integer productId;
    /** 商品编码 */
    private String productCode;
    /** 商品标题 */
    private String title;
    /** 店铺ID */
    private Integer storeId;
    /** 品牌ID */
    private Integer barandId;
    /** 一级分类ID */
    private Integer categoryOneId;
    /** 二级分类ID */
    private Integer categoryTwoId;
    /** 三级分类ID */
    private Integer categoryThreeId;
    /** 发货地ID */
    private Integer addressFromId;
    /** 产地ID */
    private Integer createAddressId;
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
    private Timestamp createTime;
    /** 最后修改时间 */
    private Timestamp modifiedTime;
}
