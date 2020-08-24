package com.kyj.cooltiger.feign.oauth.controller;

import com.kyj.cooltiger.feign.oauth.client.MemberClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author liduan
 * Description:
 * date: 2020/8/24 14:31
 */
@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberClient memberClient;

    /**
     * 查询会员列表
     * @param map
     * @return
     */
    @RequestMapping(value = "/memberlist",method = RequestMethod.GET)
    public  Object  memberlist(@RequestBody Map<String,Object> map){
        return memberClient.memberlist(map);
    }

    /**
     * 根据用户id查询收货地址
     * @param code
     * @return
     */
    @RequestMapping(value = "/queryaddress",method = RequestMethod.GET)
    public Object queryaddress(@RequestBody String code){
        return memberClient.queryaddress(code);
    }
}
