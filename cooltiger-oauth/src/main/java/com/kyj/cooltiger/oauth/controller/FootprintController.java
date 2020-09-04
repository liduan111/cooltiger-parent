package com.kyj.cooltiger.oauth.controller;

import com.kyj.cooltiger.feign.oauth.client.FootprintClient;
import com.kyj.cooltiger.oauth.entity.FootprintEntity;
import com.kyj.cooltiger.oauth.service.FootprintService;
import com.kyj.cooltiger.oauth.utils.ApiBaseAction;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/9/4 10:15
 */
@RestController
@RequestMapping(value = "/api/footprint")
public class FootprintController extends ApiBaseAction implements FootprintClient {

    @Autowired
    private FootprintService footprintService;

    /**
     * 足迹列表
     * @return
     */
    @ApiOperation("足迹列表")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public  Object Footprintlist(@RequestBody Map<String,Object> map){

        if(map.isEmpty()||map.size()==0){
            return toResponscode(500,"参数为空");
        }
        map.put("sidx", "a.create_time");
        map.put("order", "desc ");
        map.put("offset",0);
        map.put("limit",9);
        List<FootprintEntity> footprintlist=footprintService.footprintlist(map);
        return  toResponsSuccess(footprintlist);
    }

    /**
     * 删除足迹
     * @param map
     * @return
     */
    @ApiOperation("删除足迹")
    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    public  Object  Footprintdelete(@RequestBody Map<String,Object> map){

        if(map.isEmpty()||map.size()==0){
            return toResponscode(500,"参数为空");
        }
        footprintService.footprintdelete(map);
        return toResponsMsgSuccess("删除成功");
    }

}
