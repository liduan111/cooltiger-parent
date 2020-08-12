package com.kyj.cooltiger.oauth.service;

import com.kyj.cooltiger.oauth.entity.GoodsVo;

import java.util.List;
import java.util.Map;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/8/7 10:23
 */
public interface ApiGoodsService {
    /**
     * 查询商品列表
     * @param param2
     * @return
     */
    List<GoodsVo> goodslist(Map<String,Object> param2);

}
