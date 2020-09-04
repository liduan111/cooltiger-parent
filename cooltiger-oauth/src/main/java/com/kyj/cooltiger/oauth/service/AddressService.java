package com.kyj.cooltiger.oauth.service;

import com.kyj.cooltiger.oauth.entity.AddressVo;

import java.util.List;
import java.util.Map;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/8/4 18:03
 */
public interface AddressService {

   /**
    * 查询收货地址列表
    * @return
    */
   List<AddressVo> addresslist(Map<String,Object> map);

   /**
    *
    *查询收货人地址
    */
   AddressVo queryByuserCode(Long userId);

   /**
    * 添加收货人地址
    * @param map
    * @return
    */
   boolean addresssave(Map<String,Object> map,String idcardzUrl,String idcardfUrl);

   /**
    * 修改收货人地址
    * @param map
    * @return
    */
   boolean addressupdate(Map<String,Object> map,String idcardzUrl,String idcardfUrl);

   /**
    * 删除地址
    * @param map
    */
   void  deleteaddress(Map<String,Object> map);
}
