package com.kyj.cooltiger.order.controller;

import com.kyj.cooltiger.common.utils.Result;
import com.kyj.cooltiger.order.entity.AfterSale;
import com.kyj.cooltiger.order.entity.RefundApplication;
import com.kyj.cooltiger.order.entity.RefundReason;
import com.kyj.cooltiger.order.service.AfterSaleService;
import com.kyj.cooltiger.order.service.RefundReasonService;
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
 * @date 2020/8/20 11:06
 * 售后
 */
@RestController
@RequestMapping(value = "/order/aftersale")
public class AfterSaleController {

    @Autowired
    private AfterSaleService afterSaleService;

    @Autowired
    private RefundReasonService refundReasonService;

    /**
     * 售后列表查询
     * @param map
     * @return
     */
    @RequestMapping(value = "/salelist",method = RequestMethod.GET)
    public Result getaftersale(@RequestBody Map<String,Object> map){
        if(map.isEmpty()||map.size()==0){
            return Result.error("500","参数为空");
        }
        List<AfterSale>  afterSaleList=afterSaleService.querysalelist(map);
        if (afterSaleList.isEmpty()||afterSaleList.size()==0){
            return Result.success();
        }
        return  Result.success(afterSaleList);
    }

    /**
     * 删除记录
     * @param map
     * @return
     */
    @RequestMapping(value = "/deleterecord",method = RequestMethod.DELETE)
    public Result deleterecord(@RequestBody Map<String,Object> map){

        if(map.isEmpty()||map.size()==0){
             return Result.error("500","参数为空");
        }
        boolean  flag=afterSaleService.deleterecord(map);
        if(flag) {
             return Result.success("删除成功");
        }
        return  Result.error("500","删除失败");
    }

    /**
     * 查看详情
     * @param map
     * @return
     */
    @RequestMapping(value = "/aftersalelook",method = RequestMethod.GET)
    public Result  lookdetail(@RequestBody Map<String,Object> map){
        if(map.isEmpty()||map.size()==0){
            return Result.error("500","参数为空");
        }
        //查看退款详情
        AfterSale  afterSale=afterSaleService.looksaledetail(map);
        if (afterSale==null||afterSale.equals("")){
            return Result.error("500","服务器出错");
        }
        return  Result.success(afterSale);
    }

    /**
     * 退款类型
     * @param map
     * @return
     */
    @RequestMapping(value = "/refundtype",method = RequestMethod.GET)
    public  Result  refundtype(@RequestBody Map<String,Object> map){
        if(map.isEmpty()||map.size()==0){
            return Result.error("500","参数为空");
        }
        //查询退款类型
        AfterSale  afterSale=afterSaleService.refundtype(map);

        return  Result.success(afterSale);
    }

    /**
     * 查询申请退款
     * @param map
     * @return
     */
    @RequestMapping(value = "/refundappplication",method = RequestMethod.GET)
    public  Result  getrefundappplication(@RequestBody Map<String,Object> map){
        if(map.isEmpty()||map.size()==0){
            return Result.error("500","参数为空");
        }
        //查询申请退款
        RefundApplication refundApplication=afterSaleService.refundappplication(map);
        //查询退款原因类型
        List<RefundReason>  refundReasonList=refundReasonService.refundReasonList();
        Map<String , Object> param=new HashMap<>();
        param.put("refundApplication",refundApplication);
        param.put("refundReasonList",refundReasonList);
        return Result.success(param);
    }

    /**
     * 退款原因
     * @return
     */
    @RequestMapping(value = "/refundreason",method = RequestMethod.POST)
   public  Result saverefundreason(@RequestBody Map<String,Object> map){
        return  Result.success();
   }

}
