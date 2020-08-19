package com.kyj.cooltiger.product.service;

import com.kyj.cooltiger.feign.product.vo.CountryRegionReqVo;
import com.kyj.cooltiger.product.entity.CountryRegion;

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
     * @param parentId 地区父ID
     * @param regionName 地区名称
     * @param regionCode 地区行政编码
     * @param nationalFlagUrl 国旗url
     */
    public void addCountryRegion(Integer parentId, String regionName, String regionCode, String nationalFlagUrl);

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

    /**
     * 根据ID查询国家地区信息
     *
     * @param regionId
     * @return
     */
    public CountryRegion getCountryRegionByRegionId(Integer regionId);
}
