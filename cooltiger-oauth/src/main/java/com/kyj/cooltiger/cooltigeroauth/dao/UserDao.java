
package com.kyj.cooltiger.cooltigeroauth.dao;

import com.kyj.cooltiger.cooltigeroauth.entity.Userpo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/7/27 11:13
 */

@Mapper
public interface UserDao {

    /**
     * 查询总条数
     * @param map
     * @return
     */
    int queryTotals(Map<String, Object> map);

    /**
     * 查询列表
     * @param map
     * @return
     */
    List<Userpo> queryuserList(Map<String, Object> map);
    /**
     * 根据openId查询
     * @param openId
     * @return
     */
    Userpo queryByOpenId(@Param("openId") String openId);

    /**
     * 添加用户
     * @param userpo
     * @return
     */
    int save(Userpo userpo);

    /**
     * 修改用户
     * @param userpo
     * @return
     */
    int update(Userpo userpo);
    /**
     * 修改用户登陆时间
     * @param userpo
     * @return
     */
    int updatelogintime(Userpo userpo);

    /**
     * 根据usercode查询用户信息
     * @param userCode
     * @return
     */
    Userpo  queryByuserCode(@Param("userCode") Long userCode);

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    int updateUserInfo(Userpo user);

    /**
     * 根据手机号查询
     * @param mobile
     * @return
     */
    Userpo getphone(@Param("mobile")String mobile);
}

