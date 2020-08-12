package com.kyj.cooltiger.oauth.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/8/6 10:59
 * 轮播图实体类
 */
@Data
public class RotationchartVo implements Serializable {

    private  static  final long serinbleid=1L;
    //主键
    private Long rotationId;
    //图片路径
    private String  pictureUrl;

}
