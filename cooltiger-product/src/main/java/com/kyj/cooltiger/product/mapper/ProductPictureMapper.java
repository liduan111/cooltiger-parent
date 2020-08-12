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
     * 添加商品图片
     * @param productPicture
     */
    public void addProductPicture(@Param("productPicture") ProductPicture productPicture);

    /**
     * 根据关联ids删除多个商品图片
     * @param relationIds
     */
    public void deleteProductPictureByRelationIds(List<Integer> relationIds);
}
