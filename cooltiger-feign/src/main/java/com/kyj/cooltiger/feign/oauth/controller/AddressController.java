package com.kyj.cooltiger.feign.oauth.controller;

import com.kyj.cooltiger.feign.oauth.client.AddressClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author liduan
 * Description:
 * date: 2020/8/24 14:25
 */
@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressClient addressClient;

    /**
     * 根据用户id查询收货地址
     * @param code
     * @return
     */
    @RequestMapping(value = "/queryaddress",method = RequestMethod.GET)
    public Object queryaddress(@RequestBody String code){
        return addressClient.queryaddress(code);
    }

    /***
     * 添加收货人地址
     * @param map
     * @return
     */
    @RequestMapping(value = "/addressadd",method = RequestMethod.POST)
    public  Object  addressave(@RequestBody Map<String,Object> map){
        return addressClient.addressave(map);
    }
    /**
     * 修改收货人地址
     * @param map
     * @return
     */
    @RequestMapping(value = "/addressupdate",method = RequestMethod.POST)
    public  Object  addressupdate(@RequestBody Map<String,Object> map){
        return addressClient.addressupdate(map);
    }

    /**
     * 收货地址列表
     * @return
     */
    @RequestMapping(value = "/addresslist",method = RequestMethod.GET)
    public  Object Addresslist(){
        return addressClient.Addresslist();
    }
}
