package com.kyj.cooltiger.cooltigerproduct.mapper;

import com.kyj.cooltiger.cooltigerfeign.product.vo.ProductInfoListByStoreIdRespVo;
import com.kyj.cooltiger.cooltigerproduct.entity.ProductInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liduan
 * Description: 商品信息Mapper
 * date: 2020/7/28 11:25
 */
@Repository
public interface ProductInfoMapper {

    /**
     * 根据店铺ID查询商品列表个数
     * @param storeId 店铺ID
     * @param categoryId 分类ID
     * @param keyword 搜索关键词
     * @return
     */
    public int getTotalCountByStoreId(@Param("storeId") Integer storeId,
                                      @Param("categoryId") Integer categoryId,
                                      @Param("keyword") String keyword);

    /**
     * 根据店铺ID查询商品列表
     * @param storeId 店铺ID
     * @param pageStart 分页起始值
     * @param pageSize 分页单位
     * @param categoryId 类别ID
     * @param keyword 搜索关键词
     */
    public List<ProductInfoListByStoreIdRespVo> getProductInfoListByStoreId(@Param("storeId") Integer storeId,
                                                                            @Param("pageStart") Integer pageStart,
                                                                            @Param("pageSize") Integer pageSize,
                                                                            @Param("categoryId") Integer categoryId,
                                                                            @Param("keyword") String keyword);

    /**
     * 添加商品基本信息
     * @param productInfo
     */
    public void addProductInfo(@Param("productInfo") ProductInfo productInfo);

    /**
     * 查询商品信息
     * @param productId
     * @return
     */
    public ProductInfo getProductInfo(@Param("productId") Integer productId);

    /**
     * 更新商品信息
     * @param productInfo
     */
    public void updateProductInfo(@Param("productInfo") ProductInfo productInfo);

    /**
     * 删除商品信息
     * @param productId
     */
    public void deleteProductInfo(@Param("productId") Integer productId);
}
