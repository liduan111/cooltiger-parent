package com.kyj.cooltiger.oauth.dao;

import com.kyj.cooltiger.oauth.entity.ProductCategoryVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/8/6 13:27
 */
@Mapper
public interface ProductCategoryDao {

    List<ProductCategoryVo> querycategorylist();
}