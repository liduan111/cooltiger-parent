package com.kyj.cooltiger.feign.oauth.controller;

import com.kyj.cooltiger.feign.oauth.client.WxIndexClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liduan
 * Description:
 * date: 2020/8/24 14:45
 */
@RestController
@RequestMapping("/api")
public class WxIndexController {

    @Autowired
    private WxIndexClient wxIndexClient;

    /**
     * 首页查询导航栏
     * @return
     */
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public  Object  index(){
        return wxIndexClient.index();
    }
}
