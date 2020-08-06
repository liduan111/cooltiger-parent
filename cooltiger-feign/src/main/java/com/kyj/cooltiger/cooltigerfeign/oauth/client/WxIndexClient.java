package com.kyj.cooltiger.cooltigerfeign.oauth.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/8/6 10:14
 */
@FeignClient(name ="Oauth-Service",configuration = FeignClientProperties.FeignClientConfiguration.class,contextId = "wxindex")
public interface WxIndexClient {
    /**
     * 首页查询导航栏
     * @return
     */
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public  Object  index();
}
