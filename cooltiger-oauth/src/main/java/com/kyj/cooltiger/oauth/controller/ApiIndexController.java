package com.kyj.cooltiger.oauth.controller;

import com.kyj.cooltiger.common.excep.MyException;
import com.kyj.cooltiger.common.utils.DateUtils;
import com.kyj.cooltiger.feign.oauth.client.WxIndexClient;
import com.kyj.cooltiger.oauth.entity.*;
import com.kyj.cooltiger.oauth.service.*;
import com.kyj.cooltiger.oauth.utils.ApiBaseAction;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
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
@RequestMapping("/api")
public class ApiIndexController extends ApiBaseAction implements WxIndexClient {

    @Autowired
    private ApiCountryreginService countryreginService;
    @Autowired
    private ApiRotationchartService rotationchartService;
    @Autowired
    private ApiProductCategoryService productCategoryService;
    @Autowired
    private ApiGoodsService goodsService;
    @Autowired
    private SearchRecordService searchRecordService;


    /**
     * 小程序首页
     * @return
     */
    @ApiOperation("首页")
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public  Object  index(){
        Map<String,Object>  map=new HashMap<String,Object>();
        /*Map<String,Object>  param=new HashMap<String,Object>();
        param.put("sidx", "region_id");
        param.put("order", "desc ");
        param.put("offset", 0);
        param.put("limit", 3);
        //查询导航栏国家
        List<CountryReginVo>  countryReginList=countryreginService.countrylist(param);
        map.put("countryReginList",countryReginList);*/
        Map<String,Object>  param1=new HashMap<String,Object>();
        param1.put("sidx", "rotation_id");
        param1.put("order", "desc ");
        param1.put("offset", 0);
        param1.put("limit", 1);
        //查询轮播图
        List<RotationchartVo> rotationchartVoList=rotationchartService.querypicturelist(param1);
        map.put("volist",rotationchartVoList);
        //查询商品分类
        Date startTime=DateUtils.getFirstDayOfThisMonth();
        Date endTime= DateUtils.getDatesmins();
        /*List<ProductCategoryVo>  productCategoryVoList=productCategoryService.querycategorylist();
        map.put("productCategoryList",productCategoryVoList);*/
        Map<String,Object>  param2=new HashMap<String,Object>();
        param2.put("sidx", "sell_num");
        param2.put("order", "desc ");
        param2.put("offset", 0);
        param2.put("limit",4);
        param2.put("startTime",startTime);
        param2.put("endTime",endTime);
        //查询商品列表
        List<GoodsVo> goodsVoList=goodsService.goodslist(param2);
        map.put("goodsVoList",goodsVoList);
        return toResponsSuccess(map);
    }

    @ApiOperation("获取查询的商品")
    @RequestMapping(value = "/goodslist",method = RequestMethod.GET)
    public Object  querygoodslist(@RequestParam("keyword")String keyword,@RequestParam("userId")Long userId){

        if (keyword.isEmpty()||keyword.equals("")){
            new MyException("500","参数为空");
        }
        SearchRecordEntity  searchRecord =new SearchRecordEntity();
        searchRecord.setKeyword(keyword);
        searchRecord.setUserId(userId);
        searchRecord.setCreateTime(System.currentTimeMillis() / 1000);
        if (searchRecord !=null||!searchRecord.equals("")){
            boolean flag=searchRecordService.save(searchRecord);
            if (flag){
                return toResponsMsgSuccess("success");
            }
        }
        return  toResponsSuccess(null);
    }

}
