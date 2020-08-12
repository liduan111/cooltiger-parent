package com.kyj.cooltiger.oauth.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.kyj.cooltiger.feign.oauth.client.AddressClient;
import com.kyj.cooltiger.oauth.entity.AddressVo;
import com.kyj.cooltiger.oauth.service.AddressService;
import com.kyj.cooltiger.oauth.utils.ApiBaseAction;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/8/6 15:33
 */
@Api("收货地址接口")
@RestController
@RequestMapping("/address")
public class AddressController extends ApiBaseAction  implements AddressClient {

    @Autowired
    private AddressService addressService;

    /**
     * 收货地址列表
     * @return
     */
    @ApiOperation("收货地址列表")
    @RequestMapping(value = "/addresslist",method = RequestMethod.GET)
    public  Object Addresslist(){
        List<AddressVo>  addressVoList=addressService.addresslist();

        return toResponsSuccess(addressVoList);
    }


    /**
     * 根据用户id查询收货地址
     * @param code
     * @return
     */
    @ApiOperation("根据用户id查询收货地址")
    @RequestMapping(value = "/queryaddress",method = RequestMethod.GET)
    public Object queryaddress(@RequestBody String code){
        JSONObject object= JSON.parseObject(code);
        Long  userCode=Long.parseLong(object.getString("userCode"));
        if (userCode!=null||userCode!=0) {
            AddressVo addressVo = addressService.queryByuserCode(userCode);
            return toResponsSuccess(addressVo);
        }else {
            return  toResponsFail("id为空");
        }
    }

    /***
     * 添加收货人地址
     * @param map
     * @return
     */
    @ApiOperation("添加收货人地址")
    @RequestMapping(value = "/addressadd",method = RequestMethod.POST)
    public  Object  addressave(@RequestBody Map<String,Object> map){
       if (!map.isEmpty()||map.size()!=0) {
           boolean flag = addressService.addresssave(map);
           if (flag) {
               return toResponsMsgSuccess("添加成功");
           }
       }
        return toResponsFail("添加失败");
    }

    /**
     * 修改收货人地址
     * @param map
     * @return
     */
    @ApiOperation("修改收货人地址")
    @RequestMapping(value = "/addressupdate",method = RequestMethod.POST)
    public  Object  addressupdate(@RequestBody Map<String,Object> map){

        if (!map.isEmpty()||map.size()!=0) {
            boolean flag = addressService.addressupdate(map);
            if (flag) {
                return toResponsMsgSuccess("修改成功");
            }
        }


        return toResponsFail("修改失败");
    }





}
