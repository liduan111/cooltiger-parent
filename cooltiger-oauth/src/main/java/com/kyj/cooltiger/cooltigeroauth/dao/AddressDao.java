package com.kyj.cooltiger.cooltigeroauth.dao;

import com.kyj.cooltiger.cooltigeroauth.entity.AddressVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/8/4 18:05
 */
@Mapper
public interface AddressDao {
    /**
     * 收货地址列表查询
     * @return
     */
    List<AddressVo> addresslist();

    /**
     *  根据usercode查
     * @param userCode
     * @return
     */
   AddressVo queryByuserCode(@Param("userCode")Long userCode);

    /**
     * 添加收货人地址
     * @param addressVo
     * @return
     */
   int addresssave(AddressVo addressVo);

    /**
     * 修改收货人地址
     * @param addressVo
     * @return
     */
   int addressupdate(AddressVo addressVo);
}
