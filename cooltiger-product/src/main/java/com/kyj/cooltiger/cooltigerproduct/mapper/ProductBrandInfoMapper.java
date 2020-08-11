package com.kyj.cooltiger.cooltigerproduct.mapper;

import com.kyj.cooltiger.cooltigerproduct.entity.ProductBrandInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author liduan
 * Description: 商品品牌mapper
 * date: 2020/8/11 15:44
 */
@Mapper
public interface ProductBrandInfoMapper {

    /**
     * 根据品牌名称查询品牌信息个数
     * @param brandName
     * @return
     */
    public int getProductBrandCountByBrandName(@Param("brandName") String brandName);

    /**
     * 添加品牌信息
     * @param productBrandInfo
     */
    public void addProductBrandInfo(@Param("productBrandInfo") ProductBrandInfo productBrandInfo);
}
