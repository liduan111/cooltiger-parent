package com.kyj.cooltiger.cooltigeroauth.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/8/5 15:50
 * 查询国家
 */
@Data
public class CountryReginVo implements Serializable {

    private  static  final long serialVersionUID=1L;
    //主键
    private Long regionId;
    //国家
    private String regionName;
    //父id
    private  Integer regionparentId;

}
