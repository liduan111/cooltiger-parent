package com.kyj.cooltiger.cooltigerfeign.oauth.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/8/6 17:48
 */
@FeignClient(name ="Oauth-Service")
public interface ProductCategoryClient {

    /**
     * 商品分类查询
     * @return
     */
    @RequestMapping(value ="/categorylist",method = RequestMethod.GET)
    public  Object categorylist();
}
