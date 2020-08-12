package com.kyj.cooltiger.oauth.controller;

import com.kyj.cooltiger.oauth.entity.ShopCartVo;
import com.kyj.cooltiger.oauth.service.ApiShopCartService;
import com.kyj.cooltiger.oauth.utils.ApiBaseAction;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/8/12 15:25
 */
@Api("购物车")
@RestController
@RequestMapping("/cart")
public class ShopCartController extends ApiBaseAction {

    @Autowired
    private ApiShopCartService shopCartService;

    @ApiOperation("购物车列表")
    @RequestMapping(value = "",method = RequestMethod.GET)
    public Object  shopcartlist(@RequestBody Map<String,Object> map){

        if(map.size()==0||map.toString()==null){
            return  toResponsFail("参数为空");
        }
        map.put("sidx", "create_time");
        map.put("order", "desc ");
        map.put("offset", 0);
        map.put("limit", 8);
        List<ShopCartVo>  shopCartVoList=shopCartService.shopcartlist(map);
        return toResponsSuccess(shopCartVoList);
    }







}
