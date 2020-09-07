package com.kyj.cooltiger.oauth.service.impl;

import com.kyj.cooltiger.oauth.dao.KeywordsDao;
import com.kyj.cooltiger.oauth.entity.KeywordsEntity;
import com.kyj.cooltiger.oauth.service.KeywordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/9/7 12:00
 */
@Service
public class KeywordsServiceImpl implements KeywordsService {
    @Autowired
    private KeywordsDao keywordsDao;

    @Override
    public List<KeywordsEntity> queryList(Map<String, Object> param) {
        return keywordsDao.queryList(param);
    }

    @Override
    public List<Map> hotKeywordList(Map<String, Object> map) {
        return keywordsDao.hotKeywordList(map);
    }

    @Override
    public KeywordsEntity queryObject(Integer id) {
        return keywordsDao.queryObject(id);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return keywordsDao.queryTotal(map);
    }

    @Override
    public void save(KeywordsEntity keywordsEntity) {
        keywordsDao.save(keywordsEntity);
    }

    @Override
    public void update(KeywordsEntity keywordsEntity) {
        keywordsDao.update(keywordsEntity);
    }

    @Override
    public void delete(Integer id) {
        keywordsDao.delete(id);
    }

    @Override
    public void deleteBatch(Integer[] ids) {
        keywordsDao.deleteBatch(ids);
    }
}
