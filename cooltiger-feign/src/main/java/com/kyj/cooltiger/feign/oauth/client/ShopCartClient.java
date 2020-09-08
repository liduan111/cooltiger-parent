package com.kyj.cooltiger.feign.oauth.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/8/13 10:25
 * 购物车
 */
@FeignClient(name = "Oauth-Service")
public interface ShopCartClient {

    /**
     * 购物车列表展示
     *
     * @param map
     * @return
     */
    @RequestMapping(value = "/shopCart", method = RequestMethod.GET)
    public Object shopcartlist(@RequestBody Map<String, Object> map);

    /**
     * 加入购物车
     *
     * @param map
     * @return
     */
    @RequestMapping(value = "/shopCart/addshopcart", method = RequestMethod.POST)
    public Object addshopcart(@RequestBody Map<String, Object> map);

    /**
     * piliang删除购物车
     * @param
     * @return
     */
    @RequestMapping(value = "/shopCart/deleteAllgoods",method = RequestMethod.DELETE)
    public  Object deleteAllgoods(@RequestParam("userId") Long userId, @RequestParam("cartIds")String cartIds);


    /**
     * 获得商品数
     *
     * @return
     */
    @RequestMapping(value = "/shopCart/getgoodsNum", method = RequestMethod.GET)
    public Object getgoodsNum(@RequestBody Map<String, Object> map);

}
