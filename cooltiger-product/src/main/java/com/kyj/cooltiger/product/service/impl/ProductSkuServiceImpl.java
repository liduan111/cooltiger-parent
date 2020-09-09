package com.kyj.cooltiger.product.service.impl;

import com.kyj.cooltiger.common.excep.MyException;
import com.kyj.cooltiger.feign.product.vo.ProductSkuListRespVo;
import com.kyj.cooltiger.feign.product.vo.ProductSkuRespVo;
import com.kyj.cooltiger.product.entity.ProductInfo;
import com.kyj.cooltiger.product.entity.ProductPicture;
import com.kyj.cooltiger.product.entity.ProductSku;
import com.kyj.cooltiger.product.entity.ProductSpecValue;
import com.kyj.cooltiger.product.mapper.ProductInfoMapper;
import com.kyj.cooltiger.product.mapper.ProductPictureMapper;
import com.kyj.cooltiger.product.mapper.ProductSkuMapper;
import com.kyj.cooltiger.product.mapper.ProductSpecValueMapper;
import com.kyj.cooltiger.product.service.ProductSkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        res.put("data",productSkuRespVo);
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
        if (productSkuList != null){
            productSkuListRespVos = new ArrayList<>();
            ProductSkuListRespVo productSkuListRespVo = null;
            List<ProductPicture> productPictureList = null;
            List<ProductSpecValue> productSpecValueList = null;
            for (ProductSku productSku : productSkuList){
                productSkuListRespVo = new ProductSkuListRespVo();
                productSkuListRespVo.setSkuId(productSku.getSkuId());
                productSkuListRespVo.setSkuCode(productSku.getSkuCode());
                productPictureList = productPictureMapper.getProductPictureListByRelationId$PicType(productSku.getSkuId(),2);
                productSkuListRespVo.setSkuUrl(productPictureList.get(0).getPicUrl());
                productSkuListRespVo.setProductId(productSku.getProductId());
                productSkuListRespVo.setSpecValueIds(productSku.getSpecValueIds());
                //规格
                productSpecValueList = productSpecValueMapper.getSpecValueListByValueIds(productSku.getSpecValueIds());
                String specValues = "";
                for (ProductSpecValue productSpecValue : productSpecValueList){
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
        res.put("data",productSkuListRespVos);
        return res;
    }
}
