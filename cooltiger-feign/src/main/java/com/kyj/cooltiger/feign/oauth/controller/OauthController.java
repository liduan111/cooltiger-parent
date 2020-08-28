package com.kyj.cooltiger.feign.oauth.controller;

import com.kyj.cooltiger.common.utils.LoginInfo;
import com.kyj.cooltiger.feign.oauth.client.OauthClient;
import com.kyj.cooltiger.feign.oauth.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author liduan
 * Description:
 * date: 2020/8/24 14:34
 */
@RestController
@RequestMapping("/oauth")
public class OauthController {

    @Autowired
    private OauthClient oauthClient;

    /**
     *  登录
     * @param loginInfo
     * @param
     * @return
     */
    @RequestMapping(value = "/login",method = {RequestMethod.GET})
    public Object wxlogin(@RequestBody LoginInfo loginInfo){
        return oauthClient.wxlogin(loginInfo);
    }

    /**
     * 根据用户usercode查询用户信息
     * @param userCode
     * @return
     */
    @RequestMapping(value = "/info",method = RequestMethod.GET)
    public Object getuserInfo(@RequestBody String userCode){
        return oauthClient.getuserInfo(userCode);
    }

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    @RequestMapping(value = "/updateuserinfo",method = RequestMethod.POST)
    public Object updateuserInfo(@RequestBody UserVo user){
        return oauthClient.updateuserInfo(user);
    }

    /**
     * 发送短信
     * @param parm
     * @return
     */
    @RequestMapping(value = "/smscode",method = RequestMethod.POST)
    public Object sendSms(@RequestBody Map<String,String> parm){
        return oauthClient.sendSms(parm);
    }

    /**
     * 绑定手机号
     * @param map
     * @return
     */
    @RequestMapping(value = "/bindmobile",method = RequestMethod.POST)
    public  Object  bindMobile(@RequestBody Map<String,String> map){
        return oauthClient.bindMobile(map);
    }
}
