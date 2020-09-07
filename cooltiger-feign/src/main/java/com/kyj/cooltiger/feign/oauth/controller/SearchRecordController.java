package com.kyj.cooltiger.feign.oauth.controller;

import com.kyj.cooltiger.feign.oauth.client.SearchRecordClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/9/7 16:20
 */
@RestController
@RequestMapping("/api/search")
public class SearchRecordController {

    @Autowired
    private SearchRecordClient searchRecordClient;

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public Object index(@RequestBody Map<String, Object> param){
        return searchRecordClient.index(param);
    }

    @RequestMapping(value = "/helper",method = RequestMethod.GET)
    public Object helper(@RequestBody Map<String,Object> param){
        return  searchRecordClient.helper(param);
    }

    @RequestMapping(value = "/deleterecord",method = RequestMethod.DELETE)
    public Object deleterecord(@RequestBody Map<String,Object> map){
        return  searchRecordClient.deleterecord(map);
    }
}
