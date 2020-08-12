package com.kyj.cooltiger.product.service.impl;

import com.kyj.cooltiger.common.excep.MyException;
import com.kyj.cooltiger.feign.product.vo.ProductCategoryAddReqVo;
import com.kyj.cooltiger.product.entity.ProductCategory;
import com.kyj.cooltiger.product.mapper.ProductCategoryMapper;
import com.kyj.cooltiger.product.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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
     * 添加商品分类信息
     *
     * @param parentId      分类父ID
     * @param categoryLists 分类信息
     */
    @Override
    public void addProductCategory(Integer parentId, List<ProductCategoryAddReqVo> categoryLists) {
        //判断名字是否有重复
        List<String> nameList = new ArrayList<>();
        for (ProductCategoryAddReqVo categoryAddReqVo : categoryLists) {
            nameList.add(categoryAddReqVo.getCategoryName());
        }
        List<ProductCategory> categoryList = productCategoryMapper.getProductCategoryListByParentId(parentId);
        for (ProductCategory category : categoryList) {
            nameList.add(category.getCategoryName());
        }
        Set<String> nameSet = new HashSet<>(nameList);
        if (nameSet.size() < nameList.size()) {
            throw new MyException("CATEGOTY_NAME_NOT_REPEAT", "类别名称不能重复");
        }
        //批量插入
        List<ProductCategory> productCategories = new ArrayList<>();
        ProductCategory productCategory = null;
        for (ProductCategoryAddReqVo categoryAddReqVo : categoryLists) {
            productCategory = new ProductCategory();
            productCategory.setCategoryName(categoryAddReqVo.getCategoryName());
            productCategory.setParentId(parentId);
            productCategory.setLogoUrl(categoryAddReqVo.getLogoUrl());
            productCategories.add(productCategory);
        }
        int count = productCategoryMapper.batchAddProductCategory(productCategories);
    }

    /**
     * 查询商品分类列表信息
     *
     * @param parentId 分类父ID
     * @return
     */
    @Override
    public Map<String, Object> getProductCategoryList(Integer parentId) {
        List<ProductCategory> productCategories = productCategoryMapper.getProductCategoryListByParentId(parentId);
        HashMap<String, Object> res = new HashMap<>();
        res.put("data", productCategories);
        return res;
    }

    /**
     * 修改商品分类
     *
     * @param categoryId 分类ID
     * @param category   分类信息
     * @return
     */
    @Override
    public void updateProductCategory(Integer categoryId, ProductCategoryAddReqVo category) {
        ProductCategory productCategory = productCategoryMapper.getProductCategoryListByCategoryId(categoryId);
        if (productCategory == null) {
            throw new MyException("CATEGORY_INFO_NOT_EXIST", "分类信息不存在");
        }
        int count = productCategoryMapper.getProductCategoryCountByCategoryId(category.getCategoryName());
        if(!productCategory.getCategoryName().equals(category.getCategoryName()) && count > 0){
            throw new MyException("CATEGOTY_NAME_IS_EXIST", "类别名称已存在");
        }
        productCategory.setCategoryName(category.getCategoryName());
        productCategory.setLogoUrl(category.getLogoUrl());
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
        ProductCategory productCategory = productCategoryMapper.getProductCategoryListByCategoryId(categoryId);
        if (productCategory == null) {
            throw new MyException("CATEGORY_INFO_NOT_EXIST", "分类信息不存在");
        }
        productCategoryMapper.delProductCategory(categoryId);
    }
}