package com.kyj.cooltiger.cooltigerfeign.oauth.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientProperties;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/8/5 11:36
 */
@FeignClient(name ="Oauth-Service",configuration = FeignClientProperties.FeignClientConfiguration.class,contextId = "member")
public interface MemberClient {
    /**
     * 查询会员列表
     * @param map
     * @return
     */
    @RequestMapping(value = "/memberlist",method = RequestMethod.GET)
    public  Object  memberlist(@RequestBody Map<String,Object> map);

    /**
     * 根据用户id查询收货地址
     * @param code
     * @return
     */
    @RequestMapping(value = "/queryaddress",method = RequestMethod.GET)
    public Object queryaddress(@RequestBody String code);
}
