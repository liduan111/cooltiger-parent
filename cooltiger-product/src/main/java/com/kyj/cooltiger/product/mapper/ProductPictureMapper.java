package com.kyj.cooltiger.product.mapper;

import com.kyj.cooltiger.product.entity.ProductPicture;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liduan
 * Description: 商品图片mapper
 * date: 2020/8/4 16:56
 */
@Mapper
public interface ProductPictureMapper {
    /**
     * 批量插入图片信息
     *
     * @param productPictureList
     */
    public void batchAddProductPicture(@Param("list") List<ProductPicture> productPictureList);

    /**
     * 根据关联ids删除多个商品图片
     *
     * @param relationIds
     */
    public void deleteProductPictureByRelationIds(List<Integer> relationIds);
}
