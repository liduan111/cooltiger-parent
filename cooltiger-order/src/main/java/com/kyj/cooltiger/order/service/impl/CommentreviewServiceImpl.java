package com.kyj.cooltiger.order.service.impl;

import com.kyj.cooltiger.common.excep.MyException;
import com.kyj.cooltiger.order.entity.Commentreview;
import com.kyj.cooltiger.order.mapper.CommentreviewMapper;
import com.kyj.cooltiger.order.service.CommentreviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/9/9 13:08
 */
@Service
public class CommentreviewServiceImpl implements CommentreviewService {

    @Autowired
    private CommentreviewMapper commentreviewMapper;

    @Override
    public Commentreview getcomment(Map<String, Object> map) {
        Integer  orderId=Integer.valueOf(map.get("orderId").toString());
        Long  userId=Long.valueOf(map.get("userId").toString());
        Commentreview  commentreview=commentreviewMapper.getcomment(orderId,userId);
        if (commentreview==null||commentreview.equals("")){
            new MyException("SOURCE_NOT_EXIST","当前数据不存在");
        }
        return commentreview;
    }
}
