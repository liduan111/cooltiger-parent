package com.kyj.cooltiger.cooltigergoods.controller;

import com.kyj.cooltiger.cooltigergoods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/goods")
@RestController
public class GoodsController {
    
    @Autowired
    private GoodsService goodsService;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String getGoodsById(@PathVariable("id") String id){
        String goodsById = goodsService.getGoodsById(id);
        return "hello";
    }
}
