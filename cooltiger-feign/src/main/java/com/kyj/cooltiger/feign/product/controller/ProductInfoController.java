package com.kyj.cooltiger.feign.product.controller;

import com.kyj.cooltiger.common.utils.Result;
import com.kyj.cooltiger.feign.product.client.ProductInfoClient;
import com.kyj.cooltiger.feign.product.vo.ProductInfoAddReqVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author liduan
 * Description: 商品信息controller
 * date: 2020/8/24 14:14
 */
@RestController
@RequestMapping("/product/productInfo")
public class ProductInfoController {

    @Autowired
    private ProductInfoClient productInfoClient;

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
    @RequestMapping(value = "/getProductInfoList/{store_id}", method = {RequestMethod.GET})
    public Result getProductInfoList(
            @PathVariable("store_id") Integer storeId,
            @RequestParam(value = "page_no", defaultValue = "1") Integer pageNo,
            @RequestParam(value = "page_size", defaultValue = "10") Integer pageSize,
            @RequestParam(value = "category_id", required = false) Integer categoryId,
            @RequestParam(value = "keyword", required = false) String keyword) {
        return productInfoClient.getProductInfoList(storeId, pageNo, pageSize, categoryId, keyword);
    }

    /**
     * 添加商品信息
     *
     * @param storeId             店铺ID
     * @param productInfoAddReqVo 商品信息
     * @return
     */
    @RequestMapping(value = "/addProductInfo/{storeId}", method = {RequestMethod.POST})
    public Result addProductInfo(
            @PathVariable("storeId") Integer storeId,
            ProductInfoAddReqVo productInfoAddReqVo,
            @RequestParam("file") MultipartFile[] file) {
        return productInfoClient.addProductInfo(storeId, productInfoAddReqVo,file);
    }

    /**
     * 查询商品信息
     *
     * @param productId
     * @return
     */
    @RequestMapping(value = "/getProductInfo/{productId}", method = {RequestMethod.GET})
    public Result getProductInfo(@PathVariable("productId") Integer productId) {
        return productInfoClient.getProductInfo(productId);
    }

    /**
     * 商品下架
     *
     * @param productId
     * @return
     */
    @RequestMapping(value = "/productInfoDownShelf/{productId}", method = {RequestMethod.PUT})
    public Result productInfoDownShelf(@PathVariable("productId") Integer productId) {
        return productInfoClient.productInfoDownShelf(productId);
    }

    /**
     * 商品审核
     *
     * @param productId
     * @return
     */
    @RequestMapping(value = "/productInfoAudit/{productId}", method = {RequestMethod.PUT})
    public Result productInfoAudit(@PathVariable("productId") Integer productId) {
        return productInfoClient.productInfoAudit(productId);
    }

    /**
     * 删除商品信息
     *
     * @param productId
     * @return
     */
    @RequestMapping(value = "/deleteProductInfo/{productId}", method = {RequestMethod.DELETE})
    public Result deleteProductInfo(@PathVariable("productId") Integer productId) {
        return productInfoClient.deleteProductInfo(productId);
    }
}
