package com.kyj.cooltiger.product.mapper;

import com.kyj.cooltiger.product.entity.StorePicture;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liduan
 * Description: 店铺图片mapper
 * date: 2020/8/6 9:32
 */
@Mapper
public interface StorePictureMapper {

    /**
     * 批量添加店铺图片信息
     * @param storePictures
     */
    public void addStorePicture(@Param("storePictures") List<StorePicture> storePictures);

    /**
     * 查询店铺图片url
     * @param storeId
     * @return
     */
    public List<StorePicture> getStorePictureList(@Param("storeId") Integer storeId);
}
