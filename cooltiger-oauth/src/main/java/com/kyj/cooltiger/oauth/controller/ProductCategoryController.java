package com.kyj.cooltiger.oauth.controller;

import com.kyj.cooltiger.feign.oauth.client.CategoryClient;
import com.kyj.cooltiger.oauth.entity.ProductCategoryVo;
import com.kyj.cooltiger.oauth.service.ApiProductCategoryService;
import com.kyj.cooltiger.oauth.utils.ApiBaseAction;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/8/6 17:42
 */
@Api("商品分类接口")
@RestController
@RequestMapping("/api/category")
public class ProductCategoryController extends ApiBaseAction implements CategoryClient {

    @Autowired
    private ApiProductCategoryService productCategoryService;

    /**
     * 商品分类查询
     * @return
     */
    @ApiOperation("商品分类列表查询")
    @RequestMapping(value ="/categorylist",method = RequestMethod.GET)
    public  Object categorylist(@RequestBody Map<String,Object> map1){
        if(map1==null||map1.size()==0){
            toResponsFail("参数为空");
        }
        Map<String,Object> map=new HashMap<String,Object>();
        //查询商品分类
        List<ProductCategoryVo> productCategoryVo=productCategoryService.categorylist();
        List<ProductCategoryVo> productCategoryVoList=productCategoryService.querycategorylist(map1);
        map.put("productCategoryList",productCategoryVoList);
        map.put("productCategory",productCategoryVo);
        return toResponsSuccess(map);
    }

    /**
     * 首页分类
     * @return
     */
    @ApiOperation("首页分类")
    @RequestMapping(value = "/indexcategory",method = RequestMethod.GET)
    public  Object indexcategory(){
        List<ProductCategoryVo> productCategoryVo=productCategoryService.indexcategory();
        return  toResponsSuccess(productCategoryVo);
    }

}
