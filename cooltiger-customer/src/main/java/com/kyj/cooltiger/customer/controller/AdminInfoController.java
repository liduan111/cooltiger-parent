package com.kyj.cooltiger.customer.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.kyj.cooltiger.common.utils.Result;
import com.kyj.cooltiger.customer.config.RedisUtils;
import com.kyj.cooltiger.customer.service.AdminInfoService;
import com.kyj.cooltiger.feign.customer.client.AdminInfoClient;
import com.kyj.cooltiger.feign.customer.vo.AdminInfoReqVo;
import com.kyj.cooltiger.feign.customer.vo.AdminLoginReqVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author liduan
 * Description: 管理员信息controller
 * date: 2020/9/14 14:39
 */
@RestController
@RequestMapping("/customer/adminInfo")
public class AdminInfoController implements AdminInfoClient {

    @Autowired
    private AdminInfoService adminInfoService;
    @Autowired
    private RedisUtils redisUtils;

    /**
     * 添加管理员
     *
     * @param adminInfoReqVo 管理员信息
     * @return
     */
    @Override
    @RequestMapping(value = "/addAdminInfo", method = {RequestMethod.POST})
    public Result addAdminInfo(@RequestBody AdminInfoReqVo adminInfoReqVo) {
        adminInfoService.addAdminInfo(adminInfoReqVo);
        return Result.success();
    }

    /**
     * 管理员登录
     *
     * @param adminLoginReqVo 登录信息
     * @return
     */
    @Override
    @RequestMapping(value = "/adminLogin",method = {RequestMethod.POST})
    public Result adminLogin(@RequestBody AdminLoginReqVo adminLoginReqVo){
        Map<String, Object> res = adminInfoService.adminLogin(adminLoginReqVo);
        redisUtils.set((String)res.get("token"), JSON.toJSONString(res), 60*24L);
        return Result.success((String)res.get("token"));
    }
}
