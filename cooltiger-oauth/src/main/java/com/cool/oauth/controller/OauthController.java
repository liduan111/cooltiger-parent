
package com.cool.oauth.controller;


import com.cool.common.utils.GenericResponse;
import com.cool.oauth.service.ApiUserService;
import com.cool.oauth.service.WeChatService;
import com.kyj.cooltiger.cooltigerfeign.clients.oauth.OauthClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/7/23 16:58
 */
@Api(tags = "API登录授权接口")
@RestController
@RequestMapping("/api")
public class OauthController  implements OauthClient {

    @Autowired
    private WeChatService weChatService;



    @Autowired
    private ApiUserService apiUserService;
/**
     * code登录获取用户openid
     * @param
     * @return
     * @throws Exception
     */
  /*  @ApiOperation(value = "登录")
    @RequestMapping("/login")
    public GenericResponse login(String code)throws Exception{
        return weChatService.wxLogin(code);
    }*/

    @ApiOperation(value = "登录")
    @RequestMapping("/login")
    public GenericResponse wxlogin(String id) {
        return null;
    }

   /* @GetMapping("/test")
    public GenericResponse test(){
        return GenericResponse.response(ServiceError.NORMAL,"test");
    }

    @PostMapping("/test")
    public GenericResponse testPost(){
        return GenericResponse.response(ServiceError.NORMAL,"testPOST");
    }

    @GetMapping("/test/a")
    public GenericResponse testA(){
        return GenericResponse.response(ServiceError.NORMAL,"testManage");
    }

    @GetMapping("/hello")
    public GenericResponse hello(){
        return GenericResponse.response(ServiceError.NORMAL,"hello security");
    }

    @GetMapping("/ddd")
    @PreAuthorize("hasAuthority('ddd:list')")//基于表达式的权限验证，调用此方法需有 "ddd:list" 的权限
    public GenericResponse ddd(){
        return GenericResponse.response(ServiceError.NORMAL,"dddList");
    }

    @PostMapping("/ddd")
    @PreAuthorize("hasAuthority('ddd:add')")//基于表达式的权限验证，调用此方法需有 "ddd:list" 的权限
    public GenericResponse dddd(){
        return GenericResponse.response(ServiceError.NORMAL,"testPOST");
    }*/


}
