package com.kyj.cooltiger.product.service;

import java.util.List;

/**
 * @author liduan
 * Description: 商品图片Service
 * date: 2020/9/1 16:21
 */
public interface ProductPictureService {

    /**
     * 添加商品图片
     *
     * @param productId 商品ID
     * @param picUrls   图片url
     */
    public void addProductPicture(Integer productId, List<String> picUrls);
}
