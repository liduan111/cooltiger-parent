package com.kyj.cooltiger.feign.product.controller;

import com.kyj.cooltiger.common.utils.Result;
import com.kyj.cooltiger.feign.product.client.ProductInfoClient;
import com.kyj.cooltiger.feign.product.vo.ProductBaseReqVo;
import com.kyj.cooltiger.feign.product.vo.ProductSkuReqVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

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
        return productInfoClient.addProductBaseInfo(storeId, productBaseReqVo);
    }


    /**
     * 查询商品信息
     *
     * @param productId
     * @return
     */
    @RequestMapping(value = "/getProductItem/{productId}", method = {RequestMethod.GET})
    public Result getProductItem(@PathVariable("productId") Integer productId) {
        return productInfoClient.getProductItem(productId);
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

    /**
     * 批量上传商品图片
     *
     * @param productId 商品ID
     * @param picType   图片类型（1-商品图片2-sku图片3-详情图片）
     * @param pics      图片
     * @return
     */
    @RequestMapping(value = "/upProductImage", method = {RequestMethod.POST})
    public Result upProductImage(
            @RequestParam("product_id") Integer productId,
            @RequestParam("pic_type") Integer picType,
            @RequestParam("pics") MultipartFile[] pics) {
        return productInfoClient.upProductImage(productId, picType, pics);
    }

    /**
     * 批量删除图片
     *
     * @param imageUrls 图片url
     * @return
     */
    @RequestMapping(value = "/delProductImage", method = {RequestMethod.DELETE})
    public Result delProductImage(
            @RequestBody List<String> imageUrls) {
        return productInfoClient.delProductImage(imageUrls);
    }

    /**
     * 添加修改商品详情
     *
     * @param productId 商品ID
     * @param detail    商品详情
     * @return
     */
    @RequestMapping(value = "/addProductDetail", method = {RequestMethod.POST})
    public Result addProductDetail(
            @RequestParam("product_id") Integer productId,
            @RequestParam("detail") String detail) {
        return productInfoClient.addProductDetail(productId, detail);
    }

    /**
     * 查询商品规格属性
     *
     * @param productId 商品ID
     * @return
     */
    @RequestMapping(value = "/getProductSpec", method = {RequestMethod.GET})
    public Result getProductSpec(
            @RequestParam("product_id") Integer productId) {
        return productInfoClient.getProductSpec(productId);
    }
}
