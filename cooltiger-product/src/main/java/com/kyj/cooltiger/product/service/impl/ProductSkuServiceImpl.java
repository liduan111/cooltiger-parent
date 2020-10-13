package com.kyj.cooltiger.product.service.impl;

import com.kyj.cooltiger.common.constant.DELETED;
import com.kyj.cooltiger.common.excep.MyException;
import com.kyj.cooltiger.common.utils.CharUtil;
import com.kyj.cooltiger.feign.product.vo.ProductSkuListRespVo;
import com.kyj.cooltiger.feign.product.vo.ProductSkuReqVo;
import com.kyj.cooltiger.feign.product.vo.ProductSkuRespVo;
import com.kyj.cooltiger.feign.product.vo.ProductSpecReqVo;
import com.kyj.cooltiger.product.entity.*;
import com.kyj.cooltiger.product.mapper.*;
import com.kyj.cooltiger.product.service.ProductSkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liduan
 * Description: 商品sku service实现类
 * date: 2020/9/8 13:35
 */
@Service
public class ProductSkuServiceImpl implements ProductSkuService {

    @Autowired
    private ProductSkuMapper productSkuMapper;
    @Autowired
    private ProductInfoMapper productInfoMapper;
    @Autowired
    private ProductPictureMapper productPictureMapper;
    @Autowired
    private ProductSpecValueMapper productSpecValueMapper;
    @Autowired
    private ProductSpecNameMapper productSpecNameMapper;

