package com.kyj.cooltiger.cooltigeroauth.service.impl;

import com.kyj.cooltiger.cooltigeroauth.dao.UserDao;
import com.kyj.cooltiger.cooltigeroauth.entity.Userpo;
import com.kyj.cooltiger.cooltigeroauth.service.ApiUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/7/29 14:56
 */
@Service
public class ApiUserServiceimpl implements ApiUserService {

    @Autowired
    private UserDao userDao;

    @Override
    public boolean updatelogintime(Userpo user) {
        int  i=userDao.updatelogintime(user);
        if (i>0){
            return  true;
        }
        return false;
    }

    /**
     *
     * @param openId
     * @return
     */
    @Override
    public Userpo queryByopenId(String openId) {
        return userDao.queryByOpenId(openId);
    }
   @Override
    public boolean save(Userpo userVo) {
        int i=userDao.save(userVo);
        if(i>0){
            return true;
        }
        return false;
    }
}
