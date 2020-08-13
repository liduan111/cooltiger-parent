package com.kyj.cooltiger.feign.product.client;

import com.kyj.cooltiger.common.utils.Result;
import com.kyj.cooltiger.feign.product.vo.CountryRegionReqVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author liduan
 * Description: 国家地区Client
 * date: 2020/8/13 13:32
 */
@FeignClient(name = "Product-Service")
@RequestMapping("/product/countryRegion")
public interface CountryRegionClient {

    /**
     * 添加国家地区信息
     *
     * @param parentId
     * @param countryRegionReqVo
     * @return
     */
    @RequestMapping(value = "/addCountryRegion", method = {RequestMethod.POST})
    public Result addCountryRegion(
            @RequestParam("parent_id") Integer parentId,
            @RequestBody CountryRegionReqVo countryRegionReqVo);

    /**
     * 查询国家地区列表
     *
     * @param parentId
     * @return
     */
    @RequestMapping(value = "/getCountryRegion",method = {RequestMethod.GET})
    public Result getCountryRegion(
            @RequestParam("parent_id") Integer parentId);

    /**
     * 修改国家地区信息
     *
     * @param regionId
     * @param countryRegionReqVo
     * @return
     */
    @RequestMapping(value = "/updateCountryRegion",method = {RequestMethod.PUT})
    public Result updateCountryRegion(
            @RequestParam("region_id") Integer regionId,
            @RequestBody CountryRegionReqVo countryRegionReqVo);

    /**
     * 删除国家地区信息
     *
     * @param regionId
     * @return
     */
    @RequestMapping(value = "/delCountryRegion",method = {RequestMethod.DELETE})
    public Result delCountryRegion(
            @RequestParam("region_id") Integer regionId);

}
