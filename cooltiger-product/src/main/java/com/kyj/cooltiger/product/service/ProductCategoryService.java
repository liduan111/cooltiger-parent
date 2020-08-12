package com.kyj.cooltiger.product.service;

import com.kyj.cooltiger.feign.product.vo.ProductCategoryAddReqVo;

import java.util.List;
import java.util.Map;

/**
 * @author liduan
 * Description: 商品分类service
 * date: 2020/8/10 13:14
 */
public interface ProductCategoryService {

    /**
     * 添加商品分类
     * @param parentId 分类父ID
     * @param categoryLists 分类信息
     */
    public void addProductCategory(Integer parentId,List<ProductCategoryAddReqVo> categoryLists);

    /**
     * 查询商品分类列表信息
     * @param parentId 分类父ID
     * @return
     */
    public Map<String, Object> getProductCategoryList(Integer parentId);

    /**
     * 修改商品分类
     * @param categoryId 分类ID
     * @param category 分类信息
     * @return
     */
    public void updateProductCategory(Integer categoryId, ProductCategoryAddReqVo category);

    /**
     * 删除商品分类信息
     * @param categoryId 分类ID
     * @return
     */
    public void delProductCategory(Integer categoryId);
}
