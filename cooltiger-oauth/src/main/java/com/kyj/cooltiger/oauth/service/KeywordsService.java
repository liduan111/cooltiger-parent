package com.kyj.cooltiger.oauth.service;

import com.kyj.cooltiger.oauth.entity.KeywordsEntity;

import java.util.List;
import java.util.Map;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/9/7 11:59
 */
public interface KeywordsService {

    List<KeywordsEntity>  queryList(Map<String,Object> param);

    List<Map>  hotKeywordList(Map<String, Object> map);

    KeywordsEntity queryObject(Integer id);

    int queryTotal(Map<String, Object> map);

    void save(KeywordsEntity keywordsEntity);

    void update(KeywordsEntity keywordsEntity);

    void delete(Integer id);

    void deleteBatch(Integer[] ids);
}
