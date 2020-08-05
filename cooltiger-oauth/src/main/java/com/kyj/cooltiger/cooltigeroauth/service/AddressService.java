package com.kyj.cooltiger.cooltigeroauth.service;

import com.kyj.cooltiger.cooltigeroauth.entity.AddressVo;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/8/4 18:03
 */
public interface AddressService {
   AddressVo queryByuserCode(Long userCode);
}
