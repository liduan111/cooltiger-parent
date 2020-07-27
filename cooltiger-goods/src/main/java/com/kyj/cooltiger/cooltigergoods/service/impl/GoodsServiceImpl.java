package com.kyj.cooltiger.cooltigergoods.service.impl;

import com.kyj.cooltiger.cooltigergoods.mapper.GoodsMapper;
import com.kyj.cooltiger.cooltigergoods.model.Goods;
import com.kyj.cooltiger.cooltigergoods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public Goods getGoodsById(Integer id) {
        if(id.equals(null)){

        }
        Goods goods = goodsMapper.getGoodsById(id);
        return goods;
    }
}
