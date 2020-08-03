
package com.kyj.cooltiger.cooltigeroauth.controller;
import com.kyj.cooltiger.cooltigercommon.utils.GenericResponse;
import com.kyj.cooltiger.cooltigercommon.utils.LoginInfo;
import com.kyj.cooltiger.cooltigerfeign.oauth.client.vo.UserVo;
import com.kyj.cooltiger.cooltigeroauth.service.ApiUserService;
import com.kyj.cooltiger.cooltigeroauth.service.WeChatService;
import com.kyj.cooltiger.cooltigeroauth.service.impl.TokenService;

import com.kyj.cooltiger.cooltigerfeign.oauth.client.OauthClient;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.kyj.cooltiger.cooltigercommon.enums.ServiceError;
import com.kyj.cooltiger.cooltigercommon.utils.*;
import com.kyj.cooltiger.cooltigeroauth.annotation.UserConstantInterface;
import com.kyj.cooltiger.cooltigeroauth.entity.Userpo;
import com.kyj.cooltiger.cooltigeroauth.utils.ApiBaseAction;
import com.kyj.cooltiger.cooltigeroauth.utils.MapUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/7/23 16:58
 */
@Api(tags = "API登录授权接口")
@RestController
@RequestMapping("/api/auth")
public class OauthController extends ApiBaseAction implements OauthClient {

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
    @ApiOperation(value = "登录")
    @RequestMapping("/login")
    //@PreAuthorize("hasAuthority('ddd:list')")
    public Object wxlogin(@RequestBody LoginInfo loginInfo, HttpServletRequest request) {

        // 配置请求参数
        Map<String, String> param = new HashMap<>();
        param.put("appid", UserConstantInterface.WX_LOGIN_APPID);
        param.put("secret", UserConstantInterface.WX_LOGIN_SECRET);
        param.put("js_code",loginInfo.getCode());
        param.put("grant_type", UserConstantInterface.WX_LOGIN_GRANT_TYPE);
        // 发送请求
        String wxResult = HttpUtil.doGet(UserConstantInterface.WX_LOGIN_URL, param);
        JSONObject jsonObject = JSON.parseObject(wxResult);
        logger.info("jsonObject-------"+jsonObject);
        String openid=jsonObject.getString("openid");
        logger.info("openid-------"+openid);
        String session_key=jsonObject.getString("session_key");
        //判断openid是否为空
        if (null == jsonObject || StringUtils.isEmpty(openid)) {
            return toResponsFail("登录失败");
        }

        Date nowTime = new Date();
      Userpo userVo=apiUserService.queryByopenId(openid);
        if (userVo == null){
            userVo=new Userpo();
            userVo.setUserCode(CharUtil.getID());
            userVo.setUsername(Base64.encode(loginInfo.getNickName()));
            userVo.setPassword(openid);
            userVo.setRegister_time(nowTime);
            userVo.setRegister_ip(this.getClientIp());
            userVo.setLast_login_ip(userVo.getRegister_ip());
            userVo.setLast_login_time(userVo.getRegister_time());
            userVo.setWeixin_openid(openid);
            userVo.setAvatar(loginInfo.getAvatarUrl());
            userVo.setGender(loginInfo.getGender()); // //性别 0：未知、1：男、2：女
            userVo.setNickname(Base64.encode(loginInfo.getNickName()));
            userVo.setIsReal("0");
            userVo.setRegisterchannel("1");
            //添加数据库
            boolean flag=apiUserService.save(userVo);
            if (flag==true) {
                Map<String, Object> map = tokenService.creatToken(userVo.getUserId());
                String token = MapUtils.getString(map, "token");
                if (StringUtils.isEmpty(token)) {
                    return toResponsFail("登录失败");
                }
                Map<String, Object> result = new HashMap<>();
                result.put("userVo", userVo);
                result.put("session_key", session_key);
                result.put("open_id", openid);
                return toResponsSuccess(result);
            }else {
                return toResponsFail("登录失败");
            }
        }else {
            Userpo user=new Userpo();
            user.setLast_login_ip(userVo.getRegister_ip());
            user.setLast_login_time(DateUtils.getDates());
            user.setUserCode(userVo.getUserCode());
            boolean flag=apiUserService.updatelogintime(user);
            if (flag==true) {
                Map<String, Object> result = new HashMap<>();
                result.put("session_key", session_key);
                result.put("open_id", openid);
                return toResponsSuccess(result);
            }else {
                return toResponsFail("登录失败");
            }
        }

    }

    @GetMapping("/hello")
    public GenericResponse hello(){
        return GenericResponse.response(ServiceError.NORMAL,"hello security");
    }

    /**
     * 根据用户查讯
     * @param userCode
     * @return
     */
    @ApiOperation("个人资料信息")
    @RequestMapping(value = "/info",method = RequestMethod.GET)
    public Object getuserInfo(@RequestBody String  userCode){
        JSONObject jsonObject = JSON.parseObject(userCode);
        Long  code=Long.parseLong(jsonObject.getString("userCode"));
        System.out.println("userCode = [" + userCode + "]");
        if (code!=null||code!=0) {
            Userpo user = apiUserService.queryByuserCode(code);
            return toResponsSuccess(user);
        }else {
            return  toResponsFail("id为空");
        }
    }

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    @ApiOperation("个人资料信息")
    @RequestMapping(value = "/updateuserinfo",method = RequestMethod.POST)
    public Object updateuserInfo(@RequestBody UserVo user){
        if(user==null|| user.equals("")){
            return toResponsFail("请填写资料信息");
        }
        if(user.getNickname()==null || user.getNickname().equals("")){
            return  toResponsFail("昵称不能为空");
        }
        if (user.getAge()==null||user.getAge()==0){
            return  toResponsFail("年龄不能为空");
        }
        if (user.getMobile()==null||user.getMobile().equals("") ){
            return  toResponsFail("手机号不能为空");
        }
        if (user.getMobile().length() != 11) {
            return toResponsFail("手机号应为十一位");
        }
        if(!CharUtil.regexphone(user.getMobile())){
            return toResponsFail("手机号格式不正确");
        }
        if (user.getAvatar()==null|| user.getAvatar().equals("")){
            return  toResponsFail("头像不能为空");
        }
        if (user.getRealName()==null|| user.getRealName().equals("")){
            return  toResponsFail("真实姓名不能为空");
        }
        Userpo userVo=new Userpo();
        userVo.setMobile(user.getMobile());
        userVo.setUserCode(user.getUserCode());
        userVo.setUsername(user.getNickname());
        userVo.setAvatar(user.getAvatar());
        userVo.setAge(user.getAge());
        userVo.setGender(user.getGender());
        userVo.setNickname(user.getNickname());
        userVo.setRealName(user.getRealName());
        boolean flag=  apiUserService.updateUserInfo(userVo);
        if(flag==true){
            return  toResponsMsgSuccess("资料修改成功");
        }
        return toResponsFail("请检查资料信息");
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
