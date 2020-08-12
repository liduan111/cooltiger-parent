package com.kyj.cooltiger.oauth.service.impl;

import com.kyj.cooltiger.oauth.dao.GoodsDao;
import com.kyj.cooltiger.oauth.entity.GoodsVo;
import com.kyj.cooltiger.oauth.service.ApiGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/8/7 10:24
 */
@Service
public class ApiGoodsServiceimpl implements ApiGoodsService {

    @Autowired
    private GoodsDao goodsDao;

    @Override
    public List<GoodsVo> goodslist(Map<String, Object> param2) {
        return goodsDao.goodslist(param2);
    }
}
