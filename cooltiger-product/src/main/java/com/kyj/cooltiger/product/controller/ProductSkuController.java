package com.kyj.cooltiger.product.controller;

import com.kyj.cooltiger.common.utils.DescartesUtils;
import com.kyj.cooltiger.common.utils.Result;
import com.kyj.cooltiger.feign.product.client.ProductSkuClient;
import com.kyj.cooltiger.feign.product.vo.ProductSkuReqVo;
import com.kyj.cooltiger.feign.product.vo.ProductSpecReqVo;
import com.kyj.cooltiger.product.entity.ProductSpecValue;
import com.kyj.cooltiger.product.service.ProductSkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author liduan
 * Description: 商品sku controller
 * date: 2020/9/8 13:31
 */
@RestController
@RequestMapping("/product/productSku")
public class ProductSkuController implements ProductSkuClient {

    @Autowired
    private ProductSkuService productSkuService;

    /**
     * 获取商品sku信息
     *
     * @param skuId skuID
     * @return
     */
    @RequestMapping(value = "/getProductSku", method = {RequestMethod.GET})
    public Result getProductSku(
            @RequestParam("sku_id") Integer skuId) {
        Map<String, Object> res = productSkuService.getProductSku(skuId);
        return Result.success(res.get("data"));
    }

    /**
     * 获取商品sku列表
     *
     * @param productId 商品ID
     * @return
     */
    @RequestMapping(value = "/getProductSkuList", method = {RequestMethod.GET})
    public Result getProductSkuList(@RequestParam("product_id") Integer productId) {
        Map<String, Object> res = productSkuService.getProductSkuList(productId);
        return Result.success(res.get("data"));
    }

    /**
     * 添加商品规格
     *
     * @param productId        商品ID
     * @param productSpecReqVo 商品规格参数
     * @return
     */
    @RequestMapping(value = "/addProductSpec", method = {RequestMethod.POST})
    public Result addProductSpec(
            @RequestParam("product_id") Integer productId,
            @RequestBody ProductSpecReqVo productSpecReqVo) {
        Map<String, Integer> res = productSkuService.addProductSpec(productId, productSpecReqVo.getSpecs());
        //笛卡尔积生成规格值组合
        List<List<String>> list = new ArrayList<List<String>>();
        for (ProductSpecReqVo.Spec specs : productSpecReqVo.getSpecs()) {
            list.add(specs.getSpecValues());
        }
        List<List<String>> resultList = new ArrayList<List<String>>();
        DescartesUtils.descartes(list, resultList, 0, new ArrayList<String>());
        //返回信息
        List<ProductSkuReqVo> resList = new ArrayList<>();
        ProductSkuReqVo productSkuReqVo = null;
        for (List<String> valuesList : resultList){
            productSkuReqVo = new ProductSkuReqVo();
            StringBuilder specValueIds = new StringBuilder();
            StringBuilder specValues = new StringBuilder();
            for (String value : valuesList){
                specValues.append(";").append(value);
                specValueIds.append(",").append(res.get(value));
            }
            productSkuReqVo.setSpecValueIds(specValueIds.substring(1).toString());
            productSkuReqVo.setSpecValues(specValues.substring(1).toString());
        }
        if (productSpecReqVo.getSkus() != null || !productSpecReqVo.getSkus().isEmpty()){
            for (ProductSkuReqVo skuReqVo : productSpecReqVo.getSkus()){
                for (ProductSkuReqVo resVo : resList){
                    if (skuReqVo.getSpecValues().equals(resVo.getSpecValues())){
                        resVo.setPicUrl(skuReqVo.getPicUrl());
                        resVo.setSalePrice(skuReqVo.getSalePrice());
                        resVo.setStock(skuReqVo.getStock());
                        resVo.setWeight(skuReqVo.getWeight());
                        resVo.setDistriType(skuReqVo.getDistriType());
                        resVo.setDistriValue(skuReqVo.getDistriValue());
                    }
                }
            }
        }
        return Result.success(resList);
    }

    /**
     * 添加商品Sku信息
     *
     * @param productId        商品ID
     * @param productSkuReqVos 商品Sku信息
     * @return
     */
    @RequestMapping(value = "/addProductSkuInfo", method = {RequestMethod.POST})
    public Result addProductSkuInfo(
            @RequestParam("product_id") Integer productId,
            @RequestBody List<ProductSkuReqVo> productSkuReqVos) {
        productSkuService.addProductSkuInfo(productId, productSkuReqVos);
        return Result.success();
    }
}
