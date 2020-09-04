package com.kyj.cooltiger.oauth.service.impl;

import com.kyj.cooltiger.common.excep.MyException;
import com.kyj.cooltiger.common.utils.CharUtil;
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
     * 删除地址
     * @param map
     */
    @Override
    public void deleteaddress(Map<String, Object> map) {
      addressDao.deleteaddress(map);
    }

    /**
     * 收货地址列表查询
     * @return
     */
    @Override
    public List<AddressVo> addresslist(Map<String,Object> map) {
        return addressDao.addresslist(map);
    }

    /**
     * x修改
     * @param map
     * @param idcardzUrl
     * @param idcardfUrl
     * @return
     */
    @Override
    public boolean addressupdate(Map<String, Object> map,String idcardzUrl,String idcardfUrl) {
        Long Id=Long.parseLong(map.get("Id").toString());
        Long userCode=Long.parseLong(map.get("userCode").toString());
        String userName=map.get("userName").toString();
        String mobile=map.get("mobile").toString();
        String provinceName=map.get("provinceName").toString();
        String cityName=map.get("cityName").toString();
        String countryName=map.get("countryName").toString();
        String addressDetail=map.get("addressDetail").toString();
        Integer isDefaul=Integer.valueOf(map.get("isDefaul").toString());
        if (!CharUtil.regexphone(mobile)){
            new MyException("error mobile","请确认手机号");
        }
        AddressVo addressVo=new AddressVo();
        addressVo.setId(Id);
        addressVo.setUserCode(userCode);
        addressVo.setUserName(userName);
        addressVo.setMobile(mobile);
        addressVo.setProvinceName(provinceName);
        addressVo.setCityName(cityName);
        addressVo.setCountryName(countryName);
        addressVo.setAddressdetail(addressDetail);
        addressVo.setIsdefaul(isDefaul);
        addressVo.setIdcardzUrl(idcardzUrl);
        addressVo.setIdcardfUrl(idcardfUrl);
        addressVo.setUpdateTime(new Date());
        if (addressVo!=null){
            int i=addressDao.addressupdate(addressVo);
            if(i>0){
                return true;
            }
        }
        return false;
    }

    /**
     * tianjia
     * @param map
     * @return
     */
    @Override
    public boolean addresssave(Map<String, Object> map,String idcardzUrl,String idcardfUrl) {

        Long userCode=Long.parseLong(map.get("userCode").toString());
        String userName=map.get("userName").toString();
        String mobile=map.get("mobile").toString();
        String provinceName=map.get("provinceName").toString();
        String cityName=map.get("cityName").toString();
        String countryName=map.get("countryName").toString();
        String addressDetail=map.get("addressDetail").toString();
        Integer isDefaul=Integer.valueOf(map.get("isDefaul").toString());
        if (!CharUtil.regexphone(mobile)){
            new MyException("error mobile","请确认手机号");
        }
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
        addressVo.setIdcardzUrl(idcardzUrl);
        addressVo.setIdcardfUrl(idcardfUrl);
        if (addressVo!=null){
            int i=addressDao.addresssave(addressVo);
            if(i>0){
                return true;
            }
        }
        return false;
    }

    /**
     * 根据用户查询收货地
     * @param userId
     * @return
     */
    @Override
    public AddressVo queryByuserCode(Long  userId) {
        return addressDao.queryByuserCode(userId);
    }
}
