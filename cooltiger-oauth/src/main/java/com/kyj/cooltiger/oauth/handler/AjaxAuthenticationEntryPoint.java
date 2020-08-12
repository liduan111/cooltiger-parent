package com.kyj.cooltiger.oauth.handler;

import com.alibaba.fastjson.JSON;
import com.kyj.cooltiger.common.enums.ServiceError;
import com.kyj.cooltiger.common.utils.GenericResponse;
import org.springframework.security.core.AuthenticationException;

import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/7/27 14:08
 * 用户未登录时返回给前端的数据
 */

@Component
public class AjaxAuthenticationEntryPoint implements  AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        response.getWriter().write(JSON.toJSONString(GenericResponse.response(ServiceError.GLOBAL_ERR_NO_SIGN_IN)));
    }
}
