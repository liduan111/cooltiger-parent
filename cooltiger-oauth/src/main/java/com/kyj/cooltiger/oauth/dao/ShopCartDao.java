package com.kyj.cooltiger.oauth.dao;

import com.kyj.cooltiger.oauth.entity.ShopCartVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/8/12 15:33
 */
@Mapper
public interface ShopCartDao {
    /**
     * 购物车列表查询
     * @param map
     * @return
     */
    List<ShopCartVo> shopcartlist(Map<String, Object> map);

}
