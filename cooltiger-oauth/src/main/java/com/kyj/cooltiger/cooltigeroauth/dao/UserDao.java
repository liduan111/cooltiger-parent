
package com.kyj.cooltiger.cooltigeroauth.dao;

import com.kyj.cooltiger.cooltigeroauth.entity.Userpo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/7/27 11:13
 */

@Mapper
public interface UserDao {

    Userpo getphone(String phone);

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
     * 修改用户登陆时间
     * @param userpo
     * @return
     */
    int updatelogintime(Userpo userpo);


}

