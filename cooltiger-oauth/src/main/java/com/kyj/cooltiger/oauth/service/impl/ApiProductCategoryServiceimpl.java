package com.kyj.cooltiger.oauth.service.impl;

import com.kyj.cooltiger.oauth.dao.ProductCategoryDao;
import com.kyj.cooltiger.oauth.entity.ProductCategoryVo;
import com.kyj.cooltiger.oauth.service.ApiProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/8/6 13:26
 */
@Service
public class ApiProductCategoryServiceimpl implements ApiProductCategoryService {

    @Autowired
    private ProductCategoryDao productCategoryDao;

    /**
     * 首页分类
     * @return
     */
    @Override
    public List<ProductCategoryVo> indexcategory() {
        return productCategoryDao.indexcategory();
    }

    /**
     * 查询子分类
     * @return
     */
    @Override
    public List<ProductCategoryVo> querycategorylist(Map<String,Object> map) {
        return productCategoryDao.querycategorylist(map);
    }

    /**
     * 查询父分类
     * @return
     */
    @Override
    public List<ProductCategoryVo> categorylist() {
        return productCategoryDao.categorylist();
    }
}
