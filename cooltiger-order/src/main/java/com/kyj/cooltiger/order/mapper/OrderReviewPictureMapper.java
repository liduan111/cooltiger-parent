package com.kyj.cooltiger.order.mapper;

import com.kyj.cooltiger.order.entity.OrderReviewPicture;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liduan
 * Description: 订单图片mapper
 * date: 2020/9/10 10:53
 */
@Mapper
public interface OrderReviewPictureMapper {

    /**
     * 批量插入订单评价图片
     *
     * @param pictures
     * @return
     */
    public int batchInsertOrderReviewPicture(@Param("list") List<OrderReviewPicture> pictures);
}
