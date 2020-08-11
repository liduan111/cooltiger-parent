package com.kyj.cooltiger.cooltigerproduct.service.impl;

import com.kyj.cooltiger.cooltigercommon.excep.MyException;
import com.kyj.cooltiger.cooltigerfeign.product.vo.ProductBrandInfoReqVo;
import com.kyj.cooltiger.cooltigerproduct.entity.ProductBrandInfo;
import com.kyj.cooltiger.cooltigerproduct.mapper.ProductBrandInfoMapper;
import com.kyj.cooltiger.cooltigerproduct.service.ProductBrandInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liduan
 * Description: 商品品牌service实现类
 * date: 2020/8/11 15:39
 */
@Service
public class ProductBrandInfoServiceImpl implements ProductBrandInfoService {

    @Autowired
    private ProductBrandInfoMapper productBrandInfoMapper;

    /**
     * 添加品牌信息
     * @param productBrandInfoReqVo
     * @return
     */
    @Override
    public void addProductBrandInfo(ProductBrandInfoReqVo productBrandInfoReqVo) {
        int count = productBrandInfoMapper.getProductBrandCountByBrandName(productBrandInfoReqVo.getBrandName());
        if(count > 0){
            throw new MyException("BRAND_NAME_IS_EXIST","品牌名称已存在");
        }
        ProductBrandInfo productBrandInfo = new ProductBrandInfo();
        productBrandInfo.setBrandName(productBrandInfoReqVo.getBrandName());
        productBrandInfo.setBrandLogoUrl(productBrandInfoReqVo.getBrandLogoUrl());
        productBrandInfo.setBrandDesc(productBrandInfoReqVo.getBrandDesc());
        productBrandInfo.setBrandOrder(productBrandInfoReqVo.getBrandOrder());
        productBrandInfo.setBrandStatus(productBrandInfoReqVo.getBrandStatus());
        productBrandInfoMapper.addProductBrandInfo(productBrandInfo);
    }
}
