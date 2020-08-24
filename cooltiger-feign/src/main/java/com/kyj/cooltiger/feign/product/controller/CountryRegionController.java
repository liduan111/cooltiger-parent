package com.kyj.cooltiger.feign.product.controller;

import com.kyj.cooltiger.common.utils.Result;
import com.kyj.cooltiger.feign.product.client.CountryRegionClient;
import com.kyj.cooltiger.feign.product.vo.CountryRegionReqVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author liduan
 * Description:
 * date: 2020/8/24 13:55
 */
@RestController
@RequestMapping("/product/countryRegion")
public class CountryRegionController {

    @Autowired
    private CountryRegionClient countryRegionClient;

    /**
     * 添加国家地区信息
     *
     * @param parentId   地区父ID
     * @param regionName 地区名称
     * @param regionCode 地区行政编码
     * @param upFile     国旗
     * @return
     */
    @RequestMapping(value = "/addCountryRegion", method = {RequestMethod.POST})
    public Result addCountryRegion(
            @RequestParam("parent_id") Integer parentId,
            @RequestParam("region_name") String regionName,
            @RequestParam(value = "region_code", required = false) String regionCode,
            @RequestParam(value = "pict", required = false) MultipartFile upFile) {
        return countryRegionClient.addCountryRegion(parentId, regionName, regionCode, upFile);
    }

    /**
     * 查询国家地区列表
     *
     * @param parentId 地区父ID
     * @return
     */
    @RequestMapping(value = "/getCountryRegion", method = {RequestMethod.GET})
    public Result getCountryRegion(
            @RequestParam("parent_id") Integer parentId) {
        return countryRegionClient.getCountryRegion(parentId);
    }

    /**
     * 修改国家地区信息
     *
     * @param regionId   地区ID
     * @param regionName 地区名称
     * @param regionCode 地区行政编码
     * @return
     */
    @RequestMapping(value = "/updateCountryRegion", method = {RequestMethod.PUT})
    public Result updateCountryRegion(
            @RequestParam("region_id") Integer regionId,
            @RequestParam("region_name") String regionName,
            @RequestParam(value = "region_code", required = false) String regionCode) {
        return countryRegionClient.updateCountryRegion(regionId, regionName, regionCode);
    }

    /**
     * 删除国家地区信息
     *
     * @param regionId
     * @return
     */
    @RequestMapping(value = "/delCountryRegion", method = {RequestMethod.DELETE})
    public Result delCountryRegion(
            @RequestParam("region_id") Integer regionId) {
        return countryRegionClient.delCountryRegion(regionId);
    }

    /**
     * 更改国旗图片
     *
     * @param regionId
     * @param upFile
     * @return
     */
    @RequestMapping(value = "/updateNationalFlag",method = {RequestMethod.PUT})
    public Result updateNationalFlag(
            @RequestParam("region_id") Integer regionId,
            @RequestParam("pict") MultipartFile upFile){
        return countryRegionClient.updateNationalFlag(regionId,upFile);
    }
}
