package com.kyj.cooltiger.oauth.interceptor;

import com.kyj.cooltiger.oauth.annotation.IgnoreAuth;
import com.kyj.cooltiger.oauth.service.ApiUserService;
import com.kyj.cooltiger.oauth.utils.ApiRRException;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/7/30 15:59
 */
@Component
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private ApiUserService userService;

    public static final String LOGIN_USER_KEY = "LOGIN_USER_KEY";
    public static final String LOGIN_TOKEN_KEY = "Cool-Token";


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //支持跨域请求
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));



        IgnoreAuth annotation;
        if (handler instanceof HandlerMethod) {
            annotation = ((HandlerMethod) handler).getMethodAnnotation(IgnoreAuth.class);
        } else {
            return true;
        }

        //从header中获取token
        String openId = request.getHeader(LOGIN_TOKEN_KEY);
        //如果header中不存在token，则从参数中获取token
        if (StringUtils.isBlank(openId)) {
            openId = request.getParameter(LOGIN_TOKEN_KEY);
        }

        //token为空
        if (StringUtils.isBlank(openId)) {
            // 如果有@IgnoreAuth注解，则不验证openId
            if (annotation != null) {
                return true;
            } else {
                throw new ApiRRException("请先登录", 401);
            }
        }
        if(request.getAttribute(LOGIN_USER_KEY)==null){

               /* Userpo userVo = userService.queryByOpenId(openId);
                if(userVo==null&&annotation == null) {
                    throw new ApiRRException("请先登录", 401);
                }
                //设置userId到request里，后续根据userId，获取用户信息
                request.setAttribute(LOGIN_USER_KEY, userVo);*/

        }
        return true;
    }
}
