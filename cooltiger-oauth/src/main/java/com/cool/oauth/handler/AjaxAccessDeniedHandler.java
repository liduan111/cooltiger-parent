package com.cool.oauth.handler;

import com.alibaba.fastjson.JSON;
import com.cool.common.utils.GenericResponse;
import com.cool.common.utils.enums.ServiceError;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @author guoxq
 * @version 1.0
 * @date 2020/7/27 14:00
 * destription  无权访问
 */

@Component
public class AjaxAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {
         response.setCharacterEncoding("utf-8");
         response.getWriter().write(JSON.toJSONString(GenericResponse.response(ServiceError.GLOBAL_ERR_NO_AUTHORITY)));
    }
}
