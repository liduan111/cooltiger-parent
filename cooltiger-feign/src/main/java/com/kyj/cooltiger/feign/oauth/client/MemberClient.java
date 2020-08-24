package com.kyj.cooltiger.feign.oauth.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/8/5 11:36
 */
@FeignClient(name = "Oauth-Service")
public interface MemberClient {
    /**
     * 查询会员列表
     * @param map
     * @return
     */
    @RequestMapping(value = "/member/memberlist",method = RequestMethod.GET)
    public  Object  memberlist(@RequestBody Map<String,Object> map);

    /**
     * 根据用户id查询收货地址
     * @param code
     * @return
     */
    @RequestMapping(value = "/member/queryaddress",method = RequestMethod.GET)
    public Object queryaddress(@RequestBody String code);
}
