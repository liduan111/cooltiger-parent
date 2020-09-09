package com.kyj.cooltiger.order.controller;

import com.kyj.cooltiger.common.excep.MyException;
import com.kyj.cooltiger.common.utils.Result;
import com.kyj.cooltiger.order.config.FtpConfig;
import com.kyj.cooltiger.order.entity.Commentreview;
import com.kyj.cooltiger.order.service.CommentreviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/9/9 11:49
 */
@RestController
@RequestMapping(value = "/order/comment")
public class CommentreviewController {

    @Autowired
    private CommentreviewService commentreviewService;

    @Autowired
    private FtpConfig ftpConfig;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public Result commentlist(){

        return Result.success();
    }


    @RequestMapping(value = "/getcomment",method = RequestMethod.GET)
    public  Result getcomment(@RequestBody Map<String,Object> map){
        if (map.isEmpty()||map.size()==0){
            new MyException("500","参数为空");
        }
        Commentreview commentreview=commentreviewService.getcomment(map);

        return Result.success();
    }

    /**
     *
     * @param orderId
     * @param skuId
     * @param storeId
     * @param userId
     * @param productId
     * @param reviewStar
     * @param logisticsStar
     * @param storeStar
     * @param reviewContent
     * @param commentpicUrl
     * @return
     */
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public  Result commentsave(@RequestParam(value = "orderId",required = false)Integer orderId,
                               @RequestParam(value = "skuId",required = false)Integer skuId,
                               @RequestParam(value = "storeId",required = false)Integer storeId,
                               @RequestParam(value = "userId",required = false)Long userId,
                               @RequestParam(value = "productId",required = false)Integer productId,
                               @RequestParam(value = "reviewStar",required = false)Integer reviewStar,
                               @RequestParam(value = "logisticsStar",required = false)Integer logisticsStar,
                               @RequestParam(value = "storeStar",required = false)Integer storeStar,
                               @RequestParam(value = "reviewContent",required = false)String reviewContent,
                               @RequestParam(value = "commentpicUrl",required = false) MultipartFile[] commentpicUrl){
        if (orderId==null){
            new MyException("500","orderId为空");
        }
        if (skuId==null){
            new MyException("500","skuId为空");
        }
        if (storeId==null){
            new MyException("500","storeId为空");
        }
        if (userId==null){
            new MyException("500","userId为空");
        }
        if (productId==null){
            new MyException("500","productId为空");
        }
        if (reviewStar==null){
            new MyException("500","reviewStar为空");
        }
        if (logisticsStar==null){
            new MyException("500","logisticsStar为空");
        }
        if (storeStar==null){
            new MyException("500","storeStar为空");
        }
        if (reviewContent==null||reviewContent.isEmpty()||reviewContent.equals("")){
            new MyException("500","reviewContent为空");
        }
        if (commentpicUrl==null||commentpicUrl.length==0||commentpicUrl.equals("")){
            new MyException("500","commentpicUrl为空");
        }
        Commentreview commentreview=new Commentreview();
        commentreview.setOrderId(orderId);
        commentreview.setUserId(userId);
        commentreview.setProductId(productId);
        commentreview.setSkuId(skuId);
        commentreview.setStoreId(storeId);
        commentreview.setReviewStar(reviewStar);
        commentreview.setLogisticsStar(logisticsStar);
        commentreview.setStoreStar(storeStar);
        commentreview.setReviewContent(reviewContent);
        //commentreviewService.save(commentreview);

        return Result.error();
    }

    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    public  Result commentdelete(){
        return Result.error();
    }

}
