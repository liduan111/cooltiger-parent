package com.kyj.cooltiger.order.controller;

import com.kyj.cooltiger.common.constant.IMAGES_PATH;
import com.kyj.cooltiger.common.excep.MyException;
import com.kyj.cooltiger.common.utils.CharUtil;
import com.kyj.cooltiger.common.utils.FileTypeUtil;
import com.kyj.cooltiger.common.utils.FtpUtil;
import com.kyj.cooltiger.common.utils.Result;
import com.kyj.cooltiger.feign.order.client.OrderReviewClient;
import com.kyj.cooltiger.feign.order.vo.OrderReviewReqVo;
import com.kyj.cooltiger.feign.product.client.ProductInfoClient;
import com.kyj.cooltiger.feign.product.client.StoreInfoClient;
import com.kyj.cooltiger.feign.product.vo.StoreInfoRespVo;
import com.kyj.cooltiger.order.config.FtpConfig;
import com.kyj.cooltiger.order.entity.OrderReview;
import com.kyj.cooltiger.order.service.OrderReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/9/9 11:49
 */
@RestController
@RequestMapping(value = "/order/orderReview")
public class OrderReviewController implements OrderReviewClient {

    @Autowired
    private OrderReviewService orderReviewService;
    @Autowired
    private FtpConfig ftpConfig;
    @Autowired
    private StoreInfoClient storeInfoClient;

    /**
     * 订单评价
     *
     * @param userId           用户ID
     * @param reviewPics       评价图片
     * @param orderReviewReqVo 评价参数
     * @return
     */
    @RequestMapping(value = "/commitOrderReview", method = RequestMethod.POST)
    public Result commitOrderReview(
            @RequestParam("user_id") Long userId,
            @RequestParam(value = "review_pics", required = false) MultipartFile[] reviewPics,
            OrderReviewReqVo orderReviewReqVo) {
        if (reviewPics == null) {
            orderReviewService.commitOrderReview(userId, orderReviewReqVo, null);
        } else {
            //店铺信息
            StoreInfoRespVo storeInfoRespVo = (StoreInfoRespVo) storeInfoClient.getStoreInfo(orderReviewReqVo.getStore_id()).getData();
            //实例化FtpUtil工具类上传图片
            FtpUtil ftpUtil = new FtpUtil();
            ArrayList<FtpUtil.FileInfo> fileInfos = new ArrayList<>();
            FtpUtil.FileInfo fileInfo = null;
            //图片存放子目录
            String filePath = IMAGES_PATH.STORE + "/" + storeInfoRespVo.getStoreCode() + IMAGES_PATH.REVIEW;
            //图片存放路径
            List<String> picUrls = new ArrayList<>();
            for (MultipartFile pic : reviewPics) {
                //获取文件名
                String oldName = pic.getOriginalFilename();
                //根据文件名字判断是否为图片，支持（jpg png gif bmp）
                if (!FileTypeUtil.isImageByName(oldName)) {
                    throw new MyException("PICTURE_FORMAT_ERROR", "图片格式错误");
                }
                //使用CharUtil工具类生成新图片名（时间戳+随机字符串）+ 后缀名
                String newName = CharUtil.getImageName(25) + oldName.substring(oldName.lastIndexOf("."));
                fileInfo = ftpUtil.new FileInfo();
                fileInfo.setBasePath(ftpConfig.getBasePath());
                fileInfo.setFilePath(filePath);
                fileInfo.setFileName(newName);
                fileInfo.setUpFile(pic);
                fileInfos.add(fileInfo);
                picUrls.add(ftpConfig.getImageBaseUrl() + filePath + "/" + newName);
            }
            orderReviewService.commitOrderReview(userId, orderReviewReqVo, picUrls);
            int result = ftpUtil.uploadBatchFile(ftpConfig.getHost(), ftpConfig.getPort(), ftpConfig.getUserName(),
                    ftpConfig.getPassWord(), fileInfos);
        }
        return Result.success();
    }

    /**
     * 查询商品评价列表
     *
     * @param storeId   店铺ID
     * @param productId 商品ID
     * @param keyword   评价类型（1-好评2-中评3-差评）
     * @param skuId     商品skuID
     * @param pageNo    当前页码
     * @param pageSize  分页单位
     * @return
     */
    @RequestMapping(value = "/getOrderReviewList", method = {RequestMethod.GET})
    public Result getOrderReviewList(
            @RequestParam("store_id") Integer storeId,
            @RequestParam(value = "product_id", required = false) Integer productId,
            @RequestParam(value = "keyword", required = false) Integer keyword,
            @RequestParam(value = "sku_id", required = false) Integer skuId,
            @RequestParam(value = "page_no", defaultValue = "1") Integer pageNo,
            @RequestParam(value = "page_size", defaultValue = "10") Integer pageSize) {
        Map<String, Object> res = orderReviewService.getOrderReviewList(storeId, productId, keyword, skuId, pageNo, pageSize);
        return Result.success(res);
    }
}
