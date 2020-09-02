package com.kyj.cooltiger.product.service.impl;

import com.kyj.cooltiger.common.constant.PRODUCT_IMAGE_TYPE;
import com.kyj.cooltiger.product.entity.ProductPicture;
import com.kyj.cooltiger.product.mapper.ProductPictureMapper;
import com.kyj.cooltiger.product.service.ProductPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * @author liduan
 * Description: 商品图片service实现类
 * date: 2020/9/1 16:22
 */
@Service
public class ProductPictureServiceImpl implements ProductPictureService {

    @Autowired
    private ProductPictureMapper productPictureMapper;

    /**
     * 添加商品图片
     *
     * @param productId 商品ID
     * @param picUrls   图片url
     */
    @Override
    public void addProductPicture(Integer productId, List<String> picUrls) {
        List<ProductPicture> productPictureList = new ArrayList<>();
        ProductPicture productPicture = null;
        for (String picUrl : picUrls){
            productPicture = new ProductPicture();
            productPicture.setPicType(PRODUCT_IMAGE_TYPE.INFO);
            productPicture.setRelationId(productId);
            productPicture.setPicUrl(picUrl);
            productPicture.setSort(picUrls.indexOf(picUrl));
            productPictureList.add(productPicture);
        }
        //批量添加商品图片
        productPictureMapper.batchAddProductPicture(productPictureList);
    }
}
