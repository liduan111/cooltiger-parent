package com.kyj.cooltiger.product.service;

import com.kyj.cooltiger.feign.product.vo.CountryRegionReqVo;

import java.util.Map;

/**
 * @author liduan
 * Description: 国家地区service接口
 * date: 2020/8/13 13:38
 */
public interface CountryRegionService {

    /**
     * 添加国家地区信息
     *
     * @param parentId
     * @param countryRegionReqVo
     */
    public void addCountryRegion(Integer parentId, CountryRegionReqVo countryRegionReqVo);

    /**
     * 查询国家地区列表
     *
     * @param parentId
     * @return
     */
    public Map<String, Object> getCountryRegion(Integer parentId);

    /**
     * 修改国家地区信息
     *
     * @param regionId
     * @param countryRegionReqVo
     * @return
     */
    public void updateCountryRegion(Integer regionId, CountryRegionReqVo countryRegionReqVo);

    /**
     * 删除国家地区信息
     *
     * @param regionId
     */
    public void delCountryRegion(Integer regionId);
}
