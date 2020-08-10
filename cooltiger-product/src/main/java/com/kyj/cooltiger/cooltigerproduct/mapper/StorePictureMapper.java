package com.kyj.cooltiger.cooltigerproduct.mapper;

import com.kyj.cooltiger.cooltigerproduct.entity.StorePicture;
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
     * 添加店铺图片信息
     * @param storePicture
     */
    public void addStorePicture(@Param("storePicture") StorePicture storePicture);

    /**
     * 查询店铺图片url
     * @param storeId
     * @return
     */
    public List<StorePicture> getStorePictureList(@Param("storeId") Integer storeId);
}
