
package com.kyj.cooltiger.cooltigeroauth.dao;

import com.kyj.cooltiger.cooltigeroauth.entity.Userpo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/7/27 11:13
 */

@Mapper
public interface UserDao {
    Userpo getphone(String phone);

}

