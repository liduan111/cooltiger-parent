package com.kyj.cooltiger.customer.service.impl;

import com.kyj.cooltiger.common.constant.DELETED;
import com.kyj.cooltiger.common.excep.MyException;
import com.kyj.cooltiger.customer.entity.AdminInfo;
import com.kyj.cooltiger.customer.mapper.AdminInfoMapper;
import com.kyj.cooltiger.customer.service.AdminInfoService;
import com.kyj.cooltiger.feign.customer.vo.AdminInfoReqVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

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
        AdminInfo adminInfo = adminInfoMapper.getAdminInfo(adminInfoReqVo.getUsername());
        if(adminInfo != null){
            throw new MyException("USERNAME_IS_EXIST","用户名已存在");
        }
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode = bCryptPasswordEncoder.encode(adminInfoReqVo.getPassword());
        adminInfo = new AdminInfo();
        adminInfo.setUsername(adminInfoReqVo.getUsername());
        adminInfo.setPassword(encode);
        adminInfo.setNickname(adminInfoReqVo.getNickname());
        adminInfo.setAvatar(adminInfoReqVo.getAvatar());
        adminInfo.setPhone(adminInfoReqVo.getPhone());
        adminInfo.setEmail(adminInfoReqVo.getEmail());
        adminInfo.setSex(adminInfoReqVo.getSex());
        adminInfo.setStoreId(adminInfoReqVo.getStoreId());
        adminInfo.setStatus(DELETED.YES);
        adminInfoMapper.insertAdminInfo(adminInfo);
    }
}
