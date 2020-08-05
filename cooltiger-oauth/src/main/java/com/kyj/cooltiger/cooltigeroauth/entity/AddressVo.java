package com.kyj.cooltiger.cooltigeroauth.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/8/4 17:53
 * 收货地址实体类
 */
@Data
public class AddressVo implements Serializable {

    private static final long serialVersionUID = 1L;
    //主键
    private Long Id;
    //用户唯一标识
    private Long userCode;
    //会员名称
    private String userName;
    //省
    private  String provinceName;
    //市
    private  String cityName;
    //区
    private  String countryName;
    //详细地址
    private  String addressdetail;
    //是否默认
    private  Integer isdefaul;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;


}
