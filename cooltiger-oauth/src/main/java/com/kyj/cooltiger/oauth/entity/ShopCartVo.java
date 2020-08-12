package com.kyj.cooltiger.oauth.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/8/12 15:46
 */
@Data
public class ShopCartVo implements Serializable {

    private static final long seriableid=1L;

    //主键
    private  Long Id;
    //用户
    private Long userCode;
    //店铺id
    private Integer storeId;
    //店铺名字
    private String storeName;
    //店铺头像
    private String logoUrl;
    //商品skuid
    private Integer skuId;
    //商品标题
    private String  title;
    //商品图片
    private String goodsurl;
    //价格
    private  Double salePrice;
    //
    private  String goodsspecifitionids;
    //规格值
    private String   goodsspecifitionvaluename;
    //加入数量
    private Integer shopNum;
    //创建时间
    private Date createTime;
    //修改时间
    private Date updateTime;









}
