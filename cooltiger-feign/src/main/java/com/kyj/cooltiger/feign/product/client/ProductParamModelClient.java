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
public interface ProductParamModelClient {

    /**
     * 添加商品参数模板
     *
     * @param categoryId
     * @param paramModelReqVos
     * @return
     */
    @RequestMapping(value = "/product/productParamModel/addProductParamModel", method = {RequestMethod.POST})
    public Result addProductParamModel(
            @RequestParam("category_id") Integer categoryId,
            @RequestBody List<ProductParamModelReqVo> paramModelReqVos);

    /**
     * 查询商品参数模板
     *
     * @param categoryId
     * @return
     */
    @RequestMapping(value = "/product/productParamModel/getProductParamModel", method = {RequestMethod.GET})
    public Result getProductParamModel(
            @RequestParam("category_id") Integer categoryId);

    /**
     * 批量删除商品模板参数
     *
     * @param paramIds 参数ID（多个用,分隔）
     * @return
     */
    @RequestMapping(value = "/product/productParamModel/batchDelProductModelParam",method = {RequestMethod.DELETE})
    public Result batchDelProductModelParam(@RequestParam("param_ids") String paramIds);

}
