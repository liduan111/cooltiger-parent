package com.kyj.cooltiger.customer.service.impl;

import com.kyj.cooltiger.common.constant.DELETED;
import com.kyj.cooltiger.common.excep.MyException;
import com.kyj.cooltiger.common.utils.TokenUtils;
import com.kyj.cooltiger.customer.entity.AdminInfo;
import com.kyj.cooltiger.customer.mapper.AdminInfoMapper;
import com.kyj.cooltiger.customer.service.AdminInfoService;
import com.kyj.cooltiger.feign.customer.vo.AdminInfoReqVo;
import com.kyj.cooltiger.feign.customer.vo.AdminLoginReqVo;
import com.kyj.cooltiger.feign.customer.vo.PasswordReqVo;
import com.kyj.cooltiger.feign.vo.AdminInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liduan
 * Description: 管理员信息service实现类
 * date: 2020/9/14 14:55
 */
@Service
public class AdminInfoServiceImpl implements AdminInfoService {

    @Autowired
    private AdminInfoMapper adminInfoMapper;

    /**
     * 添加管理员
     *
     * @param adminInfoReqVo 管理员信息
     */
    @Override
    public void addAdminInfo(AdminInfoReqVo adminInfoReqVo) {
        AdminInfo adminInfo = adminInfoMapper.getAdminInfoByUsername(adminInfoReqVo.getUsername());
        if (adminInfo != null) {
            throw new MyException("USERNAME_IS_EXIST", "用户名已存在");
        }
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String password = bCryptPasswordEncoder.encode(adminInfoReqVo.getPassword());
        adminInfo = new AdminInfo();
        adminInfo.setUsername(adminInfoReqVo.getUsername());
        adminInfo.setPassword(password);
        adminInfo.setNickname(adminInfoReqVo.getNickname());
        adminInfo.setAvatar(adminInfoReqVo.getAvatar());
        adminInfo.setPhone(adminInfoReqVo.getPhone());
        adminInfo.setEmail(adminInfoReqVo.getEmail());
        adminInfo.setSex(adminInfoReqVo.getSex());
        adminInfo.setStoreId(adminInfoReqVo.getStoreId());
        adminInfo.setStatus(DELETED.YES);
        adminInfoMapper.insertAdminInfo(adminInfo);
    }

    /**
     * 管理员登录
     *
     * @param adminLoginReqVo 登录信息
     * @return
     */
    @Override
    public Map<String, Object> adminLogin(AdminLoginReqVo adminLoginReqVo) {
        AdminInfo adminInfo = adminInfoMapper.getAdminInfoByUsername$Phone$Email(adminLoginReqVo.getUsername());
        if (adminInfo == null) {
            throw new MyException("USERNAME_NOT_EXIST", "用户名不存在");
        }
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        boolean matches = bCryptPasswordEncoder.matches(adminLoginReqVo.getPassword(), adminInfo.getPassword());
        if (!matches) {
            throw new MyException("PASSWORD_ERROR", "密码错误！");
        }
        //根据用户类型、用户ID、用户名生成token
        String token = TokenUtils.storageTokenByUserId$Username(1, adminInfo.getUserId(), adminInfo.getUsername());
        //用户信息
        AdminInfoVo adminInfoVo = new AdminInfoVo();
        adminInfoVo.setUserId(adminInfo.getUserId());
        adminInfoVo.setUsername(adminInfo.getUsername());
        adminInfoVo.setAvatar(adminInfo.getAvatar());
        adminInfoVo.setNickname(adminInfo.getNickname());
        adminInfoVo.setSex(adminInfo.getSex());
        adminInfoVo.setPhone(adminInfo.getPhone());
        adminInfoVo.setEmail(adminInfo.getEmail());
        adminInfoVo.setStoreId(adminInfo.getStoreId());
        Map<String, Object> res = new HashMap<>();
        res.put("token", token);
        res.put("data", adminInfoVo);
        return res;
    }

    /**
     * 修改密码
     *
     * @param userId        用户ID
     * @param passwordReqVo 密码信息
     */
    @Override
    public void changePassword(Integer userId, PasswordReqVo passwordReqVo) {
        AdminInfo adminInfo = adminInfoMapper.getAdminInfoByUserId(userId);
        if (adminInfo == null) {
            throw new MyException("USERNAME_NOT_EXIST", "用户名不存在");
        }
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        boolean matches = bCryptPasswordEncoder.matches(passwordReqVo.getOldPassword(), adminInfo.getPassword());
        if (!matches) {
            throw new MyException("PASSWORD_ERROR", "密码错误！");
        }
        String password = bCryptPasswordEncoder.encode(passwordReqVo.getNewPassword());
        adminInfo.setPassword(password);
        adminInfoMapper.updateAdminInfo(adminInfo);
    }
}
