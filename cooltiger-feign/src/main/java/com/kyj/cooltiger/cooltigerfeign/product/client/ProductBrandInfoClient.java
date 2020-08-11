package com.kyj.cooltiger.cooltigerfeign.product.client;

import com.kyj.cooltiger.cooltigercommon.utils.Result;
import com.kyj.cooltiger.cooltigerfeign.product.vo.ProductBrandInfoReqVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author liduan
 * Description: 商品品牌信息Client
 * date: 2020/8/11 14:49
 */
@FeignClient(name = "Product-Service")
@RequestMapping("/product/productBrandInfo")
public interface ProductBrandInfoClient {

    /**
     * 添加品牌信息
     * @param productBrandInfoReqVo
     * @return
     */
    @RequestMapping(value = "/addProductBrandInfo",method = {RequestMethod.POST})
    public Result addProductBrandInfo(@RequestBody ProductBrandInfoReqVo productBrandInfoReqVo);

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
            @RequestParam(value = "keyword",required = false) String keyword);
}
