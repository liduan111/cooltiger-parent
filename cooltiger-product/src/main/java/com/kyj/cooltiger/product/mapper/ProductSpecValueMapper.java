package com.kyj.cooltiger.product.mapper;

import com.kyj.cooltiger.product.entity.ProductSpecValue;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liduan
 * Description: 商品规格值mapper
 * date: 2020/8/4 14:32
 */
@Mapper
public interface ProductSpecValueMapper {

    /**
     * 批量添加商品规格值
     *
     * @param productSpecValueList
     */
    public void batchAddProductSpecValue(@Param("list") List<ProductSpecValue> productSpecValueList);

    /**
     * 根据商品规格名ID删除商品规格值
     *
     * @param specNameId
     */
    public void deleteProductSpecValueBySpecNameId(@Param("specNameId") Integer specNameId);

    /**
     * 根据id字符串查询规格值集合
     *
     * @param specValueIds
     * @return
     */
    public List<ProductSpecValue> getSpecValueListByValueIds(@Param("specValueIds") String specValueIds);

    /**
     * 根据规格名ID获取规格值集合
     *
     * @param specNameId
     * @return
     */
    public List<ProductSpecValue> getSpecValueListByNameId(@Param("specNameId") Integer specNameId);
}
