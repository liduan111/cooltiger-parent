package com.kyj.cooltiger.cooltigergoods.mapper;

import com.kyj.cooltiger.cooltigergoods.model.Goods;
import org.springframework.stereotype.Repository;

/**
 * @author liduan
 * Description:
 * date: 2020/7/24 17:25
 */
@Repository
public interface GoodsMapper {

    public Goods getGoodsById(Integer id);
}
