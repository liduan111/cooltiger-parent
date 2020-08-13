package com.kyj.cooltiger.product.service.impl;

import com.kyj.cooltiger.common.excep.MyException;
import com.kyj.cooltiger.feign.product.vo.CountryRegionReqVo;
import com.kyj.cooltiger.product.entity.CountryRegion;
import com.kyj.cooltiger.product.mapper.CountryRegionMapper;
import com.kyj.cooltiger.product.service.CountryRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author liduan
 * Description: 国家地区service实现类
 * date: 2020/8/13 13:38
 */
@Service
public class CountryRegionServiceImpl implements CountryRegionService {

    @Autowired
    private CountryRegionMapper countryRegionMapper;

    /**
     * 添加国家地区信息
     *
     * @param parentId
     * @param countryRegionReqVo
     */
    @Override
    public void addCountryRegion(Integer parentId, CountryRegionReqVo countryRegionReqVo) {
        int count = countryRegionMapper.getCountryRegionCountByRegionName(countryRegionReqVo.getRegionName());
        if (count > 0) {
            throw new MyException("REGION_NAME_IS_EXIST", "地区名称已存在");
        }
        //添加
        CountryRegion countryRegion = null;
        countryRegion = new CountryRegion();
        countryRegion.setRegionName(countryRegionReqVo.getRegionName());
        countryRegion.setRegionCode(countryRegionReqVo.getRegionCode());
        countryRegion.setParentId(parentId);
        countryRegion.setNationalFlagUrl(countryRegionReqVo.getNationalFlagUrl());
        //插入
        countryRegionMapper.addCountryRegion(countryRegion);
    }

    /**
     * 查询国家地区列表
     *
     * @param parentId
     * @return
     */
    @Override
    public Map<String, Object> getCountryRegion(Integer parentId) {
        List<CountryRegion> countryRegionList = countryRegionMapper.getCountryRegionByParentId(parentId);
        Map<String, Object> resMap = new HashMap<>();
        resMap.put("data", countryRegionList);
        return resMap;
    }

    /**
     * 修改国家地区信息
     *
     * @param regionId
     * @param countryRegionReqVo
     * @return
     */
    @Override
    public void updateCountryRegion(Integer regionId, CountryRegionReqVo countryRegionReqVo) {
        CountryRegion countryRegion = countryRegionMapper.getCountryRegionByRegionId(regionId);
        if (countryRegion == null) {
            throw new MyException("REGION_NOT_EXIST", "地区不存在");
        }
        int count = countryRegionMapper.getCountryRegionCountByRegionName(countryRegionReqVo.getRegionName());
        if (!countryRegionReqVo.getRegionName().equals(countryRegion.getRegionName()) && count > 0) {
            throw new MyException("REGION_NAME_IS_EXIST", "地区名称已存在");
        }
        countryRegion.setRegionName(countryRegionReqVo.getRegionName());
        countryRegion.setRegionCode(countryRegionReqVo.getRegionCode());
        countryRegion.setNationalFlagUrl(countryRegionReqVo.getNationalFlagUrl());
        countryRegionMapper.updateCountryRegion(countryRegion);
    }

    /**
     * 删除国家地区信息
     *
     * @param regionId
     */
    @Override
    public void delCountryRegion(Integer regionId) {
        CountryRegion countryRegion = countryRegionMapper.getCountryRegionByRegionId(regionId);
        if (countryRegion == null) {
            throw new MyException("REGION_NOT_EXIST", "地区不存在");
        }
        countryRegionMapper.delCountryRegion(regionId);
    }
}
