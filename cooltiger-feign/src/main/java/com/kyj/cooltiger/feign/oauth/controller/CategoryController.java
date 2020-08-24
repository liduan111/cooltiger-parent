package com.kyj.cooltiger.feign.oauth.controller;

import com.kyj.cooltiger.feign.oauth.client.CategoryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author liduan
 * Description:
 * date: 2020/8/24 14:38
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryClient categoryClient;

    /**
     * 商品分类查询
     * @return
     */
    @RequestMapping(value ="/categorylist",method = RequestMethod.GET)
    public  Object categorylist(@RequestBody Map<String,Object> map){
        return categoryClient.categorylist(map);
    }
}
