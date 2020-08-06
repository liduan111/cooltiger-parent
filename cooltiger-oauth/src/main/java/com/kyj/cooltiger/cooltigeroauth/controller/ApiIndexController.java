package com.kyj.cooltiger.cooltigeroauth.controller;

import com.kyj.cooltiger.cooltigerfeign.oauth.client.WxIndexClient;
import com.kyj.cooltiger.cooltigeroauth.entity.CountryReginVo;
import com.kyj.cooltiger.cooltigeroauth.entity.ProductCategoryVo;
import com.kyj.cooltiger.cooltigeroauth.entity.RotationchartVo;
import com.kyj.cooltiger.cooltigeroauth.service.ApiCountryreginService;
import com.kyj.cooltiger.cooltigeroauth.service.ApiProductCategoryService;
import com.kyj.cooltiger.cooltigeroauth.service.ApiRotationchartService;
import com.kyj.cooltiger.cooltigeroauth.utils.ApiBaseAction;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 首页
 * @author guoxq
 * @version 1.0
 * @date 2020/8/5 15:38
 */
@Api("首页")
@RestController
@RequestMapping("/index")
public class ApiIndexController extends ApiBaseAction implements WxIndexClient {

    @Autowired
    private ApiCountryreginService countryreginService;
    @Autowired
    private ApiRotationchartService rotationchartService;
    @Autowired
    private ApiProductCategoryService productCategoryService;

    /**
     * 小程序首页
     * @return
     */
    @ApiOperation("首页")
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public  Object  index(){
        Map<String,Object>  map=new HashMap<String,Object>();
        Map<String,Object>  param=new HashMap<String,Object>();
        param.put("sidx", "region_id");
        param.put("order", "desc ");
        param.put("offset", 0);
        param.put("limit", 4);
        //查询导航栏国家
        List<CountryReginVo>  countryReginList=countryreginService.countrylist(param);
        map.put("countryReginList",countryReginList);
        Map<String,Object>  param1=new HashMap<String,Object>();
        param1.put("sidx", "rotation_id");
        param1.put("order", "desc ");
        param1.put("offset", 0);
        param1.put("limit", 1);
        //查询轮播图
        List<RotationchartVo> rotationchartVoList=rotationchartService.querypicturelist(param1);
        map.put("volist",rotationchartVoList);
        //查询商品分类
        List<ProductCategoryVo>  productCategoryVoList=productCategoryService.querycategorylist();
        map.put("productCategoryList",productCategoryVoList);




        return toResponsSuccess(map);
    }


}
