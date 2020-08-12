package com.kyj.cooltiger.oauth.service;

import com.kyj.cooltiger.oauth.entity.ShopCartVo;

import java.util.List;
import java.util.Map;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/8/12 15:29
 */
public interface ApiShopCartService {
    /**
     * 查询购物车列表
     * @param map
     * @return
     */
    List<ShopCartVo>  shopcartlist(Map<String,Object> map);

}
