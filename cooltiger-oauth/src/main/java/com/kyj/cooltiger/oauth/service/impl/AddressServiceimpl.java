package com.kyj.cooltiger.oauth.service.impl;

import com.kyj.cooltiger.oauth.dao.AddressDao;
import com.kyj.cooltiger.oauth.entity.AddressVo;
import com.kyj.cooltiger.oauth.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/8/4 18:03
 */
@Service
public class AddressServiceimpl implements AddressService {

    @Autowired
    private AddressDao addressDao;

    /**
     * 收货地址列表查询
     * @return
     */
    @Override
    public List<AddressVo> addresslist() {
        return addressDao.addresslist();
    }

    /**
     * 修改
     * @param map
     * @return
     */
    @Override
    public boolean addressupdate(Map<String, Object> map) {

        Long userCode=Long.parseLong(map.get("userCode").toString());
        String userName=map.get("userName").toString();
        String mobile=map.get("mobile").toString();
        String provinceName=map.get("provinceName").toString();
        String cityName=map.get("cityName").toString();
        String countryName=map.get("countryName").toString();
        String addressDetail=map.get("addressDetail").toString();
        Integer isDefaul=Integer.valueOf(map.get("isDefaul").toString());
        AddressVo addressVo=new AddressVo();
        addressVo.setUserCode(userCode);
        addressVo.setUserName(userName);
        addressVo.setMobile(mobile);
        addressVo.setProvinceName(provinceName);
        addressVo.setCityName(cityName);
        addressVo.setCountryName(countryName);
        addressVo.setAddressdetail(addressDetail);
        addressVo.setIsdefaul(isDefaul);
        addressVo.setUpdateTime(new Date());
        if (addressVo!=null){
            int i=addressDao.addressupdate(addressVo);
            if(i>0){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean addresssave(Map<String, Object> map) {

        Long userCode=Long.parseLong(map.get("userCode").toString());
        String userName=map.get("userName").toString();
        String mobile=map.get("mobile").toString();
        String provinceName=map.get("provinceName").toString();
        String cityName=map.get("cityName").toString();
        String countryName=map.get("countryName").toString();
        String addressDetail=map.get("addressDetail").toString();
        Integer isDefaul=Integer.valueOf(map.get("isDefaul").toString());
        AddressVo addressVo=new AddressVo();
        addressVo.setUserCode(userCode);
        addressVo.setUserName(userName);
        addressVo.setMobile(mobile);
        addressVo.setProvinceName(provinceName);
        addressVo.setCityName(cityName);
        addressVo.setCountryName(countryName);
        addressVo.setAddressdetail(addressDetail);
        addressVo.setIsdefaul(isDefaul);
        addressVo.setCreateTime(new Date());
        if (addressVo!=null){
            int i=addressDao.addresssave(addressVo);
            if(i>0){
                return true;
            }
        }
        return false;
    }

    @Override
    public AddressVo queryByuserCode(Long userCode) {
        return addressDao.queryByuserCode(userCode);
    }
}
