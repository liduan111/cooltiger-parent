package com.kyj.cooltiger.feign.customer.client;

import com.kyj.cooltiger.common.utils.Result;
import com.kyj.cooltiger.feign.customer.vo.AdminInfoReqVo;
import com.kyj.cooltiger.feign.customer.vo.AdminLoginReqVo;
import com.kyj.cooltiger.feign.customer.vo.PasswordReqVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author liduan
 * Description: 管理员信息client
 * date: 2020/9/14 15:00
 */
@FeignClient(name = "Customer-Service")
public interface AdminInfoClient {

    /**
     * 添加管理员
     *
     * @param adminInfoReqVo 管理员信息
     * @return
     */
    @RequestMapping(value = "/customer/adminInfo/addAdminInfo", method = {RequestMethod.POST})
    public Result addAdminInfo(@RequestBody AdminInfoReqVo adminInfoReqVo);

    /**
     * 管理员登录
     *
     * @param adminLoginReqVo 登录信息
     * @return
     */
    @RequestMapping(value = "/customer/adminInfo/login",method = {RequestMethod.POST})
    public Result adminLogin(@RequestBody AdminLoginReqVo adminLoginReqVo);

    /**
     * 管理员登出
     *
     * @param token
     * @return
     */
    @RequestMapping(value = "/customer/adminInfo/logOut", method = {RequestMethod.POST})
    public Result adminLoginOut(@RequestHeader("token") String token);

    /**
     * 获取管理员信息
     *
     * @param token
     * @return
     */
    @RequestMapping(value = "/getAdminInfo",method = {RequestMethod.GET})
    public Result getAdminInfo(@RequestHeader("token") String token);

    /**
     * 修改密码
     *
     * @param userId        用户ID
     * @param passwordReqVo 密码信息
     * @return
     */
    @RequestMapping(value = "/changePassword", method = {RequestMethod.POST})
    public Result changePassword(
            @RequestParam("user_id") Integer userId,
            @RequestBody PasswordReqVo passwordReqVo);
}
