package com.kyj.cooltiger.cooltigeroauth.dao;

import com.kyj.cooltiger.cooltigeroauth.entity.AddressVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/8/4 18:05
 */
@Mapper
public interface AddressDao {
    /**
     *  根据usercode查
     * @param userCode
     * @return
     */
   AddressVo queryByuserCode(@Param("userCode")Long userCode);
}
