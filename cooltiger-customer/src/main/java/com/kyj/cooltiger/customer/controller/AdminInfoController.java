package com.kyj.cooltiger.customer.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.kyj.cooltiger.common.utils.Result;
import com.kyj.cooltiger.customer.config.RedisUtils;
import com.kyj.cooltiger.customer.service.AdminInfoService;
import com.kyj.cooltiger.feign.customer.client.AdminInfoClient;
import com.kyj.cooltiger.feign.customer.vo.AdminInfoReqVo;
import com.kyj.cooltiger.feign.customer.vo.AdminLoginReqVo;
import com.kyj.cooltiger.feign.customer.vo.PasswordReqVo;
import com.kyj.cooltiger.feign.vo.AdminInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @RequestMapping(value = "/login",method = {RequestMethod.POST})
    public Result adminLogin(@RequestBody AdminLoginReqVo adminLoginReqVo){
        Map<String, Object> res = adminInfoService.adminLogin(adminLoginReqVo);
        redisUtils.set((String)res.get("token"), JSON.toJSONString(res.get("data")), 60*24L);
        return Result.success(res.get("token"));
    }

    /**
     * 管理员登出
     *
     * @param token
     * @return
     */
    @RequestMapping(value = "/logOut", method = {RequestMethod.POST})
    public Result adminLoginOut(@RequestHeader("token") String token){
        redisUtils.delete(token);
        return Result.success();
    }

    /**
     * 获取管理员信息
     *
     * @param token
     * @return
     */
    @RequestMapping(value = "/getAdminInfo",method = {RequestMethod.GET})
    public Result getAdminInfo(@RequestHeader("token") String token){
        String jsonString = redisUtils.get(token);
        AdminInfoVo adminInfoVo = JSONObject.parseObject(jsonString, AdminInfoVo.class);
        return Result.success(adminInfoVo);
    }

    /**
     * 修改密码
     *
     * @param userId        用户ID
     * @param passwordReqVo 密码信息
     * @return
     */
    @RequestMapping(value = "/changePassword", method = {RequestMethod.PUT})
    public Result changePassword(
            @RequestParam("user_id") Integer userId,
            @RequestBody PasswordReqVo passwordReqVo){
        adminInfoService.changePassword(userId,passwordReqVo);
        return Result.success();
    }
}
