package com.kyj.cooltiger.oauth.service.impl;

import com.kyj.cooltiger.oauth.dao.SearchRecordDao;
import com.kyj.cooltiger.oauth.entity.SearchRecordEntity;
import com.kyj.cooltiger.oauth.service.SearchRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/9/7 11:51
 */
@Service
public class SearchRecordServiceImpl implements SearchRecordService{

    @Autowired
    private SearchRecordDao searchRecordDao;

    /**
     * 查询
     * @param param
     * @return
     */
    @Override
    public List<SearchRecordEntity> queryList(Map<String, Object> param) {
        return searchRecordDao.queryList(param);
    }

    /**
     * 删除
     * @param userId
     */
    @Override
    public void deleteRecord(Long userId) {
         searchRecordDao.deleteRecord(userId);
    }
    @Override
    public SearchRecordEntity queryObject(Integer Id) {
        return searchRecordDao.queryObject(Id);
    }
    @Override
    public int queryTotal(Map<String, Object> map) {
        return searchRecordDao.queryTotal(map);
    }
    @Override
    public boolean save(SearchRecordEntity searchRecordEntity) {
        SearchRecordEntity  searchRecord=searchRecordDao.querysearchrecord(searchRecordEntity.getKeyword(),searchRecordEntity.getUserId());
        if (searchRecord==null||searchRecord.equals("")) {
            int i = searchRecordDao.save(searchRecordEntity);
            if (i > 0) {
               return true;
        }else{
                int count= searchRecordDao.update(searchRecordEntity);
                if (count>0){
                return true;
                }
            }
        }
        return  false;
    }
    @Override
    public boolean update(SearchRecordEntity searchRecordEntity) {
        int count= searchRecordDao.update(searchRecordEntity);
        if (count>0){
            return true;
        }
        return  false;
    }
    @Override
    public void delete(Integer id) {
        searchRecordDao.delete(id);
    }
    @Override
    public void deleteBatch(Integer[] ids) {
        searchRecordDao.deleteBatch(ids);
    }
}
