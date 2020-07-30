package com.kyj.cooltiger.cooltigerproduct.service.impl;

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

}
