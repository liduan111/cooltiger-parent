package com.kyj.cooltiger.feign.oauth.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/9/7 16:19
 */
@FeignClient(name = "Oauth-Service")
public interface SearchRecordClient {

    /**
     * 搜索界面展示
     * @param param
     * @return
     */
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public Object index(@RequestBody Map<String, Object> param);

    @RequestMapping(value = "/helper",method = RequestMethod.GET)
    public Object helper(@RequestBody Map<String,Object> param);

    @RequestMapping(value = "/deleterecord",method = RequestMethod.DELETE)
    public Object deleterecord(@RequestBody Map<String,Object> map);
}
