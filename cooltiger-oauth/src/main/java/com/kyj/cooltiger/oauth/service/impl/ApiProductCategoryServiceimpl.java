package com.kyj.cooltiger.oauth.service.impl;

import com.kyj.cooltiger.oauth.dao.ProductCategoryDao;
import com.kyj.cooltiger.oauth.entity.ProductCategoryVo;
import com.kyj.cooltiger.oauth.service.ApiProductCategoryService;
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
