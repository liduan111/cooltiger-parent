package com.kyj.cooltiger.feign.oauth.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/8/6 15:35
 */
@FeignClient(name = "Oauth-Service")
public interface AddressClient {
    /**
     * 根据用户id查询收货地址
     * @param code
     * @return
     */
    @RequestMapping(value = "/address/queryaddress",method = RequestMethod.GET)
    public Object queryaddress(@RequestBody String code);

    /***
     * 添加收货人地址
     * @param
     * @return
     */
    @RequestMapping(value = "/address/addressadd",method = RequestMethod.POST)
    public  Object  addressave(@RequestParam(value = "userCode", required = false) Long userCode,
                               @RequestParam(value = "userName", required = false) String userName,
                               @RequestParam(value = "mobile", required = false) String  mobile,
                               @RequestParam(value = "provinceName", required = false) String  provinceName,
                               @RequestParam(value = "cityName", required = false) String cityName,
                               @RequestParam(value = "countryName", required = false) String countryName,
                               @RequestParam(value = "addressDetail", required = false) String addressDetail,
                               @RequestParam(value = "isDefaul", required = false) Integer isDefaul,
                               @RequestParam(value = "idcardz", required = false) MultipartFile idcardz,
                               @RequestParam(value = "idcardf", required = false) MultipartFile idcardf);
    /**
     * 修改收货人地址
     * @param
     * @return
     */
    @RequestMapping(value = "/address/addressupdate",method = RequestMethod.PUT)
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
                                  @RequestParam(value = "idcardf", required = false) MultipartFile idcardf);

    /**
     * 收货地址列表
     * @return
     */
    @RequestMapping(value = "/address/addresslist",method = RequestMethod.GET)
    public  Object Addresslist(@RequestBody Map<String,Object> map);

    /**
     * 删除收货人地址
     *
     * @param //usercode id
     * @return
     */
    @RequestMapping(value = "/addressdelete",method = RequestMethod.DELETE)
    public Object deleteaddress(@RequestBody Map<String,Object> map);
}
