package com.wutong.framework.core.web.common.annotation;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@Retention(RUNTIME)
@Target(TYPE)
@SpringBootApplication
@ServletComponentScan
public @interface BootStrap {

}
