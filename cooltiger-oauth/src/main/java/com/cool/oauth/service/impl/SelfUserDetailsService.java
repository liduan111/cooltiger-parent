
package com.cool.oauth.service.impl;

import com.cool.oauth.entity.Userpo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


/**
 * @author guoxq
 * @version 1.0
 * @date 2020/7/27 15:34
 */

@Component
@Slf4j
@Service
public class SelfUserDetailsService implements UserDetailsService {

    //@Autowired
    //private Userdao userMapper;


/**
     * 若使用security表单鉴权则需实现该方法，通过username获取用户信息（密码、权限等等）
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //通过username查询用户
        //根据自己的业务获取用户信息
        //SelfUserDetails user = userMapper.getUser(username);
        //模拟从数据库获取到用户信息

        Userpo userpo  =new Userpo();
        if (userpo==null){
            //仍需要细化处理
            throw new UsernameNotFoundException("该用户不存在");
        }
        Set authoritiesSet = new HashSet();
        // 模拟从数据库中获取用户权限
        authoritiesSet.add(new SimpleGrantedAuthority("test:list"));
        authoritiesSet.add(new SimpleGrantedAuthority("test:add"));
        userpo.setAuthorities(authoritiesSet);

        log.info("用户{}验证通过",username);

        return null;
    }
}
