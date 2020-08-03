
package com.kyj.cooltiger.cooltigeroauth.controller;


import com.kyj.cooltiger.cooltigercommon.utils.GenericResponse;
import com.kyj.cooltiger.cooltigercommon.utils.LoginInfo;
import com.kyj.cooltiger.cooltigeroauth.service.ApiUserService;
import com.kyj.cooltiger.cooltigeroauth.service.WeChatService;
import com.kyj.cooltiger.cooltigeroauth.service.impl.TokenService;
import com.kyj.cooltiger.cooltigeroauth.utils.ApiUserUtils;
import com.kyj.cooltiger.cooltigerfeign.oauth.client.OauthClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/7/23 16:58
 */
@Api(tags = "API登录授权接口")
@RestController
@RequestMapping("/api")
public class OauthController  implements OauthClient {

    private static  final Logger logger= LoggerFactory.getLogger(OauthController.class);

    @Autowired
    private WeChatService weChatService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private ApiUserService apiUserService;

    /*@Autowired
    private  RestTemplate restTemplate;*/
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
    public GenericResponse wxlogin(@RequestBody LoginInfo loginInfo, HttpServletRequest request) {

        //获取openid
        String requestUrl = ApiUserUtils.getWebAccess(loginInfo.getCode());//通过自定义工具类组合出小程序需要的登录凭证 code
        logger.info("token为：" + requestUrl);
       /* String res = restTemplate.getForObject(requestUrl, String.class);
        JSONObject jsonObject = JSON.parseObject(res);
        String openid=jsonObject.getString("openid");
        String session_key=jsonObject.getString("session_key");
        if (null == jsonObject || StringUtils.isEmpty(openid)) {
            return   GenericResponse.response(ServiceError.LOGIN_INFO_ERROR);
        }*/

        Date nowTime = new Date();
     /* Userpo userVo=apiUserService.queryByopenId(openid);
        if (userVo == null){
            userVo=new Userpo();
            userVo.setUsername(Base64.encode(loginInfo.getNickName()));
            userVo.setPassword(openid);
            userVo.setRegister_time(nowTime);
            userVo.setRegister_ip();
            userVo.setLast_login_ip(userVo.getRegister_ip());
            userVo.setLast_login_time(userVo.getRegister_time());
            userVo.setWeixin_openid(openid);
            userVo.setAvatar(loginInfo.getAvatarUrl());
            userVo.setGender(loginInfo.getGender()); // //性别 0：未知、1：男、2：女
            userVo.setNickname(Base64.encode(loginInfo.getNickName()));
        }*/



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
