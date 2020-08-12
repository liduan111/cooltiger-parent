package com.kyj.cooltiger.feign.oauth.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/8/6 15:35
 */
@FeignClient(name ="Oauth-Service")
public interface AddressClient {
    /**
     * 根据用户id查询收货地址
     * @param code
     * @return
     */
    @RequestMapping(value = "/queryaddress",method = RequestMethod.GET)
    public Object queryaddress(@RequestBody String code);

    /***
     * 添加收货人地址
     * @param map
     * @return
     */
    @RequestMapping(value = "/addressadd",method = RequestMethod.POST)
    public  Object  addressave(@RequestBody Map<String,Object> map);
    /**
     * 修改收货人地址
     * @param map
     * @return
     */
    @RequestMapping(value = "/addressupdate",method = RequestMethod.POST)
    public  Object  addressupdate(@RequestBody Map<String,Object> map);

    /**
     * 收货地址列表
     * @return
     */
    @RequestMapping(value = "/addresslist",method = RequestMethod.GET)
    public  Object Addresslist();
}
