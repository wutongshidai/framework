package com.wutong.framework.core.configuration.dubbo.initializer;

import com.alibaba.dubbo.config.spring.AnnotationBean;
import org.springframework.beans.BeanUtils;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

public class DubboConfigurationApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        Environment env = configurableApplicationContext.getEnvironment();
        String scan = env.getProperty("spring.dubbo.scan");
        if (scan != null) {
            AnnotationBean scanner = BeanUtils.instantiate(AnnotationBean.class);
            scanner.setPackage(scan);
            scanner.setApplicationContext(configurableApplicationContext);
            configurableApplicationContext.addBeanFactoryPostProcessor(scanner);
            configurableApplicationContext.getBeanFactory().addBeanPostProcessor(scanner);
            configurableApplicationContext.getBeanFactory().registerSingleton("annotationBean", scanner);
        }
    }
}
