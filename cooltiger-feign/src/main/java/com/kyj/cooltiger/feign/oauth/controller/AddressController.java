package com.kyj.cooltiger.feign.oauth.controller;

import com.kyj.cooltiger.feign.oauth.client.AddressClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
     * 根据用户查询收货地址
     * @param code
     * @return
     */
    @RequestMapping(value = "/queryaddress",method = RequestMethod.GET)
    public Object queryaddress(@RequestBody String code){
        return addressClient.queryaddress(code);
    }

    /***
     * 添加收货人地址
     * @param
     * @return
     */
    @RequestMapping(value = "/addressadd",method = RequestMethod.POST)
    public  Object  addressave(@RequestParam(value = "userCode", required = false) Long userCode,
                               @RequestParam(value = "userName", required = false) String userName,
                               @RequestParam(value = "mobile", required = false) String  mobile,
                               @RequestParam(value = "provinceName", required = false) String  provinceName,
                               @RequestParam(value = "cityName", required = false) String cityName,
                               @RequestParam(value = "countryName", required = false) String countryName,
                               @RequestParam(value = "addressDetail", required = false) String addressDetail,
                               @RequestParam(value = "isDefaul", required = false) Integer isDefaul,
                               @RequestParam(value = "idcardz", required = false) MultipartFile idcardz,
                               @RequestParam(value = "idcardf", required = false) MultipartFile idcardf){
        return addressClient.addressave(userCode,userName,mobile,provinceName,cityName,countryName,addressDetail,isDefaul,idcardz,idcardf);
    }
    /**
     * 修改收货人地址
     * @param
     * @return
     */
    @RequestMapping(value = "/addressupdate",method = RequestMethod.PUT)
    public  Object  addressupdate(@RequestParam(value = "userCode", required = false) Long userCode,
                                  @RequestParam(value = "Id", required = false) Long Id,
                                  @RequestParam(value = "userName", required = false) String userName,
                                  @RequestParam(value = "mobile", required = false) String  mobile,
                                  @RequestParam(value = "provinceName", required = false) String  provinceName,
                                  @RequestParam(value = "cityName", required = false) String cityName,
                                  @RequestParam(value = "countryName", required = false) String countryName,
                                  @RequestParam(value = "addressDetail", required = false) String addressDetail,
                                  @RequestParam(value = "isDefaul", required = false) Integer isDefaul,
                                  @RequestParam(value = "idcardz", required = false) MultipartFile idcardz,
                                  @RequestParam(value = "idcardf", required = false) MultipartFile idcardf){
        return addressClient.addressupdate(Id,userCode,userName,mobile,provinceName,cityName,countryName,addressDetail,isDefaul,idcardz,idcardf);
    }

    /**
     * 收货地址列表
     * @return
     */
    @RequestMapping(value = "/addresslist",method = RequestMethod.GET)
    public  Object Addresslist(@RequestBody Map<String,Object> map){
        return addressClient.Addresslist(map);
    }
}
