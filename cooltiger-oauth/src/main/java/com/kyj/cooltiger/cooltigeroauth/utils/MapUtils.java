package com.kyj.cooltiger.cooltigeroauth.utils;

import com.kyj.cooltiger.cooltigeroauth.controller.OauthController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/7/31 9:42
 * 获取map中的值工具类
 */
public class MapUtils {

    private static  final Logger logger= LoggerFactory.getLogger(MapUtils.class);

    public static String getString(Map map, Object key) {
        if (map != null) {
            Object answer = map.get(key);
            if (answer != null) {
                return answer.toString();
            }
        }
        return null;
    }

}
