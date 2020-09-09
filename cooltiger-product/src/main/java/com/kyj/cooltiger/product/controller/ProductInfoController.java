package com.kyj.cooltiger.product.controller;

import com.kyj.cooltiger.common.constant.IMAGES_PATH;
import com.kyj.cooltiger.common.constant.PRODUCT_IMAGE_TYPE;
import com.kyj.cooltiger.common.excep.MyException;
import com.kyj.cooltiger.common.utils.CharUtil;
import com.kyj.cooltiger.common.utils.FileTypeUtil;
import com.kyj.cooltiger.common.utils.FtpUtil;
import com.kyj.cooltiger.common.utils.Result;
import com.kyj.cooltiger.feign.product.client.ProductInfoClient;
import com.kyj.cooltiger.feign.product.vo.ProductBaseReqVo;
import com.kyj.cooltiger.feign.product.vo.ProductSkuReqVo;
import com.kyj.cooltiger.product.config.FtpConfig;
import com.kyj.cooltiger.product.entity.ProductInfo;
import com.kyj.cooltiger.product.entity.StoreInfo;
import com.kyj.cooltiger.product.service.ProductInfoService;
import com.kyj.cooltiger.product.service.ProductPictureService;
import com.kyj.cooltiger.product.service.StoreInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author liduan
 * Description: 商品信息Controller
 * date: 2020/7/28 11:18
 */
@RestController
@RequestMapping("/product/productInfo")
public class ProductInfoController implements ProductInfoClient {

    @Autowired
    private ProductInfoService productInfoService;
    @Autowired
    private StoreInfoService storeInfoService;
    @Autowired
    private ProductPictureService productPictureService;
    @Autowired
    private FtpConfig ftpConfig;

    /**
     * 获取店铺商品列表
     *
     * @param storeId    店铺ID
     * @param pageNo     当前页
     * @param pageSize   分页单位
     * @param categoryId 分类ID
     * @param keyword    搜索关键字
     * @return
     */
    @Override
    @RequestMapping(value = "/getProductInfoList/{store_id}", method = {RequestMethod.GET})
    public Result getProductInfoList(
            @PathVariable("store_id") Integer storeId,
            @RequestParam(value = "page_no", defaultValue = "1") Integer pageNo,
            @RequestParam(value = "page_size", defaultValue = "10") Integer pageSize,
            @RequestParam(value = "category_id", required = false) Integer categoryId,
            @RequestParam(value = "keyword", required = false) String keyword) {
        Map<String, Object> res = productInfoService.getProductInfoListByStoreId(storeId, pageNo, pageSize, categoryId, keyword);
        return Result.success(res);
    }

    /**
     * 添加商品基本信息
     *
     * @param storeId          店铺ID
     * @param productBaseReqVo 商品基本信息
     * @return
     */
    @RequestMapping(value = "/addProductBaseInfo/{store_id}", method = {RequestMethod.POST})
    public Result addProductBaseInfo(
            @PathVariable("store_id") Integer storeId,
            @RequestBody ProductBaseReqVo productBaseReqVo) {
        Map<String, Object> res = productInfoService.addProductBaseInfo(storeId, productBaseReqVo);
        return Result.success(res);
    }

    /**
     * 添加商品Sku信息
     *
     * @param productId       商品ID
     * @param productSkuReqVo 商品Sku信息
     * @return
     */
    @Override
    @RequestMapping(value = "/addProductSkuInfo/{product_id}", method = {RequestMethod.POST})
    public Result addProductSkuInfo(
            @PathVariable("product_id") Integer productId,
            @RequestBody ProductSkuReqVo productSkuReqVo) {
        productInfoService.addProductSkuInfo(productId, productSkuReqVo);
        return Result.success();
    }

    /**
     * 查询商品信息
     *
     * @param productId
     * @return
     */
    @Override
    @RequestMapping(value = "/getProductItem/{productId}", method = {RequestMethod.GET})
    public Result getProductItem(@PathVariable("productId") Integer productId) {
        Map<String,Object> res = productInfoService.getProductItem(productId);
        return Result.success(res.get("data"));
    }

    /**
     * 商品下架
     *
     * @param productId
     * @return
     */
    @Override
    @RequestMapping(value = "/productInfoDownShelf/{productId}", method = {RequestMethod.PUT})
    public Result productInfoDownShelf(@PathVariable("productId") Integer productId) {
        productInfoService.productInfoDownShelf(productId);
        return Result.success();
    }

    /**
     * 商品审核
     *
     * @param productId
     * @return
     */
    @Override
    @RequestMapping(value = "/productInfoAudit/{productId}", method = {RequestMethod.PUT})
    public Result productInfoAudit(@PathVariable("productId") Integer productId) {
        productInfoService.productInfoAudit(productId);
        return Result.success();
    }

