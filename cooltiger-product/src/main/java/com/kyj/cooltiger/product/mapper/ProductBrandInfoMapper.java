package com.kyj.cooltiger.product.mapper;

import com.kyj.cooltiger.product.entity.ProductBrandInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liduan
 * Description: 商品品牌mapper
 * date: 2020/8/11 15:44
 */
@Mapper
public interface ProductBrandInfoMapper {

    /**
     * 根据品牌名称查询品牌信息个数
     *
     * @param brandName
     * @return
     */
    public int getProductBrandCountByBrandName(@Param("brandName") String brandName);

    /**
     * 添加品牌信息
     *
     * @param productBrandInfo
     */
    public void addProductBrandInfo(@Param("productBrandInfo") ProductBrandInfo productBrandInfo);

    /**
     * 查询商品品牌列表个数
     *
     * @param keyword
     * @return
     */
    public int getProductBrandListCountByKeyword(@Param("keyword") String keyword);

    /**
     * 查询商品品牌列表
     *
     * @param pageStart
     * @param pageSize
     * @param keyword
     * @return
     */
    public List<ProductBrandInfo> getProductBrandInfoList(
            @Param("pageStart") Integer pageStart, @Param("pageSize") Integer pageSize, @Param("keyword") String keyword);

    /**
     * 根据品牌ID查询品牌信息
     *
     * @param brandId
     * @return
     */
    public ProductBrandInfo getProductBrandInfoByBrandId(@Param("brandId") Integer brandId);

    /**
     * 修改品牌信息
     *
     * @param productBrandInfo
     */
    public void updateProductBrandInfo(@Param("productBrandInfo") ProductBrandInfo productBrandInfo);

    /**
     * 删除品牌信息
     * @param brandId
     */
    public void delProductBrandInfo(@Param("brandId") Integer brandId);
}
