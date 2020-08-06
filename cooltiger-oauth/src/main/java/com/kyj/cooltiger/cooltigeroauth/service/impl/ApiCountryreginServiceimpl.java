package com.kyj.cooltiger.cooltigeroauth.service.impl;

import com.kyj.cooltiger.cooltigeroauth.dao.CountryreginDao;
import com.kyj.cooltiger.cooltigeroauth.entity.CountryReginVo;
import com.kyj.cooltiger.cooltigeroauth.service.ApiCountryreginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/8/5 16:08
 */
@Service
public class ApiCountryreginServiceimpl implements ApiCountryreginService {

    @Autowired
    private CountryreginDao countryreginDao;

    /**
     * 查询国家
     * @param param
     * @return
     */
    @Override
    public List<CountryReginVo> countrylist(Map<String, Object> param) {
        return countryreginDao.countrylist(param);
    }
}
