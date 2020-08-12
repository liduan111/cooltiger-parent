package com.kyj.cooltiger.oauth.controller;

import com.kyj.cooltiger.oauth.entity.ProductCategoryVo;
import com.kyj.cooltiger.oauth.service.ApiProductCategoryService;
import com.kyj.cooltiger.oauth.utils.ApiBaseAction;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/category")
public class ProductCategoryController extends ApiBaseAction {

    @Autowired
    private ApiProductCategoryService productCategoryService;

    /**
     * 商品分类查询
     * @return
     */
    @ApiOperation("商品分类列表查询")
    @RequestMapping(value ="/categorylist",method = RequestMethod.GET)
    public  Object categorylist(){
        Map<String,Object> map=new HashMap<String,Object>();
        //查询商品分类
        List<ProductCategoryVo> productCategoryVoList=productCategoryService.querycategorylist();
        map.put("productCategoryList",productCategoryVoList);
        return toResponsSuccess(productCategoryVoList);
    }
}
