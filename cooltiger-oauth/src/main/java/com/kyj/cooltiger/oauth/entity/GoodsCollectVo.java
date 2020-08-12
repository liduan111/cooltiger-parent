package com.kyj.cooltiger.oauth.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/8/11 11:45
 * 收藏商品实体类
 */
@Data
public class GoodsCollectVo implements Serializable {

    private  static final long serialVersionUID = 1L;

    //主键
    private  Long Id;
    //用户唯一标识
    private Long userCode;
    //店铺id或商品id
    private  Integer codeId;
    //收藏类型  1店铺，2商品
    private  Integer codeType;
    //商品描述
    private String  title;
    //收藏商品或店铺图片
    private String codeLogourl;
    //是否删除 0未删除1已删除
    private  Integer deleted;
    //创建时间
    private Date createTime;
    //修改时间
    private Date updateTime;
    //收藏时间
    private Date collectTime;
    // 销售价
    private  Double salePrice;
    //收藏人数
    private  Integer  collectnum;

}
