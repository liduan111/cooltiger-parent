package com.kyj.cooltiger.feign.oauth.controller;

import com.kyj.cooltiger.feign.oauth.client.ShopCartClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author liduan
 * Description:
 * date: 2020/8/24 14:40
 */
@RestController
@RequestMapping("/shopCart")
public class ShopCartController {

    @Autowired
    private ShopCartClient shopCartClient;

    /**
     * 购物车列表展示
     * @param map
     * @return
     */
    @RequestMapping(value = "",method = RequestMethod.GET)
    public Object  shopcartlist(@RequestBody Map<String,Object> map){
        return shopCartClient.shopcartlist(map);
    }
    /**
     * 加入购物车
     * @param map
     * @return
     */
    @RequestMapping(value = "/addshopcart",method = RequestMethod.POST)
    public  Object  addshopcart(@RequestBody Map<String,Object> map){
        return shopCartClient.addshopcart(map);
    }
    /**
     * 删除购物车
     * @param parms
     * @return
     */
    @RequestMapping(value = "/deleteAllgoods",method = RequestMethod.DELETE)
    public  Object deleteAllgoods(@RequestBody String  parms){
        return shopCartClient.deleteAllgoods(parms);
    }
    /**
     *获得商品数
     * @return
     */
    @RequestMapping(value = "/getgoodsNum",method = RequestMethod.GET)
    public Object getgoodsNum(@RequestBody Map<String,Object> map){
        return shopCartClient.getgoodsNum(map);
    }
}
