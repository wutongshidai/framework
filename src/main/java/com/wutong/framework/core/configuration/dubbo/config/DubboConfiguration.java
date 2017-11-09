package com.wutong.framework.core.configuration.dubbo.config;


import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ModuleConfig;
import com.alibaba.dubbo.config.MonitorConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.registry.Registry;
import com.wutong.framework.core.configuration.dubbo.properties.DubboProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(DubboProperties.class)
@ConditionalOnClass({ApplicationConfig.class, ModuleConfig.class, RegistryConfig.class, MonitorConfig.class})
public class DubboConfiguration {

    @Autowired
    private DubboProperties dubboProperties;

    @Bean
    @ConditionalOnMissingBean(ApplicationConfig.class)
    public ApplicationConfig applicationConfig() {
        ApplicationConfig applicationConfig = dubboProperties.getApplication();
        if (applicationConfig == null) {
            applicationConfig = new ApplicationConfig();
        }
        return applicationConfig;
    }


    @Bean
    @ConditionalOnMissingBean(MonitorConfig.class)
    public MonitorConfig monitorConfig() {
        MonitorConfig monitorConfig = dubboProperties.getMonitor();
        if (monitorConfig == null) {
            monitorConfig = new MonitorConfig();
        }
        return monitorConfig;
    }


    @Bean
    @ConditionalOnMissingBean(RegistryConfig.class)
    public RegistryConfig registryConfig() {
        RegistryConfig registryConfig = dubboProperties.getRegistry();
        if (registryConfig == null) {
            registryConfig = new RegistryConfig();
        }
        return registryConfig;
    }

    @Bean
    @ConditionalOnMissingBean(ModuleConfig.class)
    public ModuleConfig moduleConfig() {
        ModuleConfig moduleConfig = dubboProperties.getModule();
        if (moduleConfig == null) {
            moduleConfig = new ModuleConfig();
        }
        return moduleConfig;
    }
}
