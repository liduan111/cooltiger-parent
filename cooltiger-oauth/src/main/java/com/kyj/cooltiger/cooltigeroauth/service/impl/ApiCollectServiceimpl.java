package com.kyj.cooltiger.cooltigeroauth.service.impl;

import com.kyj.cooltiger.cooltigercommon.utils.DateUtils;
import com.kyj.cooltiger.cooltigeroauth.dao.CollectDao;
import com.kyj.cooltiger.cooltigeroauth.entity.CollectVo;
import com.kyj.cooltiger.cooltigeroauth.entity.GoodsCollectVo;
import com.kyj.cooltiger.cooltigeroauth.service.ApiCollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/8/10 11:08
 */
@Service
public class ApiCollectServiceimpl implements ApiCollectService {

    @Autowired
    private CollectDao collectDao;

    /**
     * 用户取消商品收藏
     * @param goodsCollectVo
     * @return
     */
    @Override
    public boolean canselgoodscollect(GoodsCollectVo goodsCollectVo) {

        GoodsCollectVo goodsCollectVo1=new GoodsCollectVo();
        goodsCollectVo1.setDeleted(1);
        goodsCollectVo1.setCollectTime(DateUtils.getDates());
        goodsCollectVo1.setUpdateTime(DateUtils.getDates());
        goodsCollectVo1.setUserCode(goodsCollectVo.getUserCode());
        goodsCollectVo1.setCodeId(goodsCollectVo.getCodeId());
        if (goodsCollectVo1!=null||!goodsCollectVo1.equals("")){
            int i=collectDao.canselgoodscollect(goodsCollectVo1);
            if (i>0){
                return true;
            }
        }
        return false;
    }

    /**
     * 根据用户查询收藏商品
     * @param map
     * @return
     */
    @Override
    public GoodsCollectVo querygoodscollect(Map<String, Object> map) {
        Long userCode=Long.parseLong(map.get("userCode").toString());
        Integer codeId=Integer.valueOf(map.get("codeId").toString());
        Integer deleted=0;
        if (userCode==0||userCode.toString()==null){
            return null;
        }
        if (codeId==0||codeId.toString()==null){
            return null;
        }
        return collectDao.querygoodscollect(userCode,codeId,deleted);
    }

