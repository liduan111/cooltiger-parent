package com.kyj.cooltiger.product.service;

import com.kyj.cooltiger.product.entity.ProductCategory;

import java.util.Map;

/**
 * @author liduan
 * Description: 商品分类service
 * date: 2020/8/10 13:14
 */
public interface ProductCategoryService {

    /**
     * 添加商品分类
     *
     * @param categoryName     分类名称
     * @param categoryParentId 分类父ID
     * @param categotyLevel    分类等级
     * @param categoryLogoUrl  分类logoUrl
     */
    public void addProductCategory(String categoryName, Integer categoryParentId, Integer categotyLevel, String categoryLogoUrl);

    /**
     * 查询商品分类列表信息
     *
     * @param categoryParentId 父分类ID(0:一级分类）
     * @param categoryLevel    分类等级（0-一级分类1-二级分类2-三级分类）
     * @return
     */
    public Map<String, Object> getProductCategoryList(Integer categoryParentId, Integer categoryLevel);

    /**
     * 修改商品分类
     *
     * @param categoryId      分类ID
     * @param categoryName    分类名称
     * @param categoryLogoUrl 分类logoUrl
     * @return
     */
    public void updateProductCategory(Integer categoryId, String categoryName, String categoryLogoUrl);

    /**
     * 删除商品分类信息
     *
     * @param categoryId 分类ID
     * @return
     */
    public void delProductCategory(Integer categoryId);

    /**
     * 根据分类ID查询分类信息
     *
     * @param categoryId 分类ID
     * @return
     */
    public ProductCategory getProductCategoryByCategoryId(Integer categoryId);
}
