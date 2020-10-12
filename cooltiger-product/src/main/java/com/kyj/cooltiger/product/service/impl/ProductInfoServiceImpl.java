package com.kyj.cooltiger.product.service.impl;

import com.kyj.cooltiger.common.constant.DELETED;
import com.kyj.cooltiger.common.constant.PRODUCT_AUDIT_STATUS;
import com.kyj.cooltiger.common.excep.MyException;
import com.kyj.cooltiger.common.utils.CharUtil;
import com.kyj.cooltiger.common.utils.PageUtil;
import com.kyj.cooltiger.feign.product.vo.*;
import com.kyj.cooltiger.product.entity.*;
import com.kyj.cooltiger.product.mapper.*;
import com.kyj.cooltiger.product.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liduan
 * Description: 商品信息service实现类
 * date: 2020/7/28 11:23
 */
@Service
public class ProductInfoServiceImpl implements ProductInfoService {

    @Autowired
    private ProductInfoMapper productInfoMapper;
    @Autowired
    private ProductServiceMapper productServiceMapper;
    @Autowired
    private ProductParamMapper productParamMapper;
    @Autowired
    private ProductSpecNameMapper productSpecNameMapper;
    @Autowired
    private ProductSpecValueMapper productSpecValueMapper;
    @Autowired
    private ProductSkuMapper productSkuMapper;
    @Autowired
    private ProductPictureMapper productPictureMapper;
    @Autowired
    private ProductDetailsMapper productDetailsMapper;
    @Autowired
    private StoreInfoMapper storeInfoMapper;

    /**
     * 根据店铺ID获取商品列表
     *
     * @param storeId
     * @param pageNo
     * @param pageSize
     * @param categoryId
     * @param keyword
     * @return
     */
    @Override
    public Map<String, Object> getProductInfoListByStoreId(Integer storeId, Integer pageNo, Integer pageSize, Integer categoryId, String keyword) {
        //查询总条数
        int totalCount = productInfoMapper.getTotalCountByStoreId(storeId, categoryId, keyword);
        //创建分页工具类对象
        PageUtil<Object> pageUtil = new PageUtil<>(pageNo, pageSize, totalCount);
        List<ProductInfoListByStoreIdRespVo> respVoList = null;
        if (totalCount > 0) {
            int pageStart = (pageUtil.getPageNo() - 1) * pageUtil.getPageSize();
            respVoList = productInfoMapper.getProductInfoListByStoreId(storeId, pageStart, pageSize, categoryId, keyword);
        }
        //定义返回map数据
        HashMap<String, Object> res = new HashMap<>();
        res.put("totalCount", pageUtil.getTotalCount());
        res.put("totalPage", pageUtil.getTotalPage());
        res.put("data", respVoList);
        return res;
    }

    /**
     * 添加商品基本信息
     *
     * @param storeId          店铺ID
     * @param productBaseReqVo 商品基本信息
     * @return
     */
    @Transactional
    @Override
    public Map<String, Object> addProductBaseInfo(Integer storeId, ProductBaseReqVo productBaseReqVo) {
        //添加商品基本信息
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductCode(CharUtil.getRandomNum(10));
        productInfo.setTitle(productBaseReqVo.getTitle());
        productInfo.setStoreId(storeId);
        productInfo.setBrandId(productBaseReqVo.getBrandId());
        productInfo.setProductFreightType(productBaseReqVo.getProductFreightType());
        productInfo.setCategoryOneId(productBaseReqVo.getCategoryOneId());
        productInfo.setCategoryTwoId(productBaseReqVo.getCategoryTwoId());
        productInfo.setCategoryThreeId(productBaseReqVo.getCategoryThreeId());
        productInfo.setAddressFromId(productBaseReqVo.getAddressFromId());
        productInfo.setCreateAddressId(productBaseReqVo.getCreateAddressId());
        productInfo.setAboutDeliverTime(productBaseReqVo.getAboutDeliverTime());
        productInfo.setServiceIds(productBaseReqVo.getServiceIds());
        productInfo.setShelfStatus(productBaseReqVo.getShelfStatus());
        productInfo.setAuditStatus(PRODUCT_AUDIT_STATUS.NOT);
        productInfo.setDeleted(DELETED.NOT);
        productInfoMapper.addProductInfo(productInfo);
        //添加商品参数
        if (!productBaseReqVo.getParams().isEmpty()) {
            ProductParam productParam = null;
            for (ProductBaseReqVo.Param productParamReq : productBaseReqVo.getParams()) {
                productParam = new ProductParam();
                productParam.setProductId(productInfo.getProductId());
                productParam.setParamName(productParamReq.getParamName());
                productParam.setParamValue(productParamReq.getParamValue());
                productParamMapper.addProductParam(productParam);
            }
        }
        //添加商品服务
        if (!productBaseReqVo.getCustomServices().isEmpty()) {
            ProductService productService = null;
            for (String name : productBaseReqVo.getCustomServices()) {
                productService = new ProductService();
                productService.setServiceName(name);
                productService.setServiceType(1);
                productService.setProductId(productInfo.getProductId());
                productServiceMapper.addProductService(productService);
            }
        }
        Map<String, Object> res = new HashMap<>();
        res.put("product_id", productInfo.getProductId());
        res.put("product_code", productInfo.getProductCode());
        return res;
    }

