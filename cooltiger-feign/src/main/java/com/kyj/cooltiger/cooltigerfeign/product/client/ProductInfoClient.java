package com.kyj.cooltiger.cooltigerfeign.product.client;

import com.kyj.cooltiger.cooltigercommon.utils.Result;
import com.kyj.cooltiger.cooltigerfeign.product.vo.ProductInfoAddReqVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author liduan
 * Description: 商品信息ProductInfo FeignClient接口
 * date: 2020/7/28 14:44
 */
@FeignClient(name = "Product-Service")
public interface ProductInfoClient {

    /**
     * 测试方法
     * @param id
     * @return
     */
    @RequestMapping(value = "/hello/{id}",method = {RequestMethod.GET})
    public Result hello(@PathVariable("id") String id);

    /**
     * 获取店铺商品列表
     * @param storeId 店铺ID
     * @param pageNo 当前页
     * @param pageSize 分页单位
     * @param categoryId 分类ID
     * @param keyword 搜索关键字
     * @return
     */
    @RequestMapping(value = "/productInfo/getProductInfoList/{storeId}",method = {RequestMethod.GET})
    public Result getProductInfoList(
            @PathVariable("storeId") String storeId,
            @RequestParam(value = "pageNo",defaultValue = "1") Integer pageNo,
            @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize,
            @RequestParam(value = "categoryId",required = false) Integer categoryId,
            @RequestParam(value = "keyword",required = false) String keyword);

    /**
     * 添加商品信息
     * @param storeId 店铺ID
     * @param productInfoAddReqVo 商品信息
     * @return
     */
    @RequestMapping(value = "/productInfo/addProductInfo/{storeId}",method = {RequestMethod.POST})
    public Result addProductInfo(
            @PathVariable("storeId") String storeId,
            @RequestParam("productInfoAddReqVo") ProductInfoAddReqVo productInfoAddReqVo);
}