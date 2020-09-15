package com.kyj.cooltiger.customer.mapper;

import com.kyj.cooltiger.customer.entity.AdminInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author liduan
 * Description: 管理员信息mapper
 * date: 2020/9/14 14:57
 */
@Mapper
public interface AdminInfoMapper {

    /**
     * 根据用户名查询管理员信息
     *
     * @param username
     * @return
     */
    public AdminInfo getAdminInfoByUsername(@Param("username") String username);

    /**
     * 根据用户名/手机号、邮箱查询管理员信息
     *
     * @param username
     * @return
     */
    public AdminInfo getAdminInfoByUsername$Phone$Email(@Param("username") String username);

    /**
     * 插入管理员信息
     *
     * @param adminInfo
     */
    public int insertAdminInfo(@Param("adminInfo") AdminInfo adminInfo);
}
