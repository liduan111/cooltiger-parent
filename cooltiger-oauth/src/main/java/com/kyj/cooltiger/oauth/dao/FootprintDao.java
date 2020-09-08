package com.kyj.cooltiger.oauth.dao;

import com.kyj.cooltiger.oauth.entity.FootprintEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/9/4 10:18
 */
@Mapper
public interface FootprintDao {
    /**
     * 足迹列表查询
     * @param map
     * @return
     */
    List<FootprintEntity> footprintlist(Map<String, Object> map);

    /**
     * 删除足迹
     * @param map
     */
    int footprintdelete(Map<String, Object> map);

    /**
     * 根据用户id和商品id查询是否有该商品
     * @return
     */
    FootprintEntity  selectgoodfootprint(@Param("userId") Long userId, @Param("goodsId") Integer goodsId);

    /**
     * 添加
     * @param footprint
     * @return
     */
    int  footprintsave(FootprintEntity footprint);

    /**
     * 修改
     * @param footprint
     * @return
     */
    int  footprintupdate(@Param("footprint") FootprintEntity footprint);
}
