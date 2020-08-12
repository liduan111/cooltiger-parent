package com.kyj.cooltiger.oauth.service.impl;

import com.kyj.cooltiger.oauth.dao.ShopCartDao;
import com.kyj.cooltiger.oauth.entity.ShopCartVo;
import com.kyj.cooltiger.oauth.service.ApiShopCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/8/12 15:30
 */
@Service
public class ApiShopCartServiceimpl implements ApiShopCartService {

    @Autowired
    private ShopCartDao shopCartDao;


    @Override
    public List<ShopCartVo> shopcartlist(Map<String, Object> map) {
        return shopCartDao.shopcartlist(map);
    }
}
