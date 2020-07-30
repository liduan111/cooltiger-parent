package com.cool.oauth.handler;

import com.alibaba.fastjson.JSON;
import com.cool.common.utils.GenericResponse;
import com.cool.common.utils.enums.ServiceError;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * @author guoxq
 * @version 1.0
 * @date 2020/7/27 14:17
 * 用户登陆失败时返回给前端的数据
 */

@Component
public class AjaxAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(JSON.toJSONString(GenericResponse.response(ServiceError.GLOBAL_ERR_NO_CODE)));
    }
}
