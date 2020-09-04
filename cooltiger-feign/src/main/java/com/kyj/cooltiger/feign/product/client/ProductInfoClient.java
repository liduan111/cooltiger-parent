package com.kyj.cooltiger.feign.product.client;

import com.kyj.cooltiger.common.utils.Result;
import com.kyj.cooltiger.feign.product.vo.ProductBaseReqVo;
import com.kyj.cooltiger.feign.product.vo.ProductSkuReqVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author liduan
 * Description: 商品信息FeignClient接口
 * date: 2020/7/28 14:44
 */
@FeignClient(name = "Product-Service")
public interface ProductInfoClient {

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
    @RequestMapping(value = "/product/productInfo/getProductInfoList/{store_id}", method = {RequestMethod.GET})
    public Result getProductInfoList(
            @PathVariable("store_id") Integer storeId,
            @RequestParam(value = "page_no", defaultValue = "1") Integer pageNo,
            @RequestParam(value = "page_size", defaultValue = "10") Integer pageSize,
            @RequestParam(value = "category_id", required = false) Integer categoryId,
            @RequestParam(value = "keyword", required = false) String keyword);

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
            @RequestBody ProductBaseReqVo productBaseReqVo);

    /**
     * 添加商品Sku信息
     *
     * @param productId       商品ID
     * @param productSkuReqVo 商品Sku信息
     * @return
     */
    @RequestMapping(value = "/product/productInfo/addProductSkuInfo/{product_id}", method = {RequestMethod.POST})
    public Result addProductSkuInfo(
            @PathVariable("product_id") Integer productId,
            @RequestBody ProductSkuReqVo productSkuReqVo);

    /**
     * 查询商品信息
     *
     * @param productId
     * @return
     */
    @RequestMapping(value = "/product/productInfo/getProductInfo/{productId}", method = {RequestMethod.GET})
    public Result getProductInfo(@PathVariable("productId") Integer productId);

    /**
     * 商品下架
     *
     * @param productId
     * @return
     */
    @RequestMapping(value = "/product/productInfo/productInfoDownShelf/{productId}", method = {RequestMethod.PUT})
    public Result productInfoDownShelf(@PathVariable("productId") Integer productId);

    /**
     * 商品审核
     *
     * @param productId
     * @return
     */
    @RequestMapping(value = "/product/productInfo/productInfoAudit/{productId}", method = {RequestMethod.PUT})
    public Result productInfoAudit(@PathVariable("productId") Integer productId);

    /**
     * 删除商品信息
     *
     * @param productId
     * @return
     */
    @RequestMapping(value = "/product/productInfo/product/productInfo/deleteProductInfo/{productId}", method = {RequestMethod.DELETE})
    public Result deleteProductInfo(@PathVariable("productId") Integer productId);

    /**
     * 批量上传商品图片
     *
     * @param productId 商品ID
     * @param picType   图片类型（1-商品图片2-sku图片3-详情图片）
     * @param pics      图片
     * @return
     */
    @RequestMapping(value = "/product/productInfo/upProductImage", method = {RequestMethod.POST})
    public Result upProductImage(
            @RequestParam("product_id") Integer productId,
            @RequestParam("pic_type") Integer picType,
            @RequestParam("pics") MultipartFile[] pics);

    /**
     * 批量删除图片
     *
     * @param imageUrls 图片url
     * @return
     */
    @RequestMapping(value = "/product/productInfo/delProductImage", method = {RequestMethod.DELETE})
    public Result delProductImage(
            @RequestBody List<String> imageUrls);

    /**
     * 添加修改商品详情
     *
     * @param productId 商品ID
     * @param detail    商品详情
     * @return
     */
    @RequestMapping(value = "/product/productInfo/addProductDetail", method = {RequestMethod.POST})
    public Result addProductDetail(
            @RequestParam("product_id") Integer productId,
            @RequestParam("detail") String detail);

    /**
     * 获取商品sku信息
     *
     * @param skuId skuID
     * @return
     */
    @RequestMapping(value = "/product/productInfo/getProductSku", method = {RequestMethod.GET})
    public Result getProductSku(
            @RequestParam("sku_id") Integer skuId);
}
