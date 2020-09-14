package com.kyj.cooltiger.customer.service;

import com.kyj.cooltiger.feign.customer.vo.AdminInfoReqVo;

/**
 * @author liduan
 * Description: 管理员信息service
 * date: 2020/9/14 14:55
 */
public interface AdminInfoService {

    /**
     * 添加管理员
     *
     * @param adminInfoReqVo 管理员信息
     */
    public void addAdminInfo(AdminInfoReqVo adminInfoReqVo);
}
