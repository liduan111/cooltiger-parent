package com.kyj.cooltiger.feign.oauth.client;

import com.kyj.cooltiger.common.utils.LoginInfo;
import com.kyj.cooltiger.feign.oauth.vo.UserVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/7/29 17:37
 */
@FeignClient(name = "Oauth-Service")
public interface OauthClient {

    /**
     * 登录
     *
     * @param loginInfo
     * @param
     * @return
     */
    @RequestMapping(value = "/oauth/login", method = {RequestMethod.GET})
    public Object wxlogin(@RequestBody LoginInfo loginInfo);

    /**
     * 根据用户usercode查询用户信息
     *
     * @param userCode
     * @return
     */
    @RequestMapping(value = "/oauth/info", method = RequestMethod.GET)
    public Object getuserInfo(@RequestBody String userCode);

    /**
     * 修改用户信息
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/oauth/updateuserinfo", method = RequestMethod.POST)
    public Object updateuserInfo(@RequestBody UserVo user);

    /**
     * 发送短信
     *
     * @param parm
     * @return
     */
    @RequestMapping(value = "/oauth/smscode", method = RequestMethod.POST)
    public Object sendSms(@RequestBody Map<String, String> parm);

    /**
     * 绑定手机号
     *
     * @param map
     * @return
     */
    @RequestMapping(value = "/oauth/bindmobile", method = RequestMethod.POST)
    public Object bindMobile(@RequestBody Map<String, String> map);


}
