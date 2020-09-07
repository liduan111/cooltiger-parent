package com.kyj.cooltiger.oauth.dao;

import com.kyj.cooltiger.oauth.entity.SearchRecordEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/9/7 11:54
 */
@Mapper
public interface SearchRecordDao {

    List<SearchRecordEntity> queryList(Map<String, Object> param);

    int deleteRecord(@Param("userId") Long userId);

    SearchRecordEntity queryObject(@Param("Id")Integer Id);

    int queryTotal(Map<String, Object> map);

    SearchRecordEntity  querysearchrecord(@Param("keyword") String keyword,@Param("userId") Long userId);

    int save(SearchRecordEntity searchRecordEntity);

    int update(SearchRecordEntity searchRecordEntity);

    int deleteBatch(Integer[] ids);

    int delete(@Param("Id") Integer Id);

}
