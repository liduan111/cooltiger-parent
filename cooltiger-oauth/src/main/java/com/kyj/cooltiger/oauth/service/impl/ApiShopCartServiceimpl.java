package com.kyj.cooltiger.oauth.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.kyj.cooltiger.common.utils.RRException;
import com.kyj.cooltiger.oauth.dao.ShopCartDao;
import com.kyj.cooltiger.oauth.entity.ShopCartVo;
import com.kyj.cooltiger.oauth.service.ApiShopCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/8/12 15:30
 */
@Service
public class ApiShopCartServiceimpl implements ApiShopCartService {

    @Autowired
    private ShopCartDao shopCartDao;

    /**
     * 批量删除
     * @param parms
     */
    @Override
    public void deleteAllgoods(String  parms) {
        JSONObject object= JSON.parseObject(parms);
        Long  userCode=Long.parseLong(object.getString("userCode"));
        String  cartIds=object.getString("cardIds");
        if (userCode==null||userCode==0){
            new RRException("用户id不能为空");
        }
        if (cartIds==null||cartIds.equals("")){
            new RRException("cartIds不能为空");
        }
       String[] cartIdsarr=cartIds.split(",");
        shopCartDao.deleteAllgoods(userCode,cartIdsarr);

    }

    /**
     * 加入购物车
     * @param map
     * @return
     */
    @Override
    public boolean addshopcart(Map<String, Object> map) {

        Integer productId=Integer.valueOf(map.get("productId").toString());
        Integer  salenum=Integer.valueOf(map.get("shopNum").toString());
        Integer storeId=Integer.valueOf(map.get("storeId").toString());
        Long userCode=Long.valueOf(map.get("userCode").toString());
        Integer skuId=Integer.valueOf(map.get("skuId").toString());
        ShopCartVo shopCartVo=new ShopCartVo();
        shopCartVo.setUserCode(userCode);
        shopCartVo.setProductId(productId);
        shopCartVo.setStoreId(storeId);
        shopCartVo.setShopNum(salenum);
        shopCartVo.setSkuId(skuId);
        shopCartVo.setCreateTime(new Date());
        int i=shopCartDao.addshopcart(shopCartVo);
        if (i>0){
            return  true;
        }
        return false;
    }

    /**
     * 修改购物车商品数量
     * @param shopCartVo1
     * @return
     */
    @Override
    public boolean updatesaleNum(ShopCartVo shopCartVo1) {
        int i=shopCartDao.updatesaleNum(shopCartVo1);
        if(i>0){
            return  true;
        }
        return false;
    }

    /***
     * 删除购物车商品
     * @param userCode
     * @param cartIds
     * @return
     */
    @Override
    public void deletecartgoods(Long userCode, List<Long> cartIds) {
        shopCartDao.deletecartgoods(userCode,cartIds);
    }

    /**
     * 购物车列表
     * @param map
     * @return
     */
    @Override
    public List<ShopCartVo> shopcartlist(Map<String, Object> map) {
        return shopCartDao.shopcartlist(map);
    }
}
