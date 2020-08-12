package com.kyj.cooltiger.product.controller;

import com.kyj.cooltiger.common.utils.Result;
import com.kyj.cooltiger.feign.product.client.ProductInfoClient;
import com.kyj.cooltiger.feign.product.vo.ProductInfoAddReqVo;
import com.kyj.cooltiger.product.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author liduan
 * Description: 商品信息Controller
 * date: 2020/7/28 11:18
 */
@RestController
@RequestMapping("/product/productInfo")
public class ProductInfoController implements ProductInfoClient {

    @Autowired
    private ProductInfoService productInfoService;


    /**
     * 获取店铺商品列表
     * @param storeId 店铺ID
     * @param pageNo 当前页
     * @param pageSize 分页单位
     * @param categoryId 分类ID
     * @param keyword 搜索关键字
     * @return
     */
    @Override
    @RequestMapping(value = "/getProductInfoList/{storeId}",method = {RequestMethod.GET})
    public Result getProductInfoList(
            @PathVariable("storeId") Integer storeId,
            @RequestParam(value = "pageNo",defaultValue = "1") Integer pageNo,
            @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize,
            @RequestParam(value = "categoryId",required = false) Integer categoryId,
            @RequestParam(value = "keyword",required = false) String keyword) {
        Map<String, Object> resMap = productInfoService.getProductInfoListByStoreId(storeId, pageNo, pageSize, categoryId, keyword);
        return Result.success(resMap);
    }

    /**
     * 添加商品信息
     * @param storeId 店铺ID
     * @param productInfoAddReqVo 商品信息
     * @return
     */
    @Override
    @RequestMapping(value = "/addProductInfo/{storeId}",method = {RequestMethod.POST})
    public Result addProductInfo(
            @PathVariable("storeId") Integer storeId,
            @RequestParam("productInfoAddReqVo") ProductInfoAddReqVo productInfoAddReqVo) {
            productInfoService.addProductInfo(storeId,productInfoAddReqVo);
        return Result.success();
    }

    /**
     * 查询商品信息
     * @param productId
     * @return
     */
    @Override
    @RequestMapping(value = "/getProductInfo/{productId}",method = {RequestMethod.GET})
    public Result getProductInfo(@PathVariable("productId") Integer productId) {
        Map<String,Object> resMap = productInfoService.getProductInfo(productId);
        return null;
    }

    /**
     * 商品下架
     * @param productId
     * @return
     */
    @Override
    @RequestMapping(value = "/productInfoDownShelf/{productId}",method = {RequestMethod.PUT})
    public Result productInfoDownShelf(@PathVariable("productId") Integer productId){
        productInfoService.productInfoDownShelf(productId);
        return Result.success();
    }

    /**
     * 商品审核
     * @param productId
     * @return
     */
    @Override
    @RequestMapping(value = "/productInfoAudit/{productId}",method = {RequestMethod.PUT})
    public Result productInfoAudit(@PathVariable("productId") Integer productId){
        productInfoService.productInfoAudit(productId);
        return Result.success();
    }

    /**
     * 删除商品信息
     * @param productId
     * @return
     */
    @Override
    @RequestMapping(value = "/deleteProductInfo/{productId}",method = {RequestMethod.DELETE})
    public Result deleteProductInfo(@PathVariable("productId") Integer productId){
        productInfoService.deleteProductInfo(productId);
        return null;
    }

}
