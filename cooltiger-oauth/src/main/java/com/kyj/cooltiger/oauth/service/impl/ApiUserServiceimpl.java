package com.kyj.cooltiger.oauth.service.impl;

import com.kyj.cooltiger.oauth.dao.UserDao;
import com.kyj.cooltiger.oauth.entity.Userpo;
import com.kyj.cooltiger.oauth.service.ApiUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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
    public boolean updateUserInfo(Userpo user) {
        if(user!=null||!user.equals("")) {
            int i = userDao.updateUserInfo(user);
            if (i > 0) {
                return true;
            }else {
                return false;
            }
        }
        return false;
    }

    /**
     * 查询总条数
     * @param map 参数
     * @return
     */
    @Override
    public int queryTotal(Map<String, Object> map) {
        return userDao.queryTotals(map);
    }

    /**
     * 查询会员列表
     * @param map 参数
     * @return
     */
    @Override
    public List<Userpo> querylist(Map<String, Object> map) {
        List<Userpo>  userpoList=userDao.queryuserList(map);
        return userpoList;
    }

    @Override
    public boolean update(Userpo user) {
        if(user!=null||!user.equals("")) {
            int i = userDao.update(user);
            if (i > 0) {
                return true;
            }else {
                return false;
            }
        }
        return false;
    }

    @Override
    public Userpo queryByuserCode(Long userCode) {
        return userDao.queryByuserCode(userCode);
    }

    @Override
    public boolean updatelogintime(Userpo user) {
        int  i=userDao.updatelogintime(user);
        if (i>0){
            return  true;
        }
        return false;
    }

    /**
     *根据openid查询
     * @param openId
     * @return
     */
    @Override
    public Userpo queryByopenId(String openId) {
        return userDao.queryByOpenId(openId);
    }

    /**
     * 添加用户
     * @param userVo
     * @return
     */
   @Override
    public boolean save(Userpo userVo) {
        int i=userDao.save(userVo);
        if(i>0){
            return true;
        }
        return false;
    }

}
