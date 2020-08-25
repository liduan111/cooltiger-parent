package com.kyj.cooltiger.product.mapper;

import com.kyj.cooltiger.product.entity.ProductCategory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liduan
 * Description: 商品分类mapper
 * date: 2020/8/10 13:17
 */
@Mapper
public interface ProductCategoryMapper {

    /**
     * 根据分类名称查询分类个数
     *
     * @param categoryName
     * @return
     */
    public int getProductCategoryCountByCategoryName(@Param("categoryName") String categoryName);

    /**
     * 添加商品分类
     *
     * @param productCategory
     * @return
     */
    public int addProductCategory(@Param("productCategory") ProductCategory productCategory);

    /**
     * 根据分类父ID或分类等级查询商品分类列表信息
     *
     * @param categoryParentId
     * @param categoryLevel
     * @return
     */
    public List<ProductCategory> getProductCategoryListByParentId$CategoryLevel(
            @Param("categoryParentId") Integer categoryParentId,
            @Param("categoryLevel") Integer categoryLevel);

    /**
     * 根据分类ID查询分类信息
     *
     * @param categoryId
     * @return
     */
    public ProductCategory getProductCategoryByCategoryId(@Param("categoryId") Integer categoryId);

    /**
     * 修改商品分类信息
     *
     * @param productCategory
     */
    public void updateProductCategory(@Param("productCategory") ProductCategory productCategory);

    /**
     * 删除商品分类信息
     *
     * @param categoryId 分类ID
     * @return
     */
    public void delProductCategory(@Param("categoryId") Integer categoryId);

    /**
     * 根据名称查询分类信息个数
     *
     * @param categoryName 分类名称
     * @return
     */
    public int getProductCategoryCountByCategoryId(@Param("categoryName") String categoryName);

}
