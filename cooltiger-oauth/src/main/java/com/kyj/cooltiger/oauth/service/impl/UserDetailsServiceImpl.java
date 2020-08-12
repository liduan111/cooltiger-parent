
package com.kyj.cooltiger.oauth.service.impl;

import com.kyj.cooltiger.oauth.dao.UserDao;
import com.kyj.cooltiger.oauth.entity.Userpo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/7/27 11:09
 */

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserDao userDao;
    @Override
    public UserDetails loadUserByUsername(String json) throws UsernameNotFoundException {

        Userpo  userpo=userDao.getphone(json);
        return null;
    }
}
