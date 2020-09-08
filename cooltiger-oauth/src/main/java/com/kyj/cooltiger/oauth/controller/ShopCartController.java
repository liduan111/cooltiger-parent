package com.kyj.cooltiger.oauth.controller;

import com.kyj.cooltiger.common.utils.Result;
import com.kyj.cooltiger.feign.oauth.client.ShopCartClient;
import com.kyj.cooltiger.feign.product.client.ProductInfoClient;
import com.kyj.cooltiger.oauth.entity.GoodsEntity;
import com.kyj.cooltiger.oauth.entity.ShopCartVo;
import com.kyj.cooltiger.oauth.service.ApiShopCartService;
import com.kyj.cooltiger.oauth.utils.ApiBaseAction;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;



/**
 * @author guoxq
 * @version 1.0
 * @date 2020/8/12 15:25
 */
@Api("购物车")
@RestController
@RequestMapping("/api/cart")
public class ShopCartController extends ApiBaseAction implements ShopCartClient{

    @Autowired
    private ApiShopCartService shopCartService;

    @Autowired
    private ProductInfoClient productInfoClient;
    /**
     * 购物车列表
     * @param map
     * @return
     */
    @ApiOperation("获取用户购物车列表")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public Object  shopcartlist(@RequestBody Map<String,Object> map){

        if(map.size()==0||map.toString()==null){
            return  toResponsFail("参数为空");
        }
        map.put("sidx", "a.create_time");
        map.put("order", "desc ");
        map.put("offset", 0);
        map.put("limit", 8);
        List<ShopCartVo>  shopCartVoList=shopCartService.shopcartlist(map);
        return toResponsSuccess(shopCartVoList);
    }

    /**
     * 加入购物车
     * @param map
     * @return
     */
    @ApiOperation("加入购物车")
    @RequestMapping(value = "/addshopcart",method = RequestMethod.POST)
    public  Object  addshopcart(@RequestBody Map<String,Object> map){

        if(map==null|| map.size()==0){
            toResponsFail("参数为空");
        }
        Integer productId=Integer.valueOf(map.get("productId").toString());
        Integer  salenum=Integer.valueOf(map.get("shopNum").toString());
        Integer storeId=Integer.valueOf(map.get("storeId").toString());
        Long userCode=Long.valueOf(map.get("userCode").toString());
        Integer skuId=Integer.valueOf(map.get("skuId").toString());
        if ( salenum== 0) {
            return toResponsObject(400,"输入添加数量","");
        }
        Map<String,Object> map1=new HashMap<String,Object>();
        map1.put("sidx", "a.create_time");
        map1.put("order", "desc ");
        map1.put("offset", 0);
        map1.put("limit", 8);
        map1.put("userCode",userCode);
        List<ShopCartVo>  shopCartVoList=shopCartService.shopcartlist(map1);
        Result result=productInfoClient.getProductItem(productId);
        GoodsEntity productInfo1=(GoodsEntity)result.getData();
       // GoodsEntity productInfo1=null;
        if(productInfo1==null||productInfo1.getShelfStatus()!=1||productInfo1.getDeleted()!=0){
               return toResponsObject(400,"当前商品已下架","");
        }
        for (ShopCartVo shopCartVo:shopCartVoList){
            if(Objects.equals(skuId,shopCartVo.getSkuId())){
                ShopCartVo  shopCartVo1=new ShopCartVo();
                shopCartVo1.setCartId(shopCartVo.getCartId());
                shopCartVo1.setUserCode(userCode);
                shopCartVo1.setShopNum(salenum+shopCartVo.getShopNum());
                shopCartVo1.setCreateTime(new Date());
                //如果加入购物车数量小于0删除
                if(shopCartVo1.getShopNum()<=0){
                  shopCartService.deletecartgoods(userCode, Collections.singletonList(shopCartVo1.getCartId()));
                   return  toResponsMsgSuccess("删除成功");
                }
                //当库存不足时不能添加购物车
                if(shopCartVo.getStocks()<shopCartVo1.getShopNum()){
                    return  toResponsObject(400,"库存不足","");
                }
                  boolean flag=shopCartService.updatesaleNum(shopCartVo1);
                   if (flag){
                       return  toResponsMsgSuccess("加入成功");
                   }
                          return toResponsFail("加入失败");

            }
        }

        // 防止购物车已被删除的情况下,添加了负数的商品
        if (salenum < 0) {
            return toResponsObject(400,"商品已从购物车移除","");
        }
        //库存数量小于加入数量
        for (ShopCartVo shopCart:shopCartVoList){
            if(shopCart.getStocks()<salenum){
                return  toResponsObject(400,"库存不足","");
            }
        }
        boolean  flag=shopCartService.addshopcart(map);
        if(flag){
            return  toResponsMsgSuccess("加入成功");
        }
        return  toResponsFail("加入失败");
    }

    /**
     * 删除购物车
     * @param
     * @return
     */
    @ApiOperation("删除购物车商品")
    @RequestMapping(value = "/deleteAllgoods",method = RequestMethod.DELETE)
    public  Object deleteAllgoods(@RequestParam("userId") Long userId, @RequestParam("cartIds")String cartIds){

        shopCartService.deleteAllgoods(userId,cartIds);
        return  toResponsMsgSuccess("删除成功");
    }

    /**
     *获得商品数
     * @return
     */
    @ApiOperation("获得商品数")
    @RequestMapping(value = "/getgoodsNum",method = RequestMethod.GET)
    public Object getgoodsNum(@RequestBody Map<String,Object> map){
        Long userCode=Long.valueOf(map.get("userCode").toString());
        Map<String,Object> map1=new HashMap<String,Object>();
        map1.put("sidx", "a.create_time");
        map1.put("order", "desc ");
        map1.put("offset", 0);
        map1.put("limit", 8);
        map1.put("userCode",userCode);
        List<ShopCartVo> shopcartlist=shopCartService.shopcartlist(map1);
        Map<String,Object> parm=new HashMap<String,Object>();
        Map<String,Object> result=new HashMap<String,Object>();
        //获取购物车商品数量
        Integer goodsCount=0;
        for (ShopCartVo shopcart:shopcartlist) {
            goodsCount +=shopcart.getShopNum();
        }
        parm.put("goodsCount",goodsCount);
        result.put("parm",parm);
        return toResponsSuccess(result);
    }



}
