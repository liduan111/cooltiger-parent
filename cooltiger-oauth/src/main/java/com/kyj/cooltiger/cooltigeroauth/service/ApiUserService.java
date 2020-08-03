package com.kyj.cooltiger.cooltigeroauth.service;

import com.kyj.cooltiger.cooltigeroauth.entity.Userpo;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/7/29 14:55
 */
public interface ApiUserService {
    /**
     * 根据openid查询
     * @param openId
     * @return
     */
    Userpo queryByopenId(String openId);

    /**
     * 添加用户
     * @param userpo
     * @return
     */
    boolean save(Userpo userpo);

    /**
     * 修改用户登陆时间
     * @param user
     * @return
     */
    boolean updatelogintime(Userpo user);

    /**
     * 根据usercode查询用户信息
     * @param userCode
     * @return
     */
    Userpo  queryByuserCode(Long userCode);

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    boolean updateUserInfo(Userpo user);

}
