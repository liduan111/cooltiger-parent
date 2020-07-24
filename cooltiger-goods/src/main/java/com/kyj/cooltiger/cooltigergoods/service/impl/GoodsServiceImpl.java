package com.kyj.cooltiger.cooltigergoods.service.impl;

import com.kyj.cooltiger.cooltigergoods.service.GoodsService;
import org.springframework.stereotype.Service;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Override
    public String getGoodsById(String id) {
        String res = "error";
        if (id.equals("1")){
            res = "success";
        }
        return res;
    }
}