    /**
     * 查询商品信息
     *
     * @param productId
     * @return
     */
    @Override
    public Map<String,Object> getProductItem(Integer productId) {
        //商品基本信息
        ProductItemRespVo productItemRespVo = productInfoMapper.getProductItemByProductId(productId);
        if (productItemRespVo == null) {
            throw new MyException("PRODUCT_INFO_NOT_EXIST", "商品信息不存在");
        }
        //商品服务
        List<ProductService> productServiceList = new ArrayList<>();
        productServiceList.addAll(productServiceMapper.getProductServiceByIds(productItemRespVo.getServiceIds()));
        productServiceList.addAll(productServiceMapper.getProductServiceByProductId(productId));
        List<ProductItemRespVo.Service> services = null;
        if (productServiceList.size() > 0){
            services = new ArrayList<>();
            ProductItemRespVo.Service service = null;
            for (ProductService productService : productServiceList){
                service = productItemRespVo.new Service();
                service.setServiceId(productService.getServiceId());
                service.setServiceName(productService.getServiceName());
                services.add(service);
            }
        }
        productItemRespVo.setServices(services);
        //商品图片
        List<ProductItemRespVo.ProductPic> productPics = null;
        List<ProductPicture> productPictures = productPictureMapper.getProductPictureListByRelationId$PicType(productId,1);
        if (productPictures != null){
            productPics = new ArrayList<>();
            ProductItemRespVo.ProductPic productPic = null;
            for (ProductPicture productPicture : productPictures){
                productPic = productItemRespVo.new ProductPic();
                productPic.setPicId(productPicture.getPicId());
                productPic.setPicUrl(productPicture.getPicUrl());
                productPic.setIsMain(productPicture.getIsMain());
                productPic.setRelationId(productPicture.getRelationId());
                productPics.add(productPic);
            }
        }
        productItemRespVo.setProductPics(productPics);
        //店铺评分信息
        StoreReviewScoreResqVo storeReviewInfo = storeInfoMapper.getStoreReviewInfo(productItemRespVo.getStoreId());
        productItemRespVo.setStoreReviewScoreResqVo(storeReviewInfo);
        Map<String,Object> res = new HashMap<>();
        res.put("data",productItemRespVo);
        return res;
    }

    /**
     * 查询商品基本信息
     *
     * @param productId
     * @return
     */
    @Override
    public ProductInfo getProductInfo(Integer productId) {
        ProductInfo productInfo = productInfoMapper.getProductInfo(productId);
        if (productId == null) {
            throw new MyException("PRODUCT_INFO_NOT_EXIST", "商品信息不存在");
        }
        return productInfo;
    }

    /**
     * 商品下架
     *
     * @param productId
     */
    @Override
    public void productInfoDownShelf(Integer productId) {
        ProductInfo productInfo = productInfoMapper.getProductInfo(productId);
        productInfo.setShelfStatus(0);
        productInfoMapper.updateProductInfo(productInfo);
    }

