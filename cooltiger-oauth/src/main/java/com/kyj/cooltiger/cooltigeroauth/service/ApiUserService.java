package com.kyj.cooltiger.cooltigeroauth.service;

import com.kyj.cooltiger.cooltigeroauth.entity.Userpo;

import java.util.List;
import java.util.Map;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/7/29 14:55
 */
public interface ApiUserService {

    /**
     * 分页查询
     *
     * @param map 参数
     * @return list
     */
    List<Userpo> querylist(Map<String, Object> map);

    /**
     * 分页统计总数
     *
     * @param map 参数
     * @return 总数
     */
    int queryTotal(Map<String, Object> map);

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
     * 修改用户信息
     * @param user
     * @return
     */
    boolean update(Userpo user);

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
