package com.kyj.cooltiger.product.service.impl;

import com.kyj.cooltiger.common.excep.MyException;
import com.kyj.cooltiger.common.utils.PageUtil;
import com.kyj.cooltiger.feign.product.vo.ProductBrandInfoReqVo;
import com.kyj.cooltiger.product.entity.ProductBrandInfo;
import com.kyj.cooltiger.product.mapper.ProductBrandInfoMapper;
import com.kyj.cooltiger.product.service.ProductBrandInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liduan
 * Description: 商品品牌service实现类
 * date: 2020/8/11 15:39
 */
@Service
public class ProductBrandInfoServiceImpl implements ProductBrandInfoService {

    @Autowired
    private ProductBrandInfoMapper productBrandInfoMapper;

    /**
     * 添加品牌信息
     *
     * @param productBrandInfoReqVo
     * @return
     */
    @Override
    public void addProductBrandInfo(ProductBrandInfoReqVo productBrandInfoReqVo) {
        int count = productBrandInfoMapper.getProductBrandCountByBrandName(productBrandInfoReqVo.getBrandName());
        if (count > 0) {
            throw new MyException("BRAND_NAME_IS_EXIST", "品牌名称已存在");
        }
        ProductBrandInfo productBrandInfo = new ProductBrandInfo();
        productBrandInfo.setBrandName(productBrandInfoReqVo.getBrandName());
        productBrandInfo.setBrandLogoUrl(productBrandInfoReqVo.getBrandLogoUrl());
        productBrandInfo.setBrandDesc(productBrandInfoReqVo.getBrandDesc());
        productBrandInfo.setBrandOrder(productBrandInfoReqVo.getBrandOrder());
        productBrandInfo.setBrandStatus(productBrandInfoReqVo.getBrandStatus());
        productBrandInfoMapper.addProductBrandInfo(productBrandInfo);
    }

    /**
     * 查询品牌信息列表
     *
     * @param pageNo
     * @param pageSize
     * @param keyword
     * @return
     */
    @Override
    public Map<String, Object> getProductBrandInfoList(Integer pageNo, Integer pageSize, String keyword) {
        //查询总条数
        int totalCount = productBrandInfoMapper.getProductBrandListCountByKeyword(keyword);
        //创建分页工具类对象
        PageUtil<Object> pageUtil = new PageUtil<>(pageNo, pageSize, totalCount);
        List<ProductBrandInfo> productBrandInfoList = null;
        if (totalCount > 0) {
            int pageStart = (pageUtil.getPageNo() - 1) * pageUtil.getPageSize();
            productBrandInfoList = productBrandInfoMapper.getProductBrandInfoList(pageStart, pageSize, keyword);
        }
        Map<String, Object> resMap = new HashMap<>();
        resMap.put("totalCount", totalCount);
        resMap.put("totalPage", pageUtil.getPageSize());
        resMap.put("data", productBrandInfoList);
        return resMap;
    }

    /**
     * 修改品牌信息
     *
     * @param brandId
     * @param productBrandInfoReqVo
     */
    @Override
    public void updateProductBrandInfo(Integer brandId, ProductBrandInfoReqVo productBrandInfoReqVo) {
        ProductBrandInfo productBrandInfo = productBrandInfoMapper.getProductBrandInfoByBrandId(brandId);
        if (productBrandInfo == null) {
            throw new MyException("BRAND_INFO_NOT_EXIST", "品牌信息不存在");
        }
        int count = productBrandInfoMapper.getProductBrandCountByBrandName(productBrandInfoReqVo.getBrandName());
        if (!productBrandInfo.getBrandName().equals(productBrandInfoReqVo.getBrandName()) && count > 0) {
            throw new MyException("BRAND_NAME_IS_EXIST", "品牌名称已存在");
        }
        productBrandInfo.setBrandName(productBrandInfoReqVo.getBrandName());
        productBrandInfo.setBrandLogoUrl(productBrandInfoReqVo.getBrandLogoUrl());
        productBrandInfo.setBrandDesc(productBrandInfoReqVo.getBrandDesc());
        productBrandInfo.setBrandOrder(productBrandInfoReqVo.getBrandOrder());
        productBrandInfo.setBrandStatus(productBrandInfoReqVo.getBrandStatus());
        productBrandInfoMapper.updateProductBrandInfo(productBrandInfo);
    }

    /**
     * 删除品牌信息
     *
     * @param brandId
     */
    @Override
    public void delProductBrandInfo(Integer brandId) {
        ProductBrandInfo productBrandInfo = productBrandInfoMapper.getProductBrandInfoByBrandId(brandId);
        if (productBrandInfo == null) {
            throw new MyException("BRAND_INFO_NOT_EXIST", "品牌信息不存在");
        }
        productBrandInfoMapper.delProductBrandInfo(brandId);
    }
}
