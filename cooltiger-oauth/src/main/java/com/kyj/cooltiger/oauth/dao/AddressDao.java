package com.kyj.cooltiger.oauth.dao;

import com.kyj.cooltiger.oauth.entity.AddressVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

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
    List<AddressVo> addresslist(Map<String,Object> map);

    /**
     *  根据usercode查
     * @param  Id
     * @return
     */
   AddressVo queryByuserCode(@Param("Id")Long  Id);

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
