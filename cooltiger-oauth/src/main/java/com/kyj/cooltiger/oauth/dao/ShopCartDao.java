package com.kyj.cooltiger.oauth.dao;

import com.kyj.cooltiger.oauth.entity.ShopCartVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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

    /**
     * 删除购物车商品
     * @param userCode cartIds
     * @return
     */
    void  deletecartgoods(@Param("userCode") Long userCode, @Param("cartIds") List<Long>  cartIds);

    /**
     * 修改购物车商品数量
     * @param shopCartVo1
     * @return
     */
    int  updatesaleNum(@Param("shopCartVo1") ShopCartVo shopCartVo1);

    /**
     * 加入购物车
     * @param shopCartVo
     * @return
     */
    int  addshopcart(ShopCartVo shopCartVo);

    /**
     * 删除购物车
     * @param userCode
     * @param cartIds
     */
    void deleteAllgoods(@Param("userCode") Long userCode,@Param("cartIds") String[] cartIds);




}
