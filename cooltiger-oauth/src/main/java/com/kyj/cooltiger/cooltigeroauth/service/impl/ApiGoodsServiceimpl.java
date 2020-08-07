package com.kyj.cooltiger.cooltigeroauth.service.impl;

import com.kyj.cooltiger.cooltigeroauth.dao.GoodsDao;
import com.kyj.cooltiger.cooltigeroauth.entity.GoodsVo;
import com.kyj.cooltiger.cooltigeroauth.service.ApiGoodsService;
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
