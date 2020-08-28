package com.kyj.cooltiger.oauth.service.impl;

import com.kyj.cooltiger.oauth.dao.TokenDao;
import com.kyj.cooltiger.oauth.entity.Tokenpo;
import com.kyj.cooltiger.oauth.entity.Userpo;
import com.kyj.cooltiger.oauth.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/7/28 14:58
 */
@Service
public class TokenService {
    @Autowired
    private TokenDao tokenDao;
   /* @Autowired
    private RestTemplate restTemplate;*/

    //12小时后过期
    private final static int EXPIRE = 3600 * 12;
    //2小时后过期
    private final static int EXPIRE2 = 3600 * 2;

    public Tokenpo queryByUserId(Long userId) {
        return tokenDao.queryByUserId(userId);
    }

    public Tokenpo queryByToken(String token) {
        return tokenDao.queryByToken(token);
    }

    public void save(Tokenpo token) {
        tokenDao.save(token);
    }

    public void update(Tokenpo token) {
        tokenDao.update(token);
    }

    /**
     * 创建token
     * @param userId
     * @return
     */
    public Map<String, Object>  creatToken(Long userId,String userName){
        Userpo userpo =new Userpo();
        userpo.setUserId(userId);
        userpo.setUsername(userName);
          //生成一个token
        String token = JwtTokenUtil.createJsonWebToken(userpo);
        //当前时间
        Date now = new Date();
        //过期时间
        Date expireTime = new Date(now.getTime() + EXPIRE * 1000);
        //判断是否生成过token
        Tokenpo tokenEntity = queryByUserId(userId);
        if (tokenEntity == null) {
            tokenEntity = new Tokenpo();
            tokenEntity.setUserId(userId);
            tokenEntity.setToken(token);
            tokenEntity.setCreateTime(now);
            tokenEntity.setExpireTime(expireTime);

            //保存token
            save(tokenEntity);
        } else {
            tokenEntity.setToken(token);
            tokenEntity.setCreateTime(now);
            tokenEntity.setExpireTime(expireTime);

            //更新token
            update(tokenEntity);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("token", token);
        map.put("expire", EXPIRE);
        return  map;
    }

    public static void main(String[] args) throws ParseException {
        Date now = new Date();
        //过期时间
        Date expireTime = new Date(now.getTime() + EXPIRE * 1000);
        System.out.println("args = [" + expireTime + "]");
        System.out.println("args = [" + now + "]");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = sdf.parse("2019-10-01");
        Date date2 = sdf.parse("2019-10-17");

        System.out.println("date1 : " + sdf.format(date1));
        System.out.println("date2 : " + sdf.format(date2));

        if (date1.after(date2)) {
            System.out.println("Date1 is after Date2");
        }

        if (date1.before(date2)) {
            System.out.println("Date1 is before Date2");
        }

        if (date1.equals(date2)) {
            System.out.println("Date1 is equal Date2");
        }
    }


}
