package com.kyj.cooltiger.cooltigerfeign.product.client;

import com.kyj.cooltiger.cooltigercommon.utils.Result;
import com.kyj.cooltiger.cooltigerfeign.product.vo.ProductCategoryAddReqVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author liduan
 * Description: 商品类别Client
 * date: 2020/8/10 11:30
 */
@FeignClient(name = "Product-Service")
@RequestMapping("/product/productCategory")
public interface ProductCategoryClient {

    /**
     * 添加商品分类
     * @param parentId 分类父ID
     * @param categoryLists 分类信息
     * @return
     */
    @RequestMapping(value = "/addProductCategory",method = {RequestMethod.POST})
    public Result addProductCategory(
            @RequestParam(value = "parent_id",defaultValue = "0") Integer parentId,
            @RequestBody List<ProductCategoryAddReqVo> categoryLists);

    /**
     * 查询商品分类列表信息
     * @param parentId 分类父ID
     * @return
     */
    @RequestMapping(value = "/productCategoryList/{parent_id}",method = {RequestMethod.GET})
    public Result productCategoryList(
            @PathVariable("parent_id") Integer parentId);

    /**
     * 修改商品分类
     * @param categoryId 分类ID
     * @param category 分类信息
     * @return
     */
    @RequestMapping(value = "/updateProductCategory",method = {RequestMethod.PUT})
    public Result updateProductCategory(
            @RequestParam(value = "category_id") Integer categoryId,
            @RequestBody ProductCategoryAddReqVo category);

    /**
     * 删除商品分类信息
     * @param categoryId 分类ID
     * @return
     */
    @RequestMapping(value = "/delProductCategory",method = {RequestMethod.DELETE})
    public Result delProductCategory(
            @RequestParam(value = "category_id") Integer categoryId);
}
