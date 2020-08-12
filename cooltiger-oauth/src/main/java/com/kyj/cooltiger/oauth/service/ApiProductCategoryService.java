package com.kyj.cooltiger.oauth.service;

import com.kyj.cooltiger.oauth.entity.ProductCategoryVo;

import java.util.List;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/8/6 13:25
 */
public interface ApiProductCategoryService {

    List<ProductCategoryVo> querycategorylist();

}