    /**
     * 删除商品信息
     *
     * @param productId
     * @return
     */
    @Override
    @RequestMapping(value = "/deleteProductInfo/{productId}", method = {RequestMethod.DELETE})
    public Result deleteProductInfo(@PathVariable("productId") Integer productId) {
        productInfoService.deleteProductInfo(productId);
        return null;
    }

    /**
     * 批量上传商品图片
     *
     * @param productId 商品ID
     * @param picType   图片类型（1-商品图片2-sku图片3-详情图片）
     * @param pics      图片
     * @return
     */
    @RequestMapping(value = "/upProductImage", method = {RequestMethod.POST})
    public Result upProductImage(
            @RequestParam("product_id") Integer productId,
            @RequestParam("pic_type") Integer picType,
            @RequestParam("pics") MultipartFile[] pics) {
        //获取商品信息
        ProductInfo productInfo = productInfoService.getProductInfo(productId);
        //获取店铺信息
        StoreInfo storeInfo = storeInfoService.getStoreInfoByStoreId(productInfo.getStoreId());
        //实例化FtpUtil工具类上传图片
        FtpUtil ftpUtil = new FtpUtil();
        ArrayList<FtpUtil.FileInfo> fileInfos = new ArrayList<>();
        FtpUtil.FileInfo fileInfo = null;
        //图片存放子目录
        StringBuilder filePath = new StringBuilder(IMAGES_PATH.STORE + "/" + storeInfo.getStoreCode() +
                IMAGES_PATH.PRODUCT + "/" + productInfo.getProductCode());
        if (picType == PRODUCT_IMAGE_TYPE.INFO) {
            filePath.append(IMAGES_PATH.INFO);
        } else if (picType == PRODUCT_IMAGE_TYPE.SKU) {
            filePath.append(IMAGES_PATH.SKU);
        } else if (picType == PRODUCT_IMAGE_TYPE.DATAIL) {
            filePath.append(IMAGES_PATH.DETAIL);
        }
        //定义返回url
        List<String> resUrls = new ArrayList<>();
        for (MultipartFile pic : pics) {
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
            fileInfo.setFilePath(filePath.toString());
            fileInfo.setFileName(newName);
            fileInfo.setUpFile(pic);
            fileInfos.add(fileInfo);
            resUrls.add(ftpConfig.getImageBaseUrl() + filePath.toString() + "/" + newName);
        }
        //添加到数据库
        if (picType == PRODUCT_IMAGE_TYPE.INFO) {
            productPictureService.addProductPicture(productId,resUrls);
        }
        int result = ftpUtil.uploadBatchFile(ftpConfig.getHost(), ftpConfig.getPort(), ftpConfig.getUserName(),
                ftpConfig.getPassWord(), fileInfos);
        return Result.success(resUrls);
    }

    /**
     * 批量删除图片
     *
     * @param imageUrls 图片url
     * @return
     */
    @RequestMapping(value = "/delProductImage", method = {RequestMethod.DELETE})
    public Result delProductImage(
            @RequestBody List<String> imageUrls) {
        //调用FtpUtil工具类删除图片
        FtpUtil ftpUtil = new FtpUtil();
        //删除的集合
        ArrayList<FtpUtil.FileInfo> fileInfos = new ArrayList<>();
        FtpUtil.FileInfo fileInfo = null;
        for (String imageUrl : imageUrls) {
            fileInfo = ftpUtil.new FileInfo();
            fileInfo.setBasePath(ftpConfig.getBasePath());
            fileInfo.setFilePath(imageUrl.substring(imageUrl.lastIndexOf(IMAGES_PATH.STORE), imageUrl.lastIndexOf("/")));
            fileInfo.setFileName(imageUrl.substring(imageUrl.lastIndexOf("/") + 1));
            fileInfos.add(fileInfo);
        }
        int res = ftpUtil.deleteBatchFile(ftpConfig.getHost(), ftpConfig.getPort(), ftpConfig.getUserName(),
                ftpConfig.getPassWord(), fileInfos);
        return Result.success(res);
    }

    /**
     * 添加修改商品详情
     *
     * @param productId 商品ID
     * @param detail    商品详情
     * @return
     */
    @Override
    @RequestMapping(value = "/addProductDetail", method = {RequestMethod.POST})
    public Result addProductDetail(
            @RequestParam("product_id") Integer productId,
            @RequestParam("detail") String detail){
        productInfoService.addProductDetail(productId,detail);
        return Result.success();
    }

    /**
     * 查询商品规格属性
     *
     * @param productId 商品ID
     * @return
     */
    @RequestMapping(value = "/getProductSpec", method = {RequestMethod.GET})
    public Result getProductSpec(
            @RequestParam("product_id") Integer productId){
        Map<String,Object> res = productInfoService.getProductSpec(productId);
        return Result.success(res.get("data"));
    }
}
