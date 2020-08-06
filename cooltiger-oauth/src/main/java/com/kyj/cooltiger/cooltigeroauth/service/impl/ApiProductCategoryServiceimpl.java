package com.kyj.cooltiger.cooltigeroauth.service.impl;

import com.kyj.cooltiger.cooltigeroauth.dao.ProductCategoryDao;
import com.kyj.cooltiger.cooltigeroauth.entity.ProductCategoryVo;
import com.kyj.cooltiger.cooltigeroauth.service.ApiProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/8/6 13:26
 */
@Service
public class ApiProductCategoryServiceimpl implements ApiProductCategoryService {

    @Autowired
    private ProductCategoryDao productCategoryDao;


    @Override
    public List<ProductCategoryVo> querycategorylist() {
        return productCategoryDao.querycategorylist();
    }
}
