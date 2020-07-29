package com.cool.oauth.handler;

import com.alibaba.fastjson.JSON;
import com.cool.oauth.utils.GenericResponse;
import com.cool.oauth.utils.RedisUtil;
import com.cool.oauth.utils.ServiceError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @author guoxq
 * @version 1.0
 * @date 2020/7/27 15:10
 * 登出成功是返回给前端数据
 */

@Component
@Slf4j
public class AjaxLogoutSuccessHandler implements LogoutSuccessHandler {

//    @Autowired
//    private RedisUtil redisUtil;

    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
           //没有logout不走这里、若使用security的formLogin则自己添加业务实现（移除token等等）
         httpServletResponse.getWriter().write(JSON.toJSONString(GenericResponse.response(ServiceError.NORMAL)));
    }
}
