package com.kyj.cooltiger.oauth.dao;

import com.kyj.cooltiger.oauth.entity.ProductCategoryVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/8/6 13:27
 */
@Mapper
public interface ProductCategoryDao {
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

    /**
     *首页分类
     * @return
     */
    List<ProductCategoryVo> indexcategory();
}
