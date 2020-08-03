package com.kyj.cooltiger.cooltigerproduct.service.impl;

import com.kyj.cooltiger.cooltigercommon.utils.PageUtil;
import com.kyj.cooltiger.cooltigerproduct.mapper.ProductInfoMapper;
import com.kyj.cooltiger.cooltigerproduct.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liduan
 * Description: 商品信息接口实现类
 * date: 2020/7/28 11:23
 */
@Service
public class ProductInfoServiceImpl implements ProductInfoService {

    @Autowired
    private ProductInfoMapper productInfoMapper;

    /**
     * 根据店铺ID获取商品列表
     * @param storeId
     * @param pageNo
     * @param pageSize
     * @param categoryId
     * @param keyword
     * @return
     */
    @Override
    public Object getProductInfoListByStoreId(String storeId, Integer pageNo, Integer pageSize, Integer categoryId, String keyword) {
        //查询总条数
        int totalCount = productInfoMapper.getTotalCountByStoreId(storeId);
        //创建分页工具类对象
        PageUtil<Object> pageUtil = new PageUtil<>(pageNo, pageSize, totalCount);
        if(totalCount>0){

        }else{
            pageUtil.setLists(null);
        }

        return null;
    }
}
