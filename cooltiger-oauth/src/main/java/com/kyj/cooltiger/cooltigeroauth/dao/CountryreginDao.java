package com.kyj.cooltiger.cooltigeroauth.dao;

import com.kyj.cooltiger.cooltigeroauth.entity.CountryReginVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/8/5 16:09
 */
@Mapper
public interface CountryreginDao {
    /**
     * 查询国家
     * @param param
     * @return
     */
    List<CountryReginVo> countrylist(Map<String, Object> param);
}
