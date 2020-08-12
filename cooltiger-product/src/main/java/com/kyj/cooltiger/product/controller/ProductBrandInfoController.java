package com.kyj.cooltiger.product.controller;

import com.kyj.cooltiger.common.utils.Result;
import com.kyj.cooltiger.feign.product.client.ProductBrandInfoClient;
import com.kyj.cooltiger.feign.product.vo.ProductBrandInfoReqVo;
import com.kyj.cooltiger.product.service.ProductBrandInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author liduan
 * Description: 商品品牌信息controller
 * date: 2020/8/11 14:50
 */
@RestController
@RequestMapping("/product/productBrandInfo")
public class ProductBrandInfoController implements ProductBrandInfoClient {

    @Autowired
    private ProductBrandInfoService productBrandInfoService;

    /**
     * 添加品牌信息
     *
     * @param productBrandInfoReqVo
     * @return
     */
    @Override
    @RequestMapping(value = "/addProductBrandInfo", method = {RequestMethod.POST})
    public Result addProductBrandInfo(@RequestBody ProductBrandInfoReqVo productBrandInfoReqVo) {
        productBrandInfoService.addProductBrandInfo(productBrandInfoReqVo);
        return Result.success();
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
            @RequestParam(value = "keyword", required = false) String keyword) {
        Map<String, Object> res = productBrandInfoService.getProductBrandInfoList(pageNo, pageSize, keyword);
        return Result.success(res);
    }

    /**
     * 修改商品品牌信息
     *
     * @param brandId
     * @param productBrandInfoReqVo
     * @return
     */
    @RequestMapping(value = "updateProductBrandInfo/{brand_id)", method = {RequestMethod.PUT})
    public Result updateProductBrandInfo(
            @PathVariable("brand_id") Integer brandId,
            @RequestBody ProductBrandInfoReqVo productBrandInfoReqVo) {
        productBrandInfoService.updateProductBrandInfo(brandId, productBrandInfoReqVo);
        return Result.success();
    }

    /**
     * 删除品牌信息
     *
     * @param brandId
     * @return
     */
    @RequestMapping(value = "/delProductBrandInfo/{brand_id)", method = {RequestMethod.DELETE})
    public Result delProductBrandInfo(
            @PathVariable("brand_id") Integer brandId) {
        productBrandInfoService.delProductBrandInfo(brandId);
        return Result.success();
    }
}
