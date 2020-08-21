package com.kyj.cooltiger.order.mapper;

import com.kyj.cooltiger.order.entity.RefundReason;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/8/21 14:02
 * 退款原因
 */
@Mapper
public interface RefundReasonMapper {
    /**
     * 查询原因类型
     * @return
     */
    List<RefundReason> refundReasonList();
}
