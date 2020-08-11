package com.kyj.cooltiger.cooltigerproduct.controller;

import com.kyj.cooltiger.cooltigercommon.utils.Result;
import com.kyj.cooltiger.cooltigerfeign.product.client.ProductBrandInfoClient;
import com.kyj.cooltiger.cooltigerfeign.product.vo.ProductBrandInfoReqVo;
import com.kyj.cooltiger.cooltigerproduct.service.ProductBrandInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
     * @param productBrandInfoReqVo
     * @return
     */
    @Override
    @RequestMapping(value = "/addProductBrandInfo",method = {RequestMethod.POST})
    public Result addProductBrandInfo(@RequestBody ProductBrandInfoReqVo productBrandInfoReqVo){
        productBrandInfoService.addProductBrandInfo(productBrandInfoReqVo);
        return Result.success();
    }

    /**
     * 查询品牌列表信息
     * @param pageNo
     * @param pageSize
     * @param keyword
     * @return
     */
    @RequestMapping(value = "/getProductBrandInfoList",method = {RequestMethod.GET})
    public Result getProductBrandInfoList(
            @RequestParam(value = "pageNo",defaultValue = "1") Integer pageNo,
            @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize,
            @RequestParam(value = "keyword",required = false) String keyword){

        return Result.success();
    }
}
