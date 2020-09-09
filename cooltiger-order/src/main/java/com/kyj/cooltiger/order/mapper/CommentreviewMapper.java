package com.kyj.cooltiger.order.mapper;

import com.kyj.cooltiger.order.entity.Commentreview;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/9/9 13:09
 */
@Mapper
public interface CommentreviewMapper {

    Commentreview getcomment(@Param("orderId") Integer orderId,@Param("userId") Long userId);

}
