package com.kyj.cooltiger.order.service;

import com.kyj.cooltiger.order.entity.Commentreview;

import java.util.Map;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/9/9 11:53
 */
public interface CommentreviewService {

    Commentreview  getcomment(Map<String,Object> map);

}
