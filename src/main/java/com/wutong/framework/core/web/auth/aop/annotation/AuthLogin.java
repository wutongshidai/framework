package com.wutong.framework.core.web.auth.aop.annotation;

import java.lang.annotation.*;

/**
 * 用户登录验证注解
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
public @interface AuthLogin {

    boolean validate() default true;
}
