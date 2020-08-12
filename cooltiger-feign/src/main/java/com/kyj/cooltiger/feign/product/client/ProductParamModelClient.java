package com.kyj.cooltiger.feign.product.client;

import com.kyj.cooltiger.common.utils.Result;
import com.kyj.cooltiger.feign.product.vo.ProductParamModelReqVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author liduan
 * Description: 商品参数模板Client
 * date: 2020/8/12 16:52
 */
@FeignClient(name = "Product-Service")
@RequestMapping("/product/productParamModel")
public interface ProductParamModelClient {

    /**
     * 添加商品参数模板
     *
     * @param categoryId
     * @param paramModelReqVos
     * @return
     */
    @RequestMapping(value = "/addProductParamModel", method = {RequestMethod.POST})
    public Result addProductParamModel(
            @RequestParam("category_id") Integer categoryId,
            @RequestBody List<ProductParamModelReqVo> paramModelReqVos);

}