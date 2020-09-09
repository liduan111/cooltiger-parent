package com.kyj.cooltiger.order.mapper;

import com.kyj.cooltiger.order.entity.RefundApplication;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/9/8 15:05
 */
@Mapper
public interface RefundApplicationMapper {

    int  saves(RefundApplication refundApplication);

}
