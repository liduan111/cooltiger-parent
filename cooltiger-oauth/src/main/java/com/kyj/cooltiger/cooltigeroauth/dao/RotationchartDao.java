package com.kyj.cooltiger.cooltigeroauth.dao;

import com.kyj.cooltiger.cooltigeroauth.entity.RotationchartVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/8/6 11:09
 */
@Mapper
public interface RotationchartDao {

    List<RotationchartVo> querypicturelist(Map<String, Object> param1);

}
