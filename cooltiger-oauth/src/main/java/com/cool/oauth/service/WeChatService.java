package com.cool.oauth.service;


import com.cool.common.utils.GenericResponse;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/7/27 15:54
 * 微信小程序业务接口
 */
public interface WeChatService {
    /**
     * 小程序登录
     * @param code
     * @return
     */
    GenericResponse wxLogin(String code)throws Exception;
}
