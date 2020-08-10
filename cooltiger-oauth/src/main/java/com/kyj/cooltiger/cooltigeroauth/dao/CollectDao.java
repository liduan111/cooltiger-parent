package com.kyj.cooltiger.cooltigeroauth.dao;

import com.kyj.cooltiger.cooltigeroauth.entity.CollectVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/8/10 11:10
 */
@Mapper
public interface CollectDao {
    /**
     * 查询店铺收藏列表
     * @param map
     * @return
     */
    List<CollectVo> collectlist(Map<String, Object> map);

    /**
     * 用户店铺收藏
     * @param collectVo
     * @return
     */
    int addcollect(CollectVo collectVo);

    /**
     * 根据usercode,storeid查询用户关注的店铺
     * @param userCode
     * @param codeId
     * @return
     */
    CollectVo querycollect(@Param("userCode") Long userCode,@Param("codeId") Integer codeId);

    /**
     * 取消
     * @param collectVo
     * @return
     */
    int collectremove(@Param("collectVo") CollectVo collectVo);
}
