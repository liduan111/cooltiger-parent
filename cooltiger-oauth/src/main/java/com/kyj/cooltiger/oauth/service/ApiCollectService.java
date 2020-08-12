package com.kyj.cooltiger.oauth.service;

import com.kyj.cooltiger.oauth.entity.CollectVo;
import com.kyj.cooltiger.oauth.entity.GoodsCollectVo;

import java.util.List;
import java.util.Map;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/8/10 11:08
 */
public interface ApiCollectService {

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

    /**
     * 商品收藏列表
     * @param map
     * @return
     */
    List<GoodsCollectVo> goodscollectlist(Map<String,Object> map);

    /**
     * 收藏商品
     * @param map
     * @return
     */
    boolean  goodscollectsave(Map<String,Object> map);

    /**
     * 查询用户关注的商品
     * @param map
     * @return
     */
    GoodsCollectVo querygoodscollect(Map<String,Object> map);

    /**
     * 取消商品收藏
     * @param goodsCollectVo
     * @return
     */
    boolean canselgoodscollect(GoodsCollectVo goodsCollectVo);

    /**
     * 根据用户查询收藏的商品或店铺的个数
     * @param userCode
     * @param
     * @return
     */
    CollectVo queryusercodenum(Long userCode);

    /**
     * 根据用户查询商品收藏个数
     * @param userCode
     * @return
     */
    GoodsCollectVo  querygoodsusercode(Long userCode);



}
