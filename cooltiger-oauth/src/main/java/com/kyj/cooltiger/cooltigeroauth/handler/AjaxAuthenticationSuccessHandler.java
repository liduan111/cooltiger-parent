
package com.kyj.cooltiger.cooltigeroauth.handler;

import com.alibaba.fastjson.JSON;
import com.kyj.cooltiger.cooltigercommon.enums.ServiceError;
import com.kyj.cooltiger.cooltigercommon.utils.GenericResponse;
import com.kyj.cooltiger.cooltigeroauth.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @author guoxq
 * @version 1.0
 * @date 2020/7/27 15:17
 * 登陆成功是返回给前端的数据
 */

@Component
@Slf4j
public class AjaxAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        httpServletResponse.getWriter().write(JSON.toJSONString(GenericResponse.response(ServiceError.NORMAL)));
    }
}
