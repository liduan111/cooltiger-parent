package com.kyj.cooltiger.feign.customer.controller;

import com.kyj.cooltiger.common.utils.Result;
import com.kyj.cooltiger.feign.customer.client.AdminInfoClient;
import com.kyj.cooltiger.feign.customer.vo.AdminInfoReqVo;
import com.kyj.cooltiger.feign.customer.vo.AdminLoginReqVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liduan
 * Description: 管理员信息controller
 * date: 2020/9/14 15:00
 */
@RestController
@RequestMapping("/customer/adminInfo")
public class AdminInfoController {

    @Autowired
    private AdminInfoClient adminInfoClient;

    /**
     * 添加管理员
     *
     * @param adminInfoReqVo 管理员信息
     * @return
     */
    @RequestMapping(value = "/addAdminInfo", method = {RequestMethod.POST})
    public Result addAdminInfo(@RequestBody AdminInfoReqVo adminInfoReqVo) {
        return adminInfoClient.addAdminInfo(adminInfoReqVo);
    }

    /**
     * 管理员登录
     *
     * @param adminLoginReqVo 登录信息
     * @return
     */
    @RequestMapping(value = "/adminLogin",method = {RequestMethod.POST})
    public Result adminLogin(@RequestBody AdminLoginReqVo adminLoginReqVo){
        return adminInfoClient.adminLogin(adminLoginReqVo);
    }
}
