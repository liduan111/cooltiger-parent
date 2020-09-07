package com.kyj.cooltiger.oauth.dao;

import com.kyj.cooltiger.oauth.entity.KeywordsEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/9/7 12:01
 */
@Mapper
public interface KeywordsDao {

    List<Map> hotKeywordList(Map<String, Object> param);

    List<KeywordsEntity> queryList(Map<String, Object> param);

    int queryTotal(Map<String, Object> map);

    KeywordsEntity queryObject(@Param("Id") Integer Id);

    int delete(Object id);

    int deleteBatch(Object[] id);

    int save(KeywordsEntity keywordsEntity);

    int update (KeywordsEntity keywordsEntity);
}
