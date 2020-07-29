
package com.cool.oauth.dao;

import com.cool.oauth.entity.Userpo;
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

