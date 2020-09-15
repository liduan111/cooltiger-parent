package com.kyj.cooltiger.feign.customer.client;

import com.kyj.cooltiger.common.utils.Result;
import com.kyj.cooltiger.feign.customer.vo.AdminInfoReqVo;
import com.kyj.cooltiger.feign.customer.vo.AdminLoginReqVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    @RequestMapping(value = "/adminLogin",method = {RequestMethod.POST})
    public Result adminLogin(@RequestBody AdminLoginReqVo adminLoginReqVo);
}
