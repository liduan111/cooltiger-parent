package com.kyj.cooltiger.product.controller;

import com.kyj.cooltiger.common.utils.Result;
import com.kyj.cooltiger.feign.product.client.ProductInfoClient;
import com.kyj.cooltiger.feign.product.vo.ProductBaseReqVo;
import com.kyj.cooltiger.feign.product.vo.ProductSkuReqVo;
import com.kyj.cooltiger.product.entity.ProductInfo;
import com.kyj.cooltiger.product.service.ProductInfoService;
import com.kyj.cooltiger.product.service.StoreInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    @Autowired
    private StoreInfoService storeInfoService;

    /**
     * 获取店铺商品列表
     *
     * @param storeId    店铺ID
     * @param pageNo     当前页
     * @param pageSize   分页单位
     * @param categoryId 分类ID
     * @param keyword    搜索关键字
     * @return
     */
    @Override
    @RequestMapping(value = "/getProductInfoList/{store_id}", method = {RequestMethod.GET})
    public Result getProductInfoList(
            @PathVariable("store_id") Integer storeId,
            @RequestParam(value = "page_no", defaultValue = "1") Integer pageNo,
            @RequestParam(value = "page_size", defaultValue = "10") Integer pageSize,
            @RequestParam(value = "category_id", required = false) Integer categoryId,
            @RequestParam(value = "keyword", required = false) String keyword) {
        Map<String, Object> res = productInfoService.getProductInfoListByStoreId(storeId, pageNo, pageSize, categoryId, keyword);
        return Result.success(res);
    }

    /**
     * 添加商品基本信息
     *
     * @param storeId          店铺ID
     * @param productBaseReqVo 商品基本信息
     * @return
     */
    @RequestMapping(value = "/addProductBaseInfo/{store_id}", method = {RequestMethod.POST})
    public Result addProductBaseInfo(
            @PathVariable("store_id") Integer storeId,
            @RequestBody ProductBaseReqVo productBaseReqVo) {
        Map<String, Object> res = productInfoService.addProductBaseInfo(storeId, productBaseReqVo);
        return Result.success(res);
    }

    /**
     * 添加商品Sku信息
     *
     * @param productId       商品ID
     * @param productSkuReqVo 商品Sku信息
     * @return
     */
    @Override
    @RequestMapping(value = "/addProductInfo/{product_id}", method = {RequestMethod.POST})
    public Result addProductInfo(
            @PathVariable("product_id") Integer productId,
            @RequestBody ProductSkuReqVo productSkuReqVo) {
        int i = 0;
        //productInfoService.addProductInfo(storeId, productInfoAddReqVo);
        return Result.success();
    }

    /**
     * 查询商品信息
     *
     * @param productId
     * @return
     */
    @Override
    @RequestMapping(value = "/getProductInfo/{productId}", method = {RequestMethod.GET})
    public Result getProductInfo(@PathVariable("productId") Integer productId) {
        productInfoService.getProductInfo(productId);
        return null;
    }

    /**
     * 商品下架
     *
     * @param productId
     * @return
     */
    @Override
    @RequestMapping(value = "/productInfoDownShelf/{productId}", method = {RequestMethod.PUT})
    public Result productInfoDownShelf(@PathVariable("productId") Integer productId) {
        productInfoService.productInfoDownShelf(productId);
        return Result.success();
    }

    /**
     * 商品审核
     *
     * @param productId
     * @return
     */
    @Override
    @RequestMapping(value = "/productInfoAudit/{productId}", method = {RequestMethod.PUT})
    public Result productInfoAudit(@PathVariable("productId") Integer productId) {
        productInfoService.productInfoAudit(productId);
        return Result.success();
    }

    /**
     * 删除商品信息
     *
     * @param productId
     * @return
     */
    @Override
    @RequestMapping(value = "/deleteProductInfo/{productId}", method = {RequestMethod.DELETE})
    public Result deleteProductInfo(@PathVariable("productId") Integer productId) {
        productInfoService.deleteProductInfo(productId);
        return null;
    }

    /**
     * 上传商品图片
     *
     * @param productId 商品ID
     * @param picType   图片类型（1-商品图片2-sku图片3-详情图片）
     * @param pic       图片
     * @return
     */
    @RequestMapping(value = "/upProductImage", method = {RequestMethod.POST})
    public Result upProductImage(
            @RequestParam("product_id") Integer productId,
            @RequestParam("pic_type") Integer picType,
            @RequestParam("pic") MultipartFile pic) {
        //获取商品信息
        ProductInfo productInfo = productInfoService.getProductInfo(productId);
        //获取店铺信息
        Map<String, Object> storeInfo = storeInfoService.getStoreInfo(productInfo.getStoreId());
        return Result.success();
    }
}
