package com.kyj.cooltiger.oauth.service;

import com.kyj.cooltiger.oauth.entity.SearchRecordEntity;

import java.util.List;
import java.util.Map;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/9/7 11:50
 */
public interface SearchRecordService {

    List<SearchRecordEntity>  queryList(Map<String,Object> param);

    void deleteRecord(Long userId);

    SearchRecordEntity queryObject(Integer Id);

    int queryTotal(Map<String, Object> map);

    boolean save(SearchRecordEntity searchRecordEntity);

    boolean update(SearchRecordEntity searchRecordEntity);

    void delete(Integer id);

    void deleteBatch(Integer[] ids);
}
