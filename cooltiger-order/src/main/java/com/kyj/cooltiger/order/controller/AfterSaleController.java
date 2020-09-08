package com.kyj.cooltiger.order.controller;

import com.kyj.cooltiger.common.excep.MyException;
import com.kyj.cooltiger.common.utils.CharUtil;
import com.kyj.cooltiger.common.utils.FileTypeUtil;
import com.kyj.cooltiger.common.utils.FtpUtil;
import com.kyj.cooltiger.common.utils.Result;
import com.kyj.cooltiger.order.config.FtpConfig;
import com.kyj.cooltiger.order.entity.AfterSale;
import com.kyj.cooltiger.order.entity.RefundApplication;
import com.kyj.cooltiger.order.entity.RefundReason;
import com.kyj.cooltiger.order.service.AfterSaleService;
import com.kyj.cooltiger.order.service.RefundApplicationService;
import com.kyj.cooltiger.order.service.RefundReasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
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

    @Autowired
    private RefundApplicationService refundApplicationService;

    @Autowired
    private FtpConfig ftpConfig;

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
        //退款类型页面
        AfterSale  afterSale=afterSaleService.refundtype(map);

        return  Result.success(afterSale);
    }

    /**
     * 申请退款页面
     * @param map
     * @return
     */
    @RequestMapping(value = "/refundappplication",method = RequestMethod.GET)
    public  Result  getrefundappplication(@RequestBody Map<String,Object> map){
        if(map.isEmpty()||map.size()==0){
            return Result.error("500","参数为空");
        }
        //查询申请退款
        AfterSale afterSale=afterSaleService.refundappplication(map);
        //查询退款原因类型
        List<RefundReason>  refundReasonList=refundReasonService.refundReasonList();
        Map<String , Object> param=new HashMap<>();
        param.put("refundApplication",afterSale);
        param.put("refundReasonList",refundReasonList);
        return Result.success(param);
    }

    /**
     * 提交退款申请
     * @return
     */
    @RequestMapping(value = "/refundreason",method = RequestMethod.POST)
   public  Result saverefund(@RequestParam(value = "received",required = false)Integer received,
                             @RequestParam(value = "refundPrice",required = false) BigDecimal refundPrice,
                             @RequestParam(value = "orderId",required = false)Integer orderId,
                             @RequestParam(value = "userId",required = false) Long userId,
                             @RequestParam(value = "refundDesc",required = false) String refundDesc,
                             @RequestParam(value = "reasonId",required = false) Integer reasonId,
                             @RequestParam(value = "proofPicture",required = false) MultipartFile proofPicture){
        if (proofPicture==null || proofPicture.equals("")){
            return Result.error("500","proofPicture为空");
        }
        if (reasonId==null){
            return Result.error("500","reasonId为空");
        }
        if (userId==null){
            return Result.error("500","userId为空");
        }
        if (orderId==null){
            return Result.error("500","orderId为空");
        }
        if (refundPrice==null){
            return Result.error("500","refundPrice为空");
        }

        String  filenames=proofPicture.getOriginalFilename();
        if(FileTypeUtil.isImageByName(filenames)){
            new MyException("PICTURE_FORMAT_ERROR","图片格式错误");
        }

        String picturesurl= CharUtil.getImageName(25) + filenames.substring(filenames.lastIndexOf("."));
        String filePath ="/"+userId+ "/refundpicture";

        if (received==0||received==1){
              boolean flag=refundApplicationService.saves(received,refundPrice,orderId,userId,refundDesc,reasonId,ftpConfig.getImageBaseUrl() + filePath + "/"+picturesurl);
              if (flag){
                  FtpUtil ftpUtil = new FtpUtil();
                  boolean result = ftpUtil.uploadFile(ftpConfig.getHost(), ftpConfig.getPort(), ftpConfig.getUserName(),
                          ftpConfig.getPassWord(), ftpConfig.getBasePath(), filePath, picturesurl, proofPicture);
                  if (!result){
                    new MyException("PICTURE_UPLOAD_ERROR", " 上传失败");
                  }
                  return Result.success();
              }
        }else{
            boolean flag=refundApplicationService.saves(received,refundPrice,orderId,userId,refundDesc,reasonId,ftpConfig.getImageBaseUrl() + filePath + "/"+picturesurl);
            if (flag){
                FtpUtil ftpUtil = new FtpUtil();
                boolean result1 = ftpUtil.uploadFile(ftpConfig.getHost(), ftpConfig.getPort(), ftpConfig.getUserName(),
                        ftpConfig.getPassWord(), ftpConfig.getBasePath(), filePath, picturesurl, proofPicture);
                if(!result1){
                     new MyException("PICTURE_UPLOAD_ERROR", "图片上传失败");
                }
                return Result.success();
            }
        }
        return  Result.error();
   }

}
