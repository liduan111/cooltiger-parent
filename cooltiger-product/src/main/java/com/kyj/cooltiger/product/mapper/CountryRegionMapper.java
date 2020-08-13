package com.kyj.cooltiger.product.mapper;

import com.kyj.cooltiger.product.entity.CountryRegion;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liduan
 * Description: 国家地区mapper
 * date: 2020/8/13 13:40
 */
@Mapper
public interface CountryRegionMapper {

    /**
     * 查询添加名字是否存在
     *
     * @param regionName
     * @return
     */
    public int getCountryRegionCountByRegionName(@Param("regionName") String regionName);

    /**
     * 插入
     *
     * @param countryRegion
     */
    public void addCountryRegion(@Param("countryRegion") CountryRegion countryRegion);

    /**
     * 查询国家地区列表
     *
     * @param parentId
     * @return
     */
    public List<CountryRegion> getCountryRegionByParentId(@Param("parentId") Integer parentId);

    /**
     * 查询国家地区信息
     *
     * @param regionId
     * @return
     */
    public CountryRegion getCountryRegionByRegionId(@Param("regionId") Integer regionId);

    /**
     * 修改国家地区信息
     *
     * @param countryRegion
     */
    public void updateCountryRegion(@Param("countryRegion") CountryRegion countryRegion);

    /**
     * 删除国家地区信息
     *
     * @param regionId
     */
    public void delCountryRegion(@Param("regionId") Integer regionId);
}