    /**
     * 用户商品收藏
     * @param map
     * @return
     */
    @Override
    public boolean goodscollectsave(Map<String, Object> map) {
        Long userCode=Long.parseLong(map.get("userCode").toString());
        Integer codeId=Integer.valueOf(map.get("codeId").toString());
        Integer deleted=1;
        if (userCode==0||userCode.toString()==null){
            return false;
        }
        if (codeId==0||codeId.toString()==null){
            return false;
        }
        GoodsCollectVo goodsCollect=collectDao.querygoodscollect(userCode,codeId,deleted);
        if (goodsCollect==null||goodsCollect.equals("")) {
            GoodsCollectVo goodsCollectVo = new GoodsCollectVo();
            goodsCollectVo.setUserCode(userCode);
            goodsCollectVo.setCodeId(codeId);
            goodsCollectVo.setDeleted(0);
            goodsCollectVo.setCodeType(2);
            goodsCollectVo.setCollectTime(DateUtils.getDates());
            goodsCollectVo.setCreateTime(DateUtils.getDates());
            if (goodsCollectVo != null || !goodsCollectVo.equals("")) {
                int i = collectDao.goodscollectsave(goodsCollectVo);
                if (i > 0) {
                    return true;
                }
            }
        }else {
            GoodsCollectVo goodsCollectVo1=new GoodsCollectVo();
            goodsCollectVo1.setDeleted(0);
            goodsCollectVo1.setCollectTime(DateUtils.getDates());
            goodsCollectVo1.setUpdateTime(DateUtils.getDates());
            goodsCollectVo1.setUserCode(goodsCollect.getUserCode());
            goodsCollectVo1.setCodeId(goodsCollect.getCodeId());
            if (goodsCollectVo1!=null||!goodsCollectVo1.equals("")){
                int i=collectDao.canselgoodscollect(goodsCollectVo1);
                if (i>0){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 商品收藏列表
     * @param map
     * @return
     */
    @Override
    public List<GoodsCollectVo> goodscollectlist(Map<String, Object> map) {
        return collectDao.goodscollectlist(map);
    }

    /**
     * 取消收藏店铺
     * @param collectVo
     * @return
     */
    @Override
    public boolean collectremove(CollectVo collectVo) {

        CollectVo  collectVo1=new CollectVo();
        //collectVo1.setId(collectVo.getId());
        collectVo1.setDeleted(1);
        collectVo1.setCollectTime(DateUtils.getDates());
        collectVo1.setUpdateTime(DateUtils.getDates());
        collectVo1.setUserCode(collectVo.getUserCode());
        collectVo1.setCodeId(collectVo.getCodeId());
        if(collectVo1!=null||!collectVo1.equals("")) {
            int i = collectDao.collectremove(collectVo1);
            if (i > 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查询用户关注店铺
     * @param map
     * @return
     */
    @Override
    public CollectVo querycollect(Map<String, Object> map) {
        Long userCode=Long.parseLong(map.get("userCode").toString());
        Integer codeId=Integer.valueOf(map.get("codeId").toString());
        Integer deleted=0;
        if (userCode==0||userCode.toString()==null){
            return null;
        }
        if (codeId==0||codeId.toString()==null){
            return null;
        }
        return collectDao.querycollect(userCode,codeId,deleted);
    }

    /**
     * 查询收藏店铺列表
     * @param map
     * @return
     */
    @Override
    public List<CollectVo> collectlist(Map<String, Object> map) {
        return collectDao.collectlist(map);
    }

    /**
     * 根据用户查询商品收藏个数
     * @param userCode
     * @return
     */
    @Override
    public GoodsCollectVo querygoodsusercode(Long userCode) {
        return collectDao.querygoodsusercode(userCode);
    }

    /**
     * 根据用户查询收藏店铺的个数
     * @param userCode
     * @return
     */
    @Override
    public CollectVo queryusercodenum(Long userCode) {
           return collectDao.queryusercodenum(userCode);
    }

    /**
     * 用户店铺收藏
     * @param map
     * @return
     */
    @Override
    public boolean addcollect(Map<String, Object> map) {

         Long userCode=Long.parseLong(map.get("userCode").toString());
         Integer codeId=Integer.valueOf(map.get("codeId").toString());
         Integer deleted=1;
            if (userCode==0||userCode.toString()==null){
                return false;
            }
            if (codeId==0||codeId.toString()==null){
                return false;
            }
         CollectVo collect= collectDao.querycollect(userCode,codeId,deleted);
            if(collect==null||collect.equals("")) {
                CollectVo collectVo = new CollectVo();
                collectVo.setUserCode(userCode);
                collectVo.setCodeId(codeId);
                collectVo.setCodeType(1);
                collectVo.setDeleted(0);
                collectVo.setCollectTime(DateUtils.getDates());
                collectVo.setCreateTime(DateUtils.getDates());
                if (collectVo == null || collectVo.equals("")) {
                    return false;
                }
                int i = collectDao.addcollect(collectVo);
                if (i > 0) {
                    return true;
                }
            }else {
                CollectVo  collectVo1=new CollectVo();
                collectVo1.setDeleted(0);
                collectVo1.setCollectTime(DateUtils.getDates());
                collectVo1.setUpdateTime(DateUtils.getDates());
                collectVo1.setUserCode(collect.getUserCode());
                collectVo1.setCodeId(collect.getCodeId());
                if(collectVo1!=null||!collectVo1.equals("")) {
                    int i = collectDao.collectremove(collectVo1);
                    if (i > 0) {
                        return true;
                    }
                }
            }
        return false;
    }
}
