package com.kyj.cooltiger.feign.product.controller;

import com.kyj.cooltiger.common.utils.Result;
import com.kyj.cooltiger.feign.product.client.ProductBrandInfoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author liduan
 * Description: 品牌信息controller
 * date: 2020/8/24 14:02
 */
@RestController
@RequestMapping("/product/productBrandInfo")
public class ProductBrandInfoController {

    @Autowired
    private ProductBrandInfoClient productBrandInfoClient;

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
    @RequestMapping(value = "/addProductBrandInfo", method = {RequestMethod.POST})
    public Result addProductBrandInfo(
            @RequestParam("brand_name") String brandName,
            @RequestParam(value = "brand_desc", required = false) String brandDesc,
            @RequestParam(value = "brand_order",defaultValue = "0") Integer brandOrder,
            @RequestParam(value = "brand_status",defaultValue = "1") Integer brandStatus,
            @RequestParam(value = "brand_logo", required = false) MultipartFile brandLogo){
        return productBrandInfoClient.addProductBrandInfo(brandName,brandDesc,brandOrder,brandStatus,brandLogo);
    }

    /**
     * 查询品牌列表信息
     *
     * @param pageNo
     * @param pageSize
     * @param keyword
     * @return
     */
    @RequestMapping(value = "/getProductBrandInfoList", method = {RequestMethod.GET})
    public Result getProductBrandInfoList(
            @RequestParam(value = "page_no", defaultValue = "1") Integer pageNo,
            @RequestParam(value = "page_size", defaultValue = "10") Integer pageSize,
            @RequestParam(value = "keyword", required = false) String keyword){
        return productBrandInfoClient.getProductBrandInfoList(pageNo,pageSize,keyword);
    }

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
    @RequestMapping(value = "updateProductBrandInfo", method = {RequestMethod.PUT})
    public Result updateProductBrandInfo(
            @RequestParam("brand_id") Integer brandId,
            @RequestParam("brand_name") String brandName,
            @RequestParam(value = "brand_desc", required = false) String brandDesc,
            @RequestParam(value = "brand_order",defaultValue = "0") Integer brandOrder,
            @RequestParam(value = "brand_status",defaultValue = "1") Integer brandStatus){
        return productBrandInfoClient.updateProductBrandInfo(brandId,brandName,brandDesc,brandOrder,brandStatus);
    }

    /**
     * 删除品牌信息
     *
     * @param brandId 品牌ID
     * @return
     */
    @RequestMapping(value = "/delProductBrandInfo", method = {RequestMethod.DELETE})
    public Result delProductBrandInfo(
            @RequestParam("brand_id") Integer brandId){
        return productBrandInfoClient.delProductBrandInfo(brandId);
    }

    /**
     * 更换品牌logo图片
     *
     * @param brandId 品牌ID
     * @param brandLogo 品牌logo
     * @return
     */
    @RequestMapping(value = "/updateBrandLogo",method = {RequestMethod.PUT})
    public Result updateBrandLogo(
            @RequestParam("brand_id") Integer brandId,
            @RequestParam(value = "brand_logo") MultipartFile brandLogo){
        return productBrandInfoClient.updateBrandLogo(brandId,brandLogo);
    }
}
