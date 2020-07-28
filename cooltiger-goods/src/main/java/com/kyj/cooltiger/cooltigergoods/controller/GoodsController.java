package com.kyj.cooltiger.cooltigergoods.controller;

import com.kyj.cooltiger.cooltigerfeign.clients.goods.GoodsCilent;
import com.kyj.cooltiger.cooltigergoods.model.Goods;
import com.kyj.cooltiger.cooltigergoods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/goods")
@RestController
public class GoodsController implements GoodsCilent {
    
    @Autowired
    private GoodsService goodsService;

    @RequestMapping(value = "/hello/{id}",method = {RequestMethod.GET})
    public String hello(@PathVariable("id") String id){
        //String res = goodsService.getGoodsById(id);
        return "hello";
    }

    @RequestMapping(value = "/getById/{id}",method = {RequestMethod.GET})
    public String getGoodsById(@PathVariable("id") Integer id){
        Goods goods = goodsService.getGoodsById(id);
        return goods.toString();
    }


}
