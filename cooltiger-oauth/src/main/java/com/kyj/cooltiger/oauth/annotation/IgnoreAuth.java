package com.kyj.cooltiger.oauth.annotation;

import java.lang.annotation.*;

/**
 * 忽略token验证
 * @author guoxq
 * @version 1.0
 * @date 2020/7/30 16:15
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface IgnoreAuth {
}