    /**
     * 商品审核
     *
     * @param productId
     */
    @Override
    public void productInfoAudit(Integer productId) {
        ProductInfo productInfo = productInfoMapper.getProductInfo(productId);
        productInfo.setAuditStatus(1);
        productInfoMapper.updateProductInfo(productInfo);
    }

    /**
     * 删除商品信息
     *
     * @param productId
     */
    @Override
    public void deleteProductInfo(Integer productId) {
        //删除商品信息
        productInfoMapper.deleteProductInfo(productId);
        //获取sku列表
        List<ProductSku> productSkuList = productSkuMapper.getProductSkuListByProductId(productId);
        //删除sku信息
        productSkuMapper.deleteProductSku(productId);
        //获取商品ID和SkuId
        List<Integer> relationIds = new ArrayList<>();
        relationIds.add(productId);
        if (!productSkuList.isEmpty()) {
            for (ProductSku productSku : productSkuList) {
                relationIds.add(productSku.getSkuId());
            }
        }
        //删除商品图片
        productPictureMapper.deleteProductPictureByRelationIds(relationIds);
        //删除商品参数
        productParamMapper.deleteProductParamByProductId(productId);
        //删除商品自有服务
        productServiceMapper.deleteProductServiceByProductId(productId);
        //获取商品规格名集合
        List<ProductSpecName> productSpecNameLists = productSpecNameMapper.getProductSpecNameListByProductId(productId);
        //删除商品规格名
        productSpecNameMapper.deleteProductSpecNameByProductId(productId);
        //删除商品规格值
        for (ProductSpecName productSpecName : productSpecNameLists) {
            //productSpecValueMapper.deleteProductSpecValueBySpecNameId(productSpecName.getNameId());
        }
        //删除商品详情
        productDetailsMapper.deleteProductDetailsByProductId(productId);
    }

    /**
     * 添加修改商品详情
     *
     * @param productId
     * @param detail
     */
    @Override
    public void addProductDetail(Integer productId, String detail) {
        ProductDetails productDetails = productDetailsMapper.getProductDetailsByProductId(productId);
        if (productDetails == null){
            productDetails = new ProductDetails();
            productDetails.setProductId(productId);
            productDetails.setDetails(detail);
            productDetailsMapper.addProductDetails(productDetails);
        }else {
            productDetails.setDetails(detail);
            productDetailsMapper.updateProductDetails(productDetails);
        }

    }

    /**
     * 查询商品规格
     *
     * @param productId
     * @return
     */
    @Override
    public Map<String, Object> getProductSpec(Integer productId) {
        List<ProductSpecName> productSpecNameList = productSpecNameMapper.getProductSpecNameListByProductId(productId);
        List<ProductSpecRespVo> productSpecRespVos = null;
        if (productSpecNameList != null){
            productSpecRespVos = new ArrayList<>();
            ProductSpecRespVo productSpecRespVo = null;
            List<ProductSpecRespVo.SpecValue> specValues = null;
            ProductSpecRespVo.SpecValue specValue = null;
            for (ProductSpecName productSpecName : productSpecNameList){
                productSpecRespVo = new ProductSpecRespVo();
                productSpecRespVo.setNameId(productSpecName.getNameId());
                productSpecRespVo.setSpecName(productSpecName.getSpecName());
                productSpecRespVo.setProductId(productSpecName.getProductId());
                productSpecRespVo.setSort(productSpecName.getSort());
                List<ProductSpecValue> specValueList = productSpecValueMapper.getSpecValueListByNameId(productSpecName.getNameId());
                specValues = new ArrayList<>();
                if (specValueList != null){
                    for (ProductSpecValue productSpecValue : specValueList){
                        specValue = productSpecRespVo.new SpecValue();
                        specValue.setValueId(productSpecValue.getValueId());
                        specValue.setSpecValue(productSpecValue.getSpecValue());
                        specValue.setSpecNameId(productSpecValue.getSpecNameId());
                        specValue.setSort(productSpecValue.getSort());
                        specValues.add(specValue);
                    }
                }
                productSpecRespVo.setSpecValues(specValues);
                productSpecRespVos.add(productSpecRespVo);
            }
        }
        Map<String, Object> res = new HashMap<>();
        res.put("data",productSpecRespVos);
        return res;
    }

}
