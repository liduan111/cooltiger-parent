package com.kyj.cooltiger.cooltigeroauth.entity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/8/7 9:33
 * 商品实体类
 */
@Data
public class GoodsVo implements Serializable {

    private static final long serisbleid=1L;
    /** 商品ID */
    private  Integer productId;
    /** 商品编码 */
    private String productCode;
    /** 商品标题 */
    private String title;
    /** 店铺ID */
    private Integer storeId;
    /** 品牌ID */
    private Integer barandId;

    //图片类型（0-商品图片1-商品sku图片）
    private Integer type;
    //关联ID
    private Integer relationId;
    //图片url
    private String url;
    //是否为主图（0-否1-是）
    private Integer isMain;
    //品牌中文名称
    private String brandChineseName;
    //品牌英文名称
    private String brandEnglishName;
    //品牌图片
    private String brandLogoUrl;
    //品牌描述
    private String brandDesc;
    //品牌状态 0禁用，1描述
    private String brandStatus;
    // 销售价
    private  Double salePrice;
    //销售量
    private  Integer sellNum;
    //当天销售时间
    private Timestamp countDate;


}
