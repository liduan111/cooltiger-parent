package com.kyj.cooltiger.oauth.dao;

import com.kyj.cooltiger.oauth.entity.CollectVo;
import com.kyj.cooltiger.oauth.entity.GoodsCollectVo;
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
    CollectVo querycollect(@Param("userCode") Long userCode,@Param("codeId") Integer codeId,@Param("deleted") Integer deleted);

    /**
     * 取消
     * @param collectVo
     * @return
     */
    int collectremove(@Param("collectVo") CollectVo collectVo);

    /**
     * 查询商品收藏列表
     * @param map
     * @return
     */
    List<GoodsCollectVo> goodscollectlist(Map<String, Object> map);

    /**
     * 收藏商品
     * @param goodsCollectVo
     * @return
     */
    int  goodscollectsave(GoodsCollectVo goodsCollectVo);

    /**
     *查询用户查询收藏商品
     * @param userCode
     * @param codeId
     * @return
     */
    GoodsCollectVo querygoodscollect(@Param("userCode") Long userCode,@Param("codeId") Integer codeId,@Param("deleted") Integer deleted);

    /**
     * 取消商品收藏
     * @param goodsCollectVo1
     * @return
     */
    int canselgoodscollect(@Param("goodsCollectVo1") GoodsCollectVo goodsCollectVo1);
}
