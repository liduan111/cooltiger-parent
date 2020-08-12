package com.kyj.cooltiger.oauth.dao;

import com.kyj.cooltiger.oauth.entity.GoodsVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/8/7 10:23
 */
@Mapper
public interface GoodsDao {
    /**
     * 查询商品列表
     * @param param2
     * @return
     */
    List<GoodsVo> goodslist(Map<String, Object> param2);

}
