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

    /**
     * 加入购物车
     * @param map
     * @return
     */
    boolean addshopcart(Map<String,Object> map);

    /**
     * 删除购物车商品
     * @param userCode
     * @param cartIds
     */
    void   deletecartgoods(Long userCode,List<Long> cartIds);

    /**
     * 修改购物车商品数量
     * @param shopCartVo1
     * @return
     */
    boolean  updatesaleNum(ShopCartVo shopCartVo1);

    /**
     * 清空购物车
     * @param parms
     */
    void  deleteAllgoods(String parms);




}
