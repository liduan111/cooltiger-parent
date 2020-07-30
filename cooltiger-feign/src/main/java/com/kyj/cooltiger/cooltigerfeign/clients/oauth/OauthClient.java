package com.kyj.cooltiger.cooltigerfeign.clients.oauth;

import com.cool.common.utils.GenericResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/7/29 17:37
 */
@FeignClient(name ="Oauth-Service" )
public interface OauthClient {

    /**
     *  登录
     * @param id
     * @return
     */
    @RequestMapping(value = "/login",method = {RequestMethod.GET})
    public GenericResponse wxlogin(@PathVariable("id") String id);

}
