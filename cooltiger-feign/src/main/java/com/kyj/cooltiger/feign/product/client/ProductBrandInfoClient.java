package com.kyj.cooltiger.feign.product.client;

import com.kyj.cooltiger.common.utils.Result;
import com.kyj.cooltiger.feign.product.vo.ProductBrandInfoReqVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

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
     * @param productBrandInfoReqVo
     * @return
     */
    @RequestMapping(value = "/product/productBrandInfo/addProductBrandInfo", method = {RequestMethod.POST})
    public Result addProductBrandInfo(@RequestBody ProductBrandInfoReqVo productBrandInfoReqVo);

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
            @RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
            @RequestParam(value = "keyword", required = false) String keyword);

    /**
     * 修改商品品牌信息
     *
     * @param brandId
     * @param productBrandInfoReqVo
     * @return
     */
    @RequestMapping(value = "/product/productBrandInfoupdateProductBrandInfo/{brand_id}", method = {RequestMethod.PUT})
    public Result updateProductBrandInfo(
            @PathVariable("brand_id") Integer brandId,
            @RequestBody ProductBrandInfoReqVo productBrandInfoReqVo);

    /**
     * 删除品牌信息
     *
     * @param brandId
     * @return
     */
    @RequestMapping(value = "/product/productBrandInfo/delProductBrandInfo/{brand_id}", method = {RequestMethod.DELETE})
    public Result delProductBrandInfo(
            @PathVariable("brand_id") Integer brandId);
}
