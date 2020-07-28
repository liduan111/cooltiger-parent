package com.kyj.cooltiger.cooltigerfeign.clients.goods;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author liduan
 * Description:
 * date: 2020/7/27 15:29
 */
@FeignClient(name = "Goods-Service")
public interface GoodsCilent {

    @RequestMapping(value = "/goods/getById/{id}",method = {RequestMethod.GET})
    public String getGoodsById(@PathVariable("id") Integer id);

}
