package com.kyj.cooltiger.cooltigeroauth.service;

import com.kyj.cooltiger.cooltigeroauth.entity.RotationchartVo;

import java.util.List;
import java.util.Map;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/8/6 11:07
 */
public interface ApiRotationchartService {
    List<RotationchartVo> querypicturelist(Map<String,Object> param1);

}
