package com.kyj.cooltiger.cooltigeroauth.service;

import com.kyj.cooltiger.cooltigeroauth.entity.CollectVo;

import java.util.List;
import java.util.Map;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/8/10 11:08
 */
public interface CollectService {

    /**
     * 查询收藏店铺列表
     * @param map
     * @return
     */
    List<CollectVo> collectlist(Map<String,Object> map);

    /**
     * 收藏店铺
     * @param map
     * @return
     */
    boolean addcollect(Map<String,Object> map);

    /**
     * 查询用户店铺关注
     * @param map
     * @return
     */
    CollectVo  querycollect(Map<String,Object> map);

    /**
     * 取消店铺收藏
     * @param collectVo
     * @return
     */
    boolean  collectremove(CollectVo collectVo);


}