    /**
     * 查询商品sku信息
     *
     * @param skuId
     * @return
     */
    @Override
    public Map<String, Object> getProductSku(Integer skuId) {
        ProductSku productSku = productSkuMapper.getProductSkuBySkuId(skuId);
        if (productSku == null) {
            throw new MyException("SKU_INFO_NOT_EXIST", "商Sku信息不存在");
        }
        ProductInfo productInfo = productInfoMapper.getProductInfo(productSku.getProductId());
        List<ProductPicture> productPictureList = productPictureMapper.getProductPictureListByRelationId$PicType(skuId, 2);
        List<ProductSpecValue> productSpecValueList = productSpecValueMapper.getSpecValueListByValueIds(productSku.getSpecValueIds());
        String specValues = "";
        for (ProductSpecValue productSpecValue : productSpecValueList) {
            specValues += ";" + productSpecValue.getSpecValue();
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
        res.put("data", productSkuRespVo);
        return res;
    }

    /**
     * 查询商品sku列表
     *
     * @param productId
     * @return
     */
    @Override
    public Map<String, Object> getProductSkuList(Integer productId) {
        List<ProductSku> productSkuList = productSkuMapper.getProductSkuListByProductId(productId);
        List<ProductSkuListRespVo> productSkuListRespVos = null;
        if (productSkuList != null) {
            productSkuListRespVos = new ArrayList<>();
            ProductSkuListRespVo productSkuListRespVo = null;
            List<ProductPicture> productPictureList = null;
            List<ProductSpecValue> productSpecValueList = null;
            for (ProductSku productSku : productSkuList) {
                productSkuListRespVo = new ProductSkuListRespVo();
                productSkuListRespVo.setSkuId(productSku.getSkuId());
                productSkuListRespVo.setSkuCode(productSku.getSkuCode());
                productPictureList = productPictureMapper.getProductPictureListByRelationId$PicType(productSku.getSkuId(), 2);
                productSkuListRespVo.setSkuUrl(productPictureList.get(0).getPicUrl());
                productSkuListRespVo.setProductId(productSku.getProductId());
                productSkuListRespVo.setSpecValueIds(productSku.getSpecValueIds());
                //规格
                productSpecValueList = productSpecValueMapper.getSpecValueListByValueIds(productSku.getSpecValueIds());
                String specValues = "";
                for (ProductSpecValue productSpecValue : productSpecValueList) {
                    specValues += ";" + productSpecValue.getSpecValue();
                }
                productSkuListRespVo.setSpecValues(specValues.substring(1));
                productSkuListRespVo.setSalePrice(productSku.getSalePrice());
                productSkuListRespVo.setWeight(productSku.getWeight());
                productSkuListRespVo.setStock(productSku.getStock());
                productSkuListRespVo.setDistriType(productSku.getDistriType());
                productSkuListRespVo.setDistriRatio(productSku.getDistriRatio());
                productSkuListRespVo.setDistriAmount(productSku.getDistriAmount());
                productSkuListRespVos.add(productSkuListRespVo);
            }
        }
        Map<String, Object> res = new HashMap<>();
        res.put("data", productSkuListRespVos);
        return res;
    }

    /**
     * 添加商品规格
     *
     * @param productId
     * @param specs
     */
    public Map<String, Integer> addProductSpec(Integer productId, List<ProductSpecReqVo.Spec> specs) {
        ProductInfo productInfo = productInfoMapper.getProductInfo(productId);
        if (productInfo == null) {
            throw new MyException("PRODUCT_INFO_NOT_EXIST", "商品信息不存在");
        }
        //返回结果集Map<规格值,规格值ID>
        Map<String, Integer> res = new HashMap<>();
        if (specs != null) {
            List<ProductSpecName> productSpecNames = productSpecNameMapper.getProductSpecNameListByProductId(productId);
            if (productSpecNames != null) {
                //删除规格名
                productSpecNameMapper.deleteProductSpecNameByProductId(productId);
                StringBuilder specNameIds = new StringBuilder();
                for (ProductSpecName productSpecName : productSpecNames) {
                    specNameIds.append(",").append(productSpecName.getNameId());
                }
                //删除规格值
                productSpecValueMapper.deleteProductSpecValueBySpecNameIds(specNameIds.toString().substring(1));
            }
            //添加规格
            List<ProductSpecValue> productSpecValueList = new ArrayList<>();
            ProductSpecName productSpecName = null;
            ProductSpecValue productSpecValue = null;
            for (ProductSpecReqVo.Spec spec : specs) {
                productSpecName = new ProductSpecName();
                productSpecName.setSpecName(spec.getSpecName());
                productSpecName.setProductId(productInfo.getProductId());
                productSpecName.setSort(specs.indexOf(spec));
                //插入规格名
                productSpecNameMapper.addProductSpecName(productSpecName);
                for (String specValue : spec.getSpecValues()) {
                    productSpecValue = new ProductSpecValue();
                    productSpecValue.setSpecValue(specValue);
                    productSpecValue.setSpecNameId(productSpecName.getNameId());
                    productSpecValue.setSort(spec.getSpecValues().indexOf(specValue));
                    productSpecValueList.add(productSpecValue);
                }
            }
            //批量插入规格值
            productSpecValueMapper.batchAddProductSpecValue(productSpecValueList);
            for (ProductSpecValue specValue : productSpecValueList) {
                res.put(specValue.getSpecValue(), specValue.getValueId());
            }
        } else {
            throw new MyException("SPEC_NOT_NULL", "规格不能为空");
        }
        return res;
    }

    /**
     * 添加商品sku信息
     *
     * @param productId        商品ID
     * @param productSkuReqVos 商品规格和sku参数
     */
    @Transactional
    @Override
    public void addProductSkuInfo(Integer productId, List<ProductSkuReqVo> productSkuReqVos) {
        ProductInfo productInfo = productInfoMapper.getProductInfo(productId);
        if (productId == null) {
            throw new MyException("PRODUCT_INFO_NOT_EXIST", "商品信息不存在");
        }
        //添加sku
        ProductPicture productPicture = null;
        if (productSkuReqVos != null && !productSkuReqVos.isEmpty()) {
            List<ProductSku> productSkuList = new ArrayList<>();
            List<ProductPicture> productPictureList = new ArrayList<>();
            ProductSku productSku = null;
            for (ProductSkuReqVo sku : productSkuReqVos) {
                productSku = new ProductSku();
                productSku.setSkuCode(productInfo.getProductCode() + CharUtil.getRandomNum(6));
                productSku.setProductId(productInfo.getProductId());
                productSku.setSpecValueIds(sku.getSpecValueIds());
                productSku.setSalePrice(sku.getSalePrice());
                productSku.setStock(sku.getStock());
                productSku.setWeight(sku.getWeight());
                productSku.setDistriType(sku.getDistriType());
                productSku.setDistriValue(sku.getDistriValue());
                productSku.setDeleted(DELETED.NOT);
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
}
