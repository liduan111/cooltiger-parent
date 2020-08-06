package com.kyj.cooltiger.cooltigeroauth.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.kyj.cooltiger.cooltigercommon.utils.PageUtils;
import com.kyj.cooltiger.cooltigercommon.utils.Querys;
import com.kyj.cooltiger.cooltigerfeign.oauth.client.MemberClient;
import com.kyj.cooltiger.cooltigeroauth.entity.AddressVo;
import com.kyj.cooltiger.cooltigeroauth.entity.Userpo;
import com.kyj.cooltiger.cooltigeroauth.service.AddressService;
import com.kyj.cooltiger.cooltigeroauth.service.ApiUserService;
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
 * @date 2020/8/5 11:38
 */
@Api("会员")
@RestController
@RequestMapping("/member")
public class MemberController extends ApiBaseAction implements MemberClient {

    @Autowired
    private ApiUserService apiUserService;


    @Autowired
    private AddressService addressService;
    /**
     * 查询会员列表
     * @param params
     * @return
     */
    @Override
    @ApiOperation("会员列表")
    @RequestMapping(value = "/memberlist",method = RequestMethod.GET)
    public  Object  memberlist(@RequestBody Map<String,Object> params){
        /*Integer page = Integer.parseInt(params.get("page").toString());
        Integer limit = Integer.parseInt(params.get("limit").toString());
        Map<String,Object> map=new HashMap<String,Object>();*/
        Querys querys=new Querys(params);
        List<Userpo> userpoList=apiUserService.querylist(querys);
        int total = apiUserService.queryTotal(querys);
        PageUtils pageUtil = new PageUtils(userpoList, total, querys.getLimit(), querys.getPage());

        return  toResponsSuccess(pageUtil);
    }

    /**
     * 根据用户id查询收货地址
     * @param code
     * @return
     */
    @Override
    @ApiOperation("根据用户id查询收货地址")
    @RequestMapping(value = "/queryaddress",method = RequestMethod.GET)
    public Object queryaddress(@RequestBody String code){
        JSONObject object= JSON.parseObject(code);
        Long  userCode=Long.parseLong(object.getString("userCode"));
        if (userCode!=null||userCode!=0) {
            AddressVo addressVo = addressService.queryByuserCode(userCode);
            return toResponsSuccess(addressVo);
        }else {
            return  toResponsFail("id为空");
        }
    }
}
