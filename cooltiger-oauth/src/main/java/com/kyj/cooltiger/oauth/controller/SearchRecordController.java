package com.kyj.cooltiger.oauth.controller;

import com.kyj.cooltiger.common.utils.Querys;
import com.kyj.cooltiger.feign.oauth.client.SearchRecordClient;
import com.kyj.cooltiger.oauth.entity.KeywordsEntity;
import com.kyj.cooltiger.oauth.entity.SearchRecordEntity;
import com.kyj.cooltiger.oauth.service.KeywordsService;
import com.kyj.cooltiger.oauth.service.SearchRecordService;
import com.kyj.cooltiger.oauth.utils.ApiBaseAction;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/9/7 11:47
 */
@Api(tags = "商品搜索")
@RestController
@RequestMapping("/api/search")
public class SearchRecordController extends ApiBaseAction implements SearchRecordClient {

    @Autowired
    private SearchRecordService searchRecordService;
    @Autowired
    private KeywordsService keywordsService;

    /**
     * 　　index
     */
    @ApiOperation(value = "搜索界面列表展示")
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public Object index(@RequestBody Map<String, Object> param) {
        Map<String, Object> resultObj = new HashMap<>();
       // Map<String, Object> param = new HashMap<>();
        param.put("is_default", 1);
        param.put("page", 1);
        param.put("limit", 1);
        param.put("sidx", "id");
        param.put("order", "asc");
        List<KeywordsEntity> keywordsEntityList = keywordsService.queryList(param);
        //取出输入框默认的关键词
        KeywordsEntity defaultKeyword = null != keywordsEntityList && keywordsEntityList.size() > 0 ? keywordsEntityList.get(0) : null;
        //取出热闹关键词
        param = new HashMap<>();
        param.put("fields", "distinct keyword,is_hot");
        param.put("page", 1);
        param.put("limit", 10);
        param.put("sidx", "id");
        param.put("order", "asc");
        Querys query = new Querys(param);
        List<Map> hotKeywordList = keywordsService.hotKeywordList(query);
        param = new HashMap<>();
        //param.put("user_id","userId");
        param.put("fields", "distinct keyword");
        param.put("page", 1);
        param.put("limit", 10);
        param.put("sidx", "create_time");
        param.put("order", "asc");
        //查询搜索历史记录
        List<SearchRecordEntity> historyVoList = searchRecordService.queryList(param);
        String[] historyKeywordList = new String[historyVoList.size()];
        if (null != historyVoList) {
            int i = 0;
            for (SearchRecordEntity historyVo : historyVoList) {
                historyKeywordList[i] = historyVo.getKeyword();
                i++;
            }
        }
        //
        resultObj.put("defaultKeyword", defaultKeyword);
        resultObj.put("historyKeywordList", historyKeywordList);
        resultObj.put("hotKeywordList", hotKeywordList);
        return toResponsSuccess(resultObj);
    }

    /**
     * 　　helper
     */
    @ApiOperation(value = "搜索商品")
    @ApiImplicitParams({@ApiImplicitParam(name = "keyword", value = "关键字", paramType = "path", required = true)})
    @RequestMapping(value = "/helper",method = RequestMethod.GET)
    public Object helper(@RequestBody Map<String,Object> param) {
        //Map param = new HashMap();
        if(param.isEmpty()||param.size()==0){
            return  toResponscode(500,"参数为空");
        }
        param.put("fields", "distinct keyword");
        //param.put("keyword", keyword);
        param.put("limit", 10);
        param.put("offset", 0);
        List<KeywordsEntity> keywords = keywordsService.queryList(param);
        String[] keys = new String[keywords.size()];
        if (null != keywords) {
            int i = 0;
            for (KeywordsEntity keywordsVo : keywords) {
                keys[i] = keywordsVo.getKeyword();
                i++;
            }
        }
        //
        return toResponsSuccess(keys);
    }

    /**
     * 删除用户历史记录清空
     * @param map
     * @return
     */
    @ApiOperation("删除历史记录")
    @RequestMapping(value = "/deleterecord",method = RequestMethod.DELETE)
    public Object deleterecord(@RequestBody Map<String,Object> map) {
        if (map.size()==0||map.isEmpty()){
            return  toResponscode(500,"参数为空");
        }
        Long userId=Long.valueOf(map.get("userId").toString());
        searchRecordService.deleteRecord(userId);

        return toResponsMsgSuccess("删除成功");
    }

}
