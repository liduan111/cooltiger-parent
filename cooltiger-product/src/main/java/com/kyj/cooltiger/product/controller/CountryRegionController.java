package com.kyj.cooltiger.product.controller;

import com.kyj.cooltiger.common.utils.Result;
import com.kyj.cooltiger.feign.product.client.CountryRegionClient;
import com.kyj.cooltiger.feign.product.vo.CountryRegionReqVo;
import com.kyj.cooltiger.product.service.CountryRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author liduan
 * Description: 国家地区controller
 * date: 2020/8/13 13:35
 */
@RestController
@RequestMapping("/product/countryRegion")
public class CountryRegionController implements CountryRegionClient {

    @Autowired
    private CountryRegionService countryRegionService;

    /**
     * 添加国家地区信息
     *
     * @param parentId
     * @param countryRegionReqVo
     * @return
     */
    @Override
    @RequestMapping(value = "/addCountryRegion", method = {RequestMethod.POST})
    public Result addCountryRegion(
            @RequestParam("parent_id") Integer parentId,
            @RequestBody CountryRegionReqVo countryRegionReqVo){
        countryRegionService.addCountryRegion(parentId,countryRegionReqVo);
        return Result.success();
    }

    /**
     * 查询国家地区列表
     *
     * @param parentId
     * @return
     */
    @Override
    @RequestMapping(value = "/getCountryRegion",method = {RequestMethod.GET})
    public Result getCountryRegion(
            @RequestParam("parent_id") Integer parentId){
        Map<String,Object> res = countryRegionService.getCountryRegion(parentId);
        return Result.success(res.get("data"));
    }

    /**
     * 修改国家地区信息
     *
     * @param regionId
     * @param countryRegionReqVo
     * @return
     */
    @Override
    @RequestMapping(value = "/updateCountryRegion",method = {RequestMethod.PUT})
    public Result updateCountryRegion(
            @RequestParam("region_id") Integer regionId,
            @RequestBody CountryRegionReqVo countryRegionReqVo){
        countryRegionService.updateCountryRegion(regionId,countryRegionReqVo);
        return Result.success();
    }

    /**
     * 删除国家地区信息
     *
     * @param regionId
     * @return
     */
    @Override
    @RequestMapping(value = "/delCountryRegion",method = {RequestMethod.DELETE})
    public Result delCountryRegion(
            @RequestParam("region_id") Integer regionId){
        countryRegionService.delCountryRegion(regionId);
        return Result.success();
    }
}
