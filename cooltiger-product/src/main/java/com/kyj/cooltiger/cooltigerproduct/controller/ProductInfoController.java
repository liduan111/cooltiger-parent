package com.kyj.cooltiger.cooltigerproduct.controller;

import com.kyj.cooltiger.cooltigercommon.utils.Result;
import com.kyj.cooltiger.cooltigerfeign.product.client.ProductInfoClient;
import com.kyj.cooltiger.cooltigerfeign.product.vo.ProductInfoAddReqVo;
import com.kyj.cooltiger.cooltigerproduct.service.ProductInfoService;
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
     * 测试方法
     * @param id
     * @return
     */
    @Override
    @RequestMapping(value = "/hello/{id}",method = {RequestMethod.GET})
    public Result hello(@PathVariable("id") String id){
        return Result.success("sucess");
    }

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
            @PathVariable("storeId") String storeId,
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
            @PathVariable("storeId") String storeId,
            @RequestParam("productInfoAddReqVo") ProductInfoAddReqVo productInfoAddReqVo) {
            productInfoService.addProductInfo(storeId,productInfoAddReqVo);
        return Result.success();
    }

}
