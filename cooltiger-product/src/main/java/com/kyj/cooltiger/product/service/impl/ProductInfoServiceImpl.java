package com.kyj.cooltiger.product.service.impl;

import com.kyj.cooltiger.common.constant.DELETED;
import com.kyj.cooltiger.common.constant.PRODUCT_AUDIT_STATUS;
import com.kyj.cooltiger.common.excep.MyException;
import com.kyj.cooltiger.common.utils.CharUtil;
import com.kyj.cooltiger.common.utils.PageUtil;
import com.kyj.cooltiger.feign.product.vo.ProductBaseReqVo;
import com.kyj.cooltiger.feign.product.vo.ProductInfoListByStoreIdRespVo;
import com.kyj.cooltiger.feign.product.vo.ProductSkuReqVo;
import com.kyj.cooltiger.feign.product.vo.ProductSkuRespVo;
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
    private StoreFreightMapper productFreightMapper;
    @Autowired
    private ProductDetailsMapper productDetailsMapper;

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
                productService.setName(name);
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
     * 添加商品sku信息
     *
     * @param productId       商品ID
     * @param productSkuReqVo 商品规格和sku参数
     */
    @Transactional
    @Override
    public void addProductSkuInfo(Integer productId, ProductSkuReqVo productSkuReqVo) {
        ProductInfo productInfo = productInfoMapper.getProductInfo(productId);
        if (productId == null) {
            throw new MyException("PRODUCT_INFO_NOT_EXIST", "商品信息不存在");
        }
        //添加商品规格
        if (productSkuReqVo.getSpecs() != null && !productSkuReqVo.getSpecs().isEmpty()) {
            //规格值List
            List<ProductSpecValue> productSpecValueList = new ArrayList<>();
            ProductSpecName productSpecName = null;
            ProductSpecValue productSpecValue = null;
            for (ProductSkuReqVo.Spec spec : productSkuReqVo.getSpecs()) {
                productSpecName = new ProductSpecName();
                productSpecName.setName(spec.getSpecName());
                productSpecName.setProductId(productInfo.getProductId());
                productSpecName.setSort(productSkuReqVo.getSpecs().indexOf(spec));
                //插入规格名
                productSpecNameMapper.addProductSpecName(productSpecName);
                for (String specValue : spec.getSpecValues()) {
                    productSpecValue = new ProductSpecValue();
                    productSpecValue.setValue(specValue);
                    productSpecValue.setSpecNameId(productSpecName.getId());
                    productSpecValue.setSort(spec.getSpecValues().indexOf(specValue));
                    productSpecValueList.add(productSpecValue);
                }
            }
            //批量插入规格值
            productSpecValueMapper.batchAddProductSpecValue(productSpecValueList);
            //Map集合 key:规格值value:规格值ID
            Map<String, Integer> specValueMap = new HashMap<>();
            for (ProductSpecValue specValue : productSpecValueList) {
                specValueMap.put(specValue.getValue(), specValue.getId());
            }
            //添加sku
            ProductPicture productPicture = null;
            if (productSkuReqVo.getSkus() != null && !productSkuReqVo.getSkus().isEmpty()) {
                List<ProductSku> productSkuList = new ArrayList<>();
                List<ProductPicture> productPictureList = new ArrayList<>();
                ProductSku productSku = null;
                for (ProductSkuReqVo.Sku sku : productSkuReqVo.getSkus()) {
                    productSku = new ProductSku();
                    productSku.setSkuCode(productInfo.getProductCode() + CharUtil.getRandomNum(6));
                    productSku.setProductId(productInfo.getProductId());
                    String specIds = "";
                    for (String specValue : sku.getSpecValues()) {
                        specIds += "," + specValueMap.get(specValue).toString();
                    }
                    productSku.setSpecValueIds(specIds.substring(1));
                    productSku.setSalePrice(sku.getSalePrice());
                    productSku.setStock(sku.getStock());
                    productSku.setWeight(sku.getWeight());
                    productSku.setDistriType(sku.getDistriType());
                    productSku.setDistriRatio(sku.getDistriRatio());
                    productSku.setDistriAmount(sku.getDistriAmount());
                    productSku.setDeleted(0);
                    productSkuList.add(productSku);
                    //添加图片url
                    productPicture = new ProductPicture();
                    productPicture.setPicType(2);
                    productPicture.setPicUrl(sku.getPicUrl());
                    productPictureList.add(productPicture);
                }
                //批量插入sku信息
                productSkuMapper.batchAddProductSku(productSkuList);
                for (ProductPicture picture : productPictureList) {
                    picture.setRelationId(productSkuList.get(productPictureList.indexOf(picture)).getSkuId());
                }
                //批量插入sku图片信息
                productPictureMapper.batchAddProductPicture(productPictureList);
            }
        }
    }

    /**
     * 查询商品信息
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
            productSpecValueMapper.deleteProductSpecValueBySpecNameId(productSpecName.getId());
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
     * 查询商品sku信息
     *
     * @param skuId
     * @return
     */
    @Override
    public Map<String,Object> getProductSku(Integer skuId) {
        ProductSku productSku = productSkuMapper.getProductSkuBySkuId(skuId);
        if (productSku == null){
            throw new MyException("SKU_INFO_NOT_EXIST","商Sku信息不存在");
        }
        ProductInfo productInfo = productInfoMapper.getProductInfo(productSku.getProductId());
        List<ProductPicture> productPictureList = productPictureMapper.getProductPictureListByRelationId$PicType(skuId,2);
        List<ProductSpecValue> productSpecValueList = productSpecValueMapper.getSpecValueListByValueIds(productSku.getSpecValueIds());
        String specValues = "";
        for (ProductSpecValue productSpecValue : productSpecValueList){
            specValues += ";" + productSpecValue.getValue();
        }
        ProductSkuRespVo productSkuRespVo = new ProductSkuRespVo();
        productSkuRespVo.setSkuId(productSku.getSkuId());
        productSkuRespVo.setSkuCode(productSku.getSkuCode());
        productSkuRespVo.setSkuUrl(productPictureList.get(0).getPicUrl());
        productSkuRespVo.setProductId(productSku.getProductId());
        productSkuRespVo.setProductTitle(productInfo.getTitle());
        productSkuRespVo.setProductFreightType(productInfo.getProductFreightType());
        productSkuRespVo.setSpecValues(specValues.substring(1));
        productSkuRespVo.setSalePrice(productSku.getSalePrice());
        productSkuRespVo.setWeight(productSku.getWeight());
        productSkuRespVo.setStock(productSku.getStock());
        productSkuRespVo.setDistriType(productSku.getDistriType());
        productSkuRespVo.setDistriRatio(productSku.getDistriRatio());
        productSkuRespVo.setDistriAmount(productSku.getDistriAmount());
        Map<String, Object> res = new HashMap<>();
        res.put("data",productSkuRespVo);
        return res;
    }

}
