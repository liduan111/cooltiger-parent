package com.kyj.cooltiger.oauth.service;

import com.kyj.cooltiger.oauth.entity.FootprintEntity;

import java.util.List;
import java.util.Map;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/9/4 10:16
 */
public interface FootprintService {

    /**
     * 足迹列表
     * @param map
     * @return
     */
    List<FootprintEntity>  footprintlist(Map<String, Object> map);

    void footprintdelete(Map<String, Object> map);


}
