package com.kyj.cooltiger.feign.oauth.controller;

import com.kyj.cooltiger.feign.oauth.client.CollectClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author liduan
 * Description:
 * date: 2020/8/24 14:28
 */
@RestController
@RequestMapping("/api/collect")
public class CollectController {

    @Autowired
    private CollectClient collectClient;

    /**
     * 查询店铺收藏列表
     * @param map
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public  Object collectlist(@RequestBody Map<String,Object> map){
        return collectClient.collectlist(map);
    }

    /**
     * 添加收藏
     * @param map
     * @return
     */
    @RequestMapping(value = "/addcollect",method = RequestMethod.POST)
    public  Object collectsave(@RequestBody Map<String,Object> map){
        return collectClient.collectsave(map);
    }
    /**
     * 取消关注店铺
     * @param map
     * @return
     */
    @RequestMapping(value = "/remove",method = RequestMethod.POST)
    public Object  removecollect(@RequestBody Map<String,Object> map){
        return collectClient.removecollect(map);
    }
    /**
     * 商品收藏列表
     * @param map
     * @return
     */
    @RequestMapping(value = "/goodscollectlist",method = RequestMethod.GET)
    public  Object goodscollectlist(@RequestBody Map<String,Object> map){
        return collectClient.goodscollectlist(map);
    }
    /**
     * 商品收藏
     * @param map
     * @return
     */
    @RequestMapping(value = "/goodscollectsave",method = RequestMethod.POST)
    public Object  goodscollectsave(@RequestBody Map<String,Object> map){
        return collectClient.goodscollectsave(map);
    }
    /**
     * 取消商品收藏
     * @param map
     * @return
     */
    @RequestMapping(value = "/canselgoodscollect",method = RequestMethod.PUT)
    public Object canselgoodscollect(@RequestBody Map<String,Object> map){
        return collectClient.canselgoodscollect(map);
    }
}
