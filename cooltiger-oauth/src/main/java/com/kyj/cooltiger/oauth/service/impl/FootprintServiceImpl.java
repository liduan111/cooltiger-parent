package com.kyj.cooltiger.oauth.service.impl;

import com.kyj.cooltiger.oauth.dao.FootprintDao;
import com.kyj.cooltiger.oauth.entity.FootprintEntity;
import com.kyj.cooltiger.oauth.service.FootprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/9/4 10:17
 */
@Service
public class FootprintServiceImpl implements FootprintService {

    @Autowired
    private FootprintDao footprintDao;

    /**
     * 足迹列表
     * @param map
     * @return
     */
    @Override
    public List<FootprintEntity> footprintlist(Map<String, Object> map) {
        return footprintDao.footprintlist(map);
    }

    /**
     *删除
     * @param map
     */
    @Override
    public void footprintdelete(Map<String, Object> map) {
        footprintDao.footprintdelete(map);
    }
}
