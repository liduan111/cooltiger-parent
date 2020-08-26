package com.kyj.cooltiger.feign.product.client;

import com.kyj.cooltiger.common.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author liduan
 * Description: 商品品牌信息Client
 * date: 2020/8/11 14:49
 */
@FeignClient(name = "Product-Service")
public interface ProductBrandInfoClient {

    /**
     * 添加品牌信息
     *
     * @param brandName 品牌名称
     * @param brandDesc 品牌描述
     * @param brandOrder 排序
     * @param brandStatus 品牌状态 0-未启用1-启用
     * @param brandLogo 品牌logo
     * @return
     */
    @RequestMapping(value = "/product/productBrandInfo/addProductBrandInfo", method = {RequestMethod.POST})
    public Result addProductBrandInfo(
            @RequestParam("brand_name") String brandName,
            @RequestParam(value = "brand_desc", required = false) String brandDesc,
            @RequestParam(value = "brand_order",defaultValue = "0") Integer brandOrder,
            @RequestParam(value = "brand_status",defaultValue = "1") Integer brandStatus,
            @RequestParam(value = "brand_logo", required = false) MultipartFile brandLogo);

    /**
     * 查询品牌列表信息
     *
     * @param pageNo
     * @param pageSize
     * @param keyword
     * @return
     */
    @RequestMapping(value = "/product/productBrandInfo/getProductBrandInfoList", method = {RequestMethod.GET})
    public Result getProductBrandInfoList(
            @RequestParam(value = "page_no", defaultValue = "1") Integer pageNo,
            @RequestParam(value = "page_size", defaultValue = "10") Integer pageSize,
            @RequestParam(value = "keyword", required = false) String keyword);

    /**
     * 修改商品品牌信息
     *
     * @param brandId 品牌ID
     * @param brandName 品牌名称
     * @param brandDesc 品牌描述
     * @param brandOrder 排序
     * @param brandStatus 品牌状态 0-未启用1-已启用
     * @return
     */
    @RequestMapping(value = "/product/productBrandInfoupdateProductBrandInfo", method = {RequestMethod.PUT})
    public Result updateProductBrandInfo(
            @RequestParam("brand_id") Integer brandId,
            @RequestParam("brand_name") String brandName,
            @RequestParam(value = "brand_desc", required = false) String brandDesc,
            @RequestParam(value = "brand_order",defaultValue = "0") Integer brandOrder,
            @RequestParam(value = "brand_status",defaultValue = "1") Integer brandStatus);

    /**
     * 删除品牌信息
     *
     * @param brandId 品牌ID
     * @return
     */
    @RequestMapping(value = "/product/productBrandInfo/delProductBrandInfo", method = {RequestMethod.DELETE})
    public Result delProductBrandInfo(
            @RequestParam("brand_id") Integer brandId);

    /**
     * 更换品牌logo图片
     *
     * @param brandId 品牌ID
     * @param brandLogo 品牌logo
     * @return
     */
    @RequestMapping(value = "/product/productBrandInfo/updateBrandLogo",method = {RequestMethod.PUT})
    public Result updateBrandLogo(
            @RequestParam("brand_id") Integer brandId,
            @RequestParam(value = "brand_logo") MultipartFile brandLogo);
}
