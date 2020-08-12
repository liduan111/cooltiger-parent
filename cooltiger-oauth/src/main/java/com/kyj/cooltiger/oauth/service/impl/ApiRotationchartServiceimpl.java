package com.kyj.cooltiger.oauth.service.impl;

import com.kyj.cooltiger.oauth.dao.RotationchartDao;
import com.kyj.cooltiger.oauth.entity.RotationchartVo;
import com.kyj.cooltiger.oauth.service.ApiRotationchartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/8/6 11:08
 */
@Service
public class ApiRotationchartServiceimpl implements ApiRotationchartService {


    @Autowired
    private RotationchartDao rotationchartDao;

    @Override
    public List<RotationchartVo> querypicturelist(Map<String, Object> param1) {
        return rotationchartDao.querypicturelist(param1);
    }
}
