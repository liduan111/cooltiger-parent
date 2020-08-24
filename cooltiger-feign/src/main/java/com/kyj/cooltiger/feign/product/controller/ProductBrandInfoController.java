package com.kyj.cooltiger.feign.product.controller;

import com.kyj.cooltiger.common.utils.Result;
import com.kyj.cooltiger.feign.product.client.ProductBrandInfoClient;
import com.kyj.cooltiger.feign.product.vo.ProductBrandInfoReqVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author liduan
 * Description:
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
     * @param productBrandInfoReqVo
     * @return
     */
    @RequestMapping(value = "/addProductBrandInfo", method = {RequestMethod.POST})
    public Result addProductBrandInfo(@RequestBody ProductBrandInfoReqVo productBrandInfoReqVo){
        return productBrandInfoClient.addProductBrandInfo(productBrandInfoReqVo);
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
            @RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
            @RequestParam(value = "keyword", required = false) String keyword){
        return productBrandInfoClient.getProductBrandInfoList(pageNo,pageSize,keyword);
    }

    /**
     * 修改商品品牌信息
     *
     * @param brandId
     * @param productBrandInfoReqVo
     * @return
     */
    @RequestMapping(value = "updateProductBrandInfo/{brand_id}", method = {RequestMethod.PUT})
    public Result updateProductBrandInfo(
            @PathVariable("brand_id") Integer brandId,
            @RequestBody ProductBrandInfoReqVo productBrandInfoReqVo){
        return productBrandInfoClient.updateProductBrandInfo(brandId,productBrandInfoReqVo);
    }

    /**
     * 删除品牌信息
     *
     * @param brandId
     * @return
     */
    @RequestMapping(value = "/delProductBrandInfo/{brand_id}", method = {RequestMethod.DELETE})
    public Result delProductBrandInfo(
            @PathVariable("brand_id") Integer brandId){
        return productBrandInfoClient.delProductBrandInfo(brandId);
    }
}
