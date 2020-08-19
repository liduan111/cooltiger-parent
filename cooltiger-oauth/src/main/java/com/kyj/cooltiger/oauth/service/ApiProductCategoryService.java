package com.kyj.cooltiger.oauth.service;

import com.kyj.cooltiger.oauth.entity.ProductCategoryVo;

import java.util.List;
import java.util.Map;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/8/6 13:25
 */
public interface ApiProductCategoryService {
    /**
     * 查询子分类
     * @return
     */
    List<ProductCategoryVo> querycategorylist(Map<String,Object> map);

    /**
     * 查询父分类
     * @return
     */
    List<ProductCategoryVo> categorylist();

}
