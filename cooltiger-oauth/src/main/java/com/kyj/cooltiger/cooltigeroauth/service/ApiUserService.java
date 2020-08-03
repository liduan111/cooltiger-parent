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

    boolean save(Userpo userpo);

    boolean updatelogintime(Userpo user);

}
