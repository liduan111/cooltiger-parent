package com.kyj.cooltiger.cooltigerfeign.clients.oauth;

import com.kyj.cooltiger.cooltigercommon.utils.LoginInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/7/29 17:37
 */
@FeignClient(name ="Oauth-Service" )
public interface OauthClient {

    /**
     *
     * @param loginInfo
     * @param request
     * @return
     */
   @RequestMapping(value = "/login",method = {RequestMethod.GET})
    public Object wxlogin(@RequestBody LoginInfo loginInfo, HttpServletRequest request);

}
