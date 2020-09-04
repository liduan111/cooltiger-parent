package com.kyj.cooltiger.feign.oauth.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/9/4 13:05
 */
@FeignClient(name = "Oauth-Service")
public interface FootprintClient {
    /**
     * 足迹列表
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public  Object Footprintlist(@RequestBody Map<String, Object> map);
    /**
     * 删除足迹
     * @param map
     * @return
     */
    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    public  Object  Footprintdelete(@RequestBody Map<String, Object> map);

}
