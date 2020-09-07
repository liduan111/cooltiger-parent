package com.kyj.cooltiger.feign.oauth.controller;

import com.kyj.cooltiger.feign.oauth.client.FootprintClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/9/4 13:09
 */
@RestController
@RequestMapping(value = "/api/footprint")
public class FootprintController {
    @Autowired
    private FootprintClient footprintClient;

    /**
     * 足迹列表
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public  Object Footprintlist(@RequestBody Map<String,Object> map){
        return  footprintClient.Footprintlist(map);
    }
    /**
     * 删除足迹
     * @param map
     * @return
     */
    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    public  Object  Footprintdelete(@RequestBody Map<String,Object> map){
        return footprintClient.Footprintdelete(map);
    }

}
