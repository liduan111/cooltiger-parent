package com.kyj.cooltiger.cooltigeroauth.service.impl;

import com.kyj.cooltiger.cooltigeroauth.dao.AddressDao;
import com.kyj.cooltiger.cooltigeroauth.entity.AddressVo;
import com.kyj.cooltiger.cooltigeroauth.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/8/4 18:03
 */
@Service
public class AddressServiceimpl implements AddressService {
    @Autowired
    private AddressDao addressDao;
    @Override
    public AddressVo queryByuserCode(Long userCode) {
        return addressDao.queryByuserCode(userCode);
    }
}
