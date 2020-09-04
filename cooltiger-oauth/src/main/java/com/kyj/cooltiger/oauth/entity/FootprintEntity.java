package com.kyj.cooltiger.oauth.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/9/4 10:03
 */
@Data
public class FootprintEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    //主键
    private Integer Id;
    //用户唯一标识
    private Long userId;
    //商品id
    private Integer goodsId;
    //创建时间
    private Date createTime;
    //商品标题
    private  String  picTitle;
    //商品图片
    private String picUrl;
    //商品价格
    private  Double saleprice;

}
