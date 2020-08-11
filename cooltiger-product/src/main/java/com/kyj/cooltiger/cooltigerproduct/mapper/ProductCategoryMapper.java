package com.kyj.cooltiger.cooltigerproduct.mapper;

import com.kyj.cooltiger.cooltigerproduct.entity.ProductCategory;
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
     * 批量添加商品分类
     * @param productCategories
     * @return
     */
    public int batchAddProductCategory(@Param("productCategories") List<ProductCategory> productCategories);

    /**
     * 根据父ID查询商品分类列表信息
     * @param parentId
     * @return
     */
    public List<ProductCategory> getProductCategoryListByParentId(@Param("parentId") Integer parentId);

    /**
     * 根据分类ID查询分类信息
     * @param categoryId
     * @return
     */
    public ProductCategory getProductCategoryListByCategoryId(@Param("categoryId") Integer categoryId);

    /**
     * 修改商品分类信息
     * @param productCategory
     */
    public void updateProductCategory(@Param("productCategory") ProductCategory productCategory);

    /**
     * 删除商品分类信息
     * @param categoryId 分类ID
     * @return
     */
    public void delProductCategory(@Param("categoryId") Integer categoryId);

    /**
     * 根据名称查询分类信息个数
     * @param categoryName 分类名称
     * @return
     */
    public int getProductCategoryCountByCategoryId(@Param("categoryName") String categoryName);
}
