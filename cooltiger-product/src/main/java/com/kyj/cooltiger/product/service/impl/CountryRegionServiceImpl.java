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
     * @param parentId 地区父ID
     * @param regionName 地区名称
     * @param regionCode 地区行政编码
     * @param nationalFlagUrl 国旗url
     */
    @Override
    public void addCountryRegion(Integer parentId, String regionName, String regionCode, String nationalFlagUrl) {
        int count = countryRegionMapper.getCountryRegionCountByRegionName(regionName);
        if (count > 0) {
            throw new MyException("REGION_NAME_IS_EXIST", "地区名称已存在");
        }
        //添加实体类
        CountryRegion countryRegion = null;
        countryRegion = new CountryRegion();
        countryRegion.setRegionName(regionName);
        countryRegion.setRegionCode(regionCode);
        countryRegion.setParentId(parentId);
        countryRegion.setNationalFlagUrl(nationalFlagUrl);
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
     * @param regionId   地区ID
     * @param regionName 地区名称
     * @param regionCode 地区行政编码
     * @param nationalFlagUrl 国旗Url
     * @return
     */
    @Override
    public void updateCountryRegion(Integer regionId, String regionName, String regionCode, String nationalFlagUrl) {
        CountryRegion countryRegion = countryRegionMapper.getCountryRegionByRegionId(regionId);
        if (countryRegion == null) {
            throw new MyException("REGION_NOT_EXIST", "地区不存在");
        }
        int count = countryRegionMapper.getCountryRegionCountByRegionName(regionName);
        if (!regionName.equals(countryRegion.getRegionName()) && count > 0) {
            throw new MyException("REGION_NAME_IS_EXIST", "地区名称已存在");
        }
        countryRegion.setRegionName(regionName);
        countryRegion.setRegionCode(regionCode);
        countryRegion.setNationalFlagUrl(nationalFlagUrl==null?countryRegion.getNationalFlagUrl():nationalFlagUrl);
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

    /**
     * 根据ID查询国家地区信息
     *
     * @param regionId
     * @return
     */
    @Override
    public CountryRegion getCountryRegionByRegionId(Integer regionId) {
        CountryRegion countryRegion = countryRegionMapper.getCountryRegionByRegionId(regionId);
        if (countryRegion == null) {
            throw new MyException("REGION_NOT_EXIST", "地区不存在");
        }
        return countryRegion;
    }
}
