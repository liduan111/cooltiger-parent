
package com.cool.oauth.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.cool.oauth.entity.Userpo;
import com.cool.oauth.service.WeChatService;
import com.cool.oauth.utils.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/7/27 15:55
 */

@Service
@Slf4j
public class WeChatServiceImpl implements WeChatService {


    @Value("${weChat.appId}")
    private  String appid;
    @Value("${weChat.secret}")
    private  String secret;
    @Autowired
    private RedisUtil redisUtil;


/**
     *
     * @param code
     * @return
     * @throws Exception
     */

    @Override
    public GenericResponse wxLogin(String code) throws Exception {

        JSONObject  jsonObject=JSONObject.parseObject(jcode2login(code));
        Assert.notNull(jsonObject,"code无效");
        Assert.isTrue(0==jsonObject.getInteger("errcode"),jsonObject.getString("errmsg"));

        Userpo userpo=new Userpo();
        userpo.setUserId(1L);
        Set authset=new HashSet();
        authset.add(new SimpleGrantedAuthority("test:add"));
        authset.add(new SimpleGrantedAuthority("test:list"));
        authset.add(new SimpleGrantedAuthority("ddd:list"));
        userpo.setAuthorities(authset);
        HashMap<String,Object> map=new HashMap<>();
        map.put("id",userpo.getUserId().toString());
        map.put("authorities",authset);
        String token = JwtTokenUtil.generateToken(userpo);
        redisUtil.hset(token,map);
        return GenericResponse.response(ServiceError.NORMAL,token);
    }
/**
     * 登录凭证校验
     * @param code
     * @return
     * @throws Exception
     */

    private  String jcode2login(String code)throws Exception{
        String sessionInfo = Jcode2SessionUtil.jscode2session(appid,secret,code,"authorization_code");//登录grantType固定
        log.info(sessionInfo);
        return sessionInfo;
    }
}
