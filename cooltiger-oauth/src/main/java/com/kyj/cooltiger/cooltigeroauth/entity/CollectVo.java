package com.kyj.cooltiger.cooltigeroauth.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/8/10 10:45
 * 收藏实体类
 */
@Data
public class CollectVo implements Serializable  {

    private  static final long serialVersionUID = 1L;

    //主键
    private  Long Id;
    //用户唯一标识
    private Long userCode;
    //店铺id或商品id
    private  Integer codeId;
    //收藏类型  1店铺，2商品
    private  Integer codeType;
    //收藏商品或店铺名字
    private String  codeName;
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


}
