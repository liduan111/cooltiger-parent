package com.kyj.cooltiger.cooltigerproduct.service.impl;

import com.kyj.cooltiger.cooltigercommon.utils.CharUtil;
import com.kyj.cooltiger.cooltigercommon.utils.PageUtil;
import com.kyj.cooltiger.cooltigerfeign.product.vo.ProductInfoAddReqVo;
import com.kyj.cooltiger.cooltigerfeign.product.vo.ProductInfoListByStoreIdRespVo;
import com.kyj.cooltiger.cooltigerproduct.entity.*;
import com.kyj.cooltiger.cooltigerproduct.mapper.*;
import com.kyj.cooltiger.cooltigerproduct.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    private ProductFreightMapper productFreightMapper;
    @Autowired
    private ProductDetailsMapper productDetailsMapper;

    /**
     * 根据店铺ID获取商品列表
     * @param storeId
     * @param pageNo
     * @param pageSize
     * @param categoryId
     * @param keyword
     * @return
     */
    @Override
    public Map<String,Object> getProductInfoListByStoreId(Integer storeId, Integer pageNo, Integer pageSize, Integer categoryId, String keyword) {
        //查询总条数
        int totalCount = productInfoMapper.getTotalCountByStoreId(storeId,categoryId,keyword);
        //创建分页工具类对象
        PageUtil<Object> pageUtil = new PageUtil<>(pageNo, pageSize, totalCount);
        List<ProductInfoListByStoreIdRespVo> respVoList = null;
        if(totalCount>0){
            int pageStart = (pageUtil.getPageNo()-1)*pageUtil.getPageSize();
            respVoList = productInfoMapper.getProductInfoListByStoreId(storeId, pageStart, pageSize, categoryId, keyword);
        }
        //定义返回map数据
        HashMap<String, Object> res = new HashMap<>();
        res.put("totalCoust",pageUtil.getTotalCount());
        res.put("totaoPage",pageUtil.getTotalPage());
        res.put("data",respVoList);
        return res;
    }

    /**
     * 添加商品信息
     * @param storeId 店铺ID
     * @param productInfoAddReqVo 商品参数
     */
    @Transactional
    @Override
    public void addProductInfo(Integer storeId, ProductInfoAddReqVo productInfoAddReqVo) {
        //添加商品基本信息
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductCode(CharUtil.getRandomNum(10));
        productInfo.setTitle(productInfoAddReqVo.getTitle());
        productInfo.setStoreId(storeId);
        productInfo.setBarandId(productInfoAddReqVo.getBrandId());
        productInfo.setCategoryId(productInfoAddReqVo.getCategoryId());
        productInfo.setAddressFromId(productInfoAddReqVo.getAddressFromId());
        productInfo.setCreateAddressId(productInfoAddReqVo.getCreateAddressId());
        productInfo.setAboutDeliverTime(productInfoAddReqVo.getAboutDeliverTime());
        productInfo.setServiceIds(productInfoAddReqVo.getServiceIds());
        productInfo.setShelfStatus(productInfoAddReqVo.getShelfStatus());
        productInfo.setAuditStatus(0);
        productInfo.setDeleted(0);
        productInfoMapper.addProductInfo(productInfo);
        //添加商品运费
        ProductFreight productFreight = new ProductFreight();
        productFreight.setProductId(productInfo.getProductId());
        productFreight.setProductTreightType(productInfoAddReqVo.getProductFreight().getProductFreightType());
        productFreight.setCondition(productInfoAddReqVo.getProductFreight().getCondition());
        productFreight.setPreightPrice(productInfoAddReqVo.getProductFreight().getPreightPrice());
        productFreight.setFirstWeight(productInfoAddReqVo.getProductFreight().getFirsWeight());
        productFreight.setContinueWeight(productInfoAddReqVo.getProductFreight().getContinueWeight());
        productFreight.setWhetherKg(productInfoAddReqVo.getProductFreight().getWhetherKg());
        productFreightMapper.addProductFreight(productFreight);
        //添加商品服务
        if(!productInfoAddReqVo.getCustomService().isEmpty()){
            ProductService productService = null;
            for (String name : productInfoAddReqVo.getCustomService()){
                productService = new ProductService();
                productService.setName(name);
                productService.setServiceType(1);
                productService.setProductId(productInfo.getProductId());
                productServiceMapper.addProductService(productService);
            }
        }
        //添加商品参数
        if(!productInfoAddReqVo.getProductParams().isEmpty()){
            ProductParam productParam = null;
            for(ProductInfoAddReqVo.ProductParamReq productParamReq: productInfoAddReqVo.getProductParams()){
                productParam = new ProductParam();
                productParam.setProductId(productInfo.getProductId());
                productParam.setParamName(productParamReq.getParamName());
                productParam.setParamValue(productParamReq.getParamValue());
                productParamMapper.addProductParam(productParam);
            }
        }
        //添加商品规格
        //map集合存 规格值和规格值ID
        Map<String, Integer> specValueMap = new HashMap<String,Integer>();
        if(!productInfoAddReqVo.getSpecs().isEmpty()){
            ProductSpecName productSpecName = null;
            ProductSpecValue productSpecValue = null;
            for(ProductInfoAddReqVo.Spec spec: productInfoAddReqVo.getSpecs()){
                productSpecName = new ProductSpecName();
                productSpecName.setName(spec.getSpecName());
                productSpecName.setProductId(productInfo.getProductId());
                productSpecName.setOrder(productInfoAddReqVo.getSpecs().indexOf(spec));
                productSpecNameMapper.addProductSpecName(productSpecName);
                for (String specValue: spec.getSpecValues()){
                    productSpecValue = new ProductSpecValue();
                    productSpecValue.setValue(specValue);
                    productSpecValue.setSpecNameId(productSpecName.getId());
                    productSpecValue.setOrder(spec.getSpecValues().indexOf(specValue));
                    productSpecValueMapper.addProductSpecValue(productSpecValue);
                    //map集合put规格值和ID
                    specValueMap.put(specValue,productSpecValue.getId());
                }
            }
        }
        //添加sku
        ProductPicture productPicture = null;
        if (!productInfoAddReqVo.getSkus().isEmpty()){
            ProductSku productSku = null;
            for(ProductInfoAddReqVo.Sku sku: productInfoAddReqVo.getSkus()){
                productSku = new ProductSku();
                productSku.setSkuCode(productInfo.getProductCode()+CharUtil.getRandomNum(6));
                productSku.setSkuName(sku.getSkuName());
                productSku.setProductId(productInfo.getProductId());
                String specIds = "";
                for (String specValue: sku.getSpecValues()){
                    specIds += ","+specValueMap.get(specValue).toString();
                }
                productSku.setSpecValueIds(specIds.substring(1));
                productSku.setSalePrice(sku.getSalePrice());
                productSku.setStock(sku.getStock());
                productSku.setWeight(sku.getWeight());
                productSku.setDistriType(sku.getDistriType());
                productSku.setDistriRatio(sku.getDistriRatio());
                productSku.setDistriAmount(sku.getDistriAmount());
                productSku.setDeleted(0);
                productSkuMapper.addProductSku(productSku);
                //添加图片url
                productPicture = new ProductPicture();
                productPicture.setType(2);
                productPicture.setRelationId(productSku.getSkuId());
                productPicture.setUrl(sku.getUrl());
                productPictureMapper.addProductPicture(productPicture);
            }
        }
        //添加商品图片
        if(!productInfoAddReqVo.getProductPictures().isEmpty()){
            for (ProductInfoAddReqVo.ProductPicture picture : productInfoAddReqVo.getProductPictures()){
                productPicture = new ProductPicture();
                productPicture.setType(1);
                productPicture.setRelationId(productInfo.getProductId());
                productPicture.setUrl(picture.getUrl());
                productPicture.setIsMain(picture.getIsMain());
                productPicture.setOrder(productInfoAddReqVo.getProductPictures().indexOf(picture));
                productPictureMapper.addProductPicture(productPicture);
            }
        }
        //添加商品详情
        ProductDetails productDetails = new ProductDetails();
        productDetails.setProductId(productInfo.getProductId());
        productDetails.setDetails(productInfoAddReqVo.getDetails());
        productDetailsMapper.addProductDetails(productDetails);
    }

    /**
     * 查询商品信息
     * @param productId
     * @return
     */
    @Override
    public Map<String, Object> getProductInfo(Integer productId) {
        ProductInfo productInfo = productInfoMapper.getProductInfo(productId);

        HashMap<String, Object> res = new HashMap<>();
        return res;
    }

    /**
     * 商品下架
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
     * @param productId
     */
    @Override
    public void productInfoAudit(Integer productId) {
        ProductInfo productInfo = productInfoMapper.getProductInfo(productId);
        productInfo.setAuditStatus(1);
        productInfoMapper.updateProductInfo(productInfo);
    }
}
