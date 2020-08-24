package com.kyj.cooltiger.feign.oauth.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/8/10 13:39
 */
@FeignClient(name = "Oauth-Service")
public interface CollectClient {
    /**
     * 查询店铺收藏列表
     * @param map
     * @return
     */
    @RequestMapping(value = "/collect/list",method = RequestMethod.GET)
    public  Object collectlist(@RequestBody Map<String,Object> map);

    /**
     * 添加收藏
     * @param map
     * @return
     */
    @RequestMapping(value = "/collect/addcollect",method = RequestMethod.POST)
    public  Object collectsave(@RequestBody Map<String,Object> map);
    /**
     * 取消关注店铺
     * @param map
     * @return
     */
    @RequestMapping(value = "/collect/remove",method = RequestMethod.POST)
    public Object  removecollect(@RequestBody Map<String,Object> map);
    /**
     * 商品收藏列表
     * @param map
     * @return
     */
    @RequestMapping(value = "/collect/goodscollectlist",method = RequestMethod.GET)
    public  Object goodscollectlist(@RequestBody Map<String,Object> map);
    /**
     * 商品收藏
     * @param map
     * @return
     */
    @RequestMapping(value = "/collect/goodscollectsave",method = RequestMethod.POST)
    public Object  goodscollectsave(@RequestBody Map<String,Object> map);
    /**
     * 取消商品收藏
     * @param map
     * @return
     */
    @RequestMapping(value = "/collect/canselgoodscollect",method = RequestMethod.PUT)
    public Object canselgoodscollect(@RequestBody Map<String,Object> map);

}
