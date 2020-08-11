package com.kyj.cooltiger.cooltigeroauth.controller;

import com.kyj.cooltiger.cooltigerfeign.oauth.client.CollectClient;
import com.kyj.cooltiger.cooltigeroauth.entity.CollectVo;
import com.kyj.cooltiger.cooltigeroauth.entity.GoodsCollectVo;
import com.kyj.cooltiger.cooltigeroauth.service.ApiCollectService;
import com.kyj.cooltiger.cooltigeroauth.utils.ApiBaseAction;
import io.swagger.annotations.Api;
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
 * @date 2020/8/10 11:03
 */
@Api("收藏接口")
@RestController
@RequestMapping("/collect")
public class CollectController extends ApiBaseAction implements CollectClient {

    @Autowired
    private ApiCollectService collectService;


    /**
     * 获取用户收藏店铺列表
     * @return
     */
    @ApiOperation("获取用户收藏店铺")
    @RequestMapping(value = "/shoplist",method = RequestMethod.GET)
    public  Object collectlist(@RequestBody Map<String,Object> map){

        if(map.size()==0||map.toString()==null){
            return  toResponsFail("参数为空");
        }
        List<CollectVo>  collectlist=collectService.collectlist(map);

        return  toResponsSuccess(collectlist);
    }

    /**
     * 添加收藏店铺
     * @param map
     * @return
     */
    @ApiOperation("添加收藏店铺")
    @RequestMapping(value = "/addcollect",method = RequestMethod.POST)
    public  Object collectsave(@RequestBody Map<String,Object> map){
        if(map.size()==0||map.toString()==null){
            return  toResponsFail("参数为空");
        }
        boolean flag=collectService.addcollect(map);
        if(flag){
            return  toResponsMsgSuccess("添加成功");
        }
        return toResponsFail("添加失败");
    }

    /**
     * 取消关注店铺
     * @param map
     * @return
     */
    @ApiOperation("取消关注店铺")
    @RequestMapping(value = "/remove",method = RequestMethod.PUT)
    public Object  removecollect(@RequestBody Map<String,Object> map){

        if(map.size()==0||map.toString()==null){
            return  toResponsFail("参数为空");
        }
        CollectVo collectVo=collectService.querycollect(map);
        if (collectVo!=null||!collectVo.equals("")){
            //取消收藏
            boolean flag=collectService.collectremove(collectVo);
            if(flag){
                return toResponsMsgSuccess("成功");
            }
        }else {
            return toResponsFail("取消失败");
        }
          return  toResponsFail("取消失败");
    }

    /**
     * 商品收藏列表
     * @param map
     * @return
     */
    @ApiOperation("商品收藏列表")
    @RequestMapping(value = "/goodscollectlist",method = RequestMethod.GET)
    public  Object goodscollectlist(@RequestBody Map<String,Object> map){
        if(map.size()==0||map.toString()==null){
            return  toResponsFail("参数为空");
        }
        List<GoodsCollectVo>  goodslist=collectService.goodscollectlist(map);
        return  toResponsSuccess(goodslist);
    }


    /**
     * 商品收藏
     * @param map
     * @return
     */
    @ApiOperation("商品收藏")
    @RequestMapping(value = "/goodscollectsave",method = RequestMethod.POST)
    public Object  goodscollectsave(@RequestBody Map<String,Object> map){
        if(map.size()==0||map.toString()==null){
            return  toResponsFail("参数为空");
        }
        boolean flag=collectService.goodscollectsave(map);
        if(flag){
            return toResponsMsgSuccess("成功");
        }
        return  toResponsFail("收藏失败");
    }

    /**
     * 取消商品收藏
     * @param map
     * @return
     */
    @ApiOperation("取消商品收藏")
    @RequestMapping(value = "/canselgoodscollect",method = RequestMethod.PUT)
    public Object canselgoodscollect(@RequestBody Map<String,Object> map){

        if(map.size()==0||map.toString()==null){
            return  toResponsFail("参数为空");
        }
        GoodsCollectVo goodsCollectVo=collectService.querygoodscollect(map);
        if(goodsCollectVo!=null||!goodsCollectVo.equals("")){
            boolean flag=collectService.canselgoodscollect(goodsCollectVo);
            if (flag){
                return  toResponsMsgSuccess("成功");
            }
        }else {
            return  toResponsFail("修改失败");
        }

        return  toResponsFail("取消失败");
    }


}
