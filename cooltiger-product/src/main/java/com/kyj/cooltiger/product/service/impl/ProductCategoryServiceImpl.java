package com.kyj.cooltiger.product.service.impl;

import com.kyj.cooltiger.common.excep.MyException;
import com.kyj.cooltiger.product.entity.ProductCategory;
import com.kyj.cooltiger.product.mapper.ProductCategoryMapper;
import com.kyj.cooltiger.product.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author liduan
 * Description: 商品分类service实现类
 * date: 2020/8/10 13:15
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    /**
     * 添加商品分类
     *
     * @param categoryName     分类名称
     * @param categoryParentId 分类父ID
     * @param categoryLevel    分类等级
     * @param categoryLogoUrl  分类logoUrl
     */
    @Override
    public void addProductCategory(String categoryName, Integer categoryParentId, Integer categoryLevel, String categoryLogoUrl) {
        //判断名字是否有重复
        int count = productCategoryMapper.getProductCategoryCountByCategoryName(categoryName);
        if (count > 0) {
            throw new MyException("CATEGOTY_NAME_IS_EXIST", "类别名称已存在");
        }
        //添加分类信息
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName(categoryName);
        productCategory.setCategoryParentId(categoryParentId);
        productCategory.setCategoryLevel(categoryLevel);
        productCategory.setCategoryLogoUrl(categoryLogoUrl);
        productCategoryMapper.addProductCategory(productCategory);
    }

    /**
     * 查询商品分类列表信息
     *
     * @param categoryParentId 父分类ID(0:一级分类）
     * @param categoryLevel    分类等级（0-一级分类1-二级分类2-三级分类）
     * @return
     */
    @Override
    public Map<String, Object> getProductCategoryList(Integer categoryParentId, Integer categoryLevel) {
        List<ProductCategory> productCategories = productCategoryMapper.getProductCategoryListByParentId$CategoryLevel(categoryParentId, categoryLevel);
        HashMap<String, Object> res = new HashMap<>();
        res.put("data", productCategories);
        return res;
    }

    /**
     * 修改商品分类
     *
     * @param categoryId      分类ID
     * @param categoryName    分类名称
     * @param categoryLogoUrl 分类logoUrl
     * @return
     */
    @Override
    public void updateProductCategory(Integer categoryId, String categoryName, String categoryLogoUrl) {
        ProductCategory productCategory = productCategoryMapper.getProductCategoryByCategoryId(categoryId);
        if (productCategory == null) {
            throw new MyException("CATEGORY_INFO_NOT_EXIST", "类别信息不存在");
        }
        int count = productCategoryMapper.getProductCategoryCountByCategoryName(categoryName);
        if (!productCategory.getCategoryName().equals(categoryName) && count > 0) {
            throw new MyException("CATEGOTY_NAME_IS_EXIST", "类别名称已存在");
        }
        productCategory.setCategoryName(categoryName);
        productCategory.setCategoryLogoUrl(categoryLogoUrl);
        productCategoryMapper.updateProductCategory(productCategory);
    }

    /**
     * 删除商品分类信息
     *
     * @param categoryId 分类ID
     * @return
     */
    @Override
    public void delProductCategory(Integer categoryId) {
        productCategoryMapper.delProductCategory(categoryId);
    }

    /**
     * 根据分类ID查询分类信息
     *
     * @param categoryId 分类ID
     * @return
     */
    @Override
    public ProductCategory getProductCategoryByCategoryId(Integer categoryId) {
        ProductCategory productCategory = productCategoryMapper.getProductCategoryByCategoryId(categoryId);
        if (productCategory == null) {
            throw new MyException("CATEGORY_INFO_NOT_EXIST", "分类信息不存在");
        }
        return productCategory;
    }
}
