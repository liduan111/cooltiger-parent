package com.kyj.cooltiger.feign.oauth.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/8/6 17:48
 */
@FeignClient(name = "Oauth-Service")
public interface CategoryClient {

    /**
     * 商品分类查询
     * @return
     */
    @RequestMapping(value ="/category/categorylist",method = RequestMethod.GET)
    public  Object categorylist(@RequestBody Map<String,Object> map);
}
