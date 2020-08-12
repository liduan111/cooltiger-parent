package com.kyj.cooltiger.oauth.service;

import com.kyj.cooltiger.oauth.entity.CountryReginVo;

import java.util.List;
import java.util.Map;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/8/5 16:07
 */
public interface ApiCountryreginService {

   List<CountryReginVo> countrylist(Map<String,Object> param);

}
