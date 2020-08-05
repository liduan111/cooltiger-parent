package com.kyj.cooltiger.cooltigerfeign.oauth.client;

import com.kyj.cooltiger.cooltigercommon.utils.LoginInfo;
import com.kyj.cooltiger.cooltigerfeign.oauth.client.vo.UserVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/7/29 17:37
 */
@FeignClient(name ="Oauth-Service" )
public interface OauthClient {

    /**
     *  登录
     * @param loginInfo
     * @param request
     * @return
     */
   @RequestMapping(value = "/login",method = {RequestMethod.GET})
    public Object wxlogin(@RequestBody LoginInfo loginInfo, HttpServletRequest request);

    /**
     * 根据用户usercode查询用户信息
     * @param userCode
     * @return
     */
    @RequestMapping(value = "/info",method = RequestMethod.GET)
    public Object getuserInfo(@RequestBody String userCode);

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    @RequestMapping(value = "/updateuserinfo",method = RequestMethod.POST)
    public Object updateuserInfo(@RequestBody UserVo user);

    /**
     * 发送短信
     * @param parm
     * @return
     */
    @RequestMapping(value = "/smscode",method = RequestMethod.POST)
    public Object sendSms(@RequestBody Map<String,String> parm);

    /**
     * 绑定手机号
     * @param map
     * @return
     */
    @RequestMapping(value = "/bindmobile",method = RequestMethod.POST)
    public  Object  bindMobile(@RequestBody Map<String,String> map);

     /**
      * 查询会员列表
      * @param map
      * @return
      */
     @RequestMapping(value = "/memberlist",method = RequestMethod.GET)
     public  Object  memberlist(@RequestBody Map<String,Object> map);

     /**
      * 根据用户id查询收货地址
      * @param code
      * @return
      */
     @RequestMapping(value = "/queryaddress",method = RequestMethod.GET)
     public Object queryaddress(@RequestBody String code);

}
