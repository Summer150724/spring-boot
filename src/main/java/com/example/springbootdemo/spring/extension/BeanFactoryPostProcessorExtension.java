/**
 * 文件名：BeanFactoryPostProcessorExtension.java
 * 版权： Copyright 2019-2024 XIA.FENG All Rights Reserved.
 * 描述：AUTHOR_XIAFENG
 */
package com.example.springbootdemo.spring.extension;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @author xia.feng@hand-china.com
 * @version 0.1
 * @date 2021-04-16 13:19
 * @description beanFactory的扩展接口，调用时机在spring在读取beanDefinition信息之后，实例化bean之前
 * @scenario 在这个时机，可以通过实现这个扩展接口来自行处理一些东西，比如修改已经注册的beanDefinition的元信息
 * @see BeanDefinitionRegistryPostProcessorExtension#postProcessBeanFactory(org.springframework.beans.factory.config.ConfigurableListableBeanFactory)
 */
@Component
@Slf4j
public class BeanFactoryPostProcessorExtension implements BeanFactoryPostProcessor {

    /**
     * Modify the application context's internal bean factory after its standard
     * initialization. All bean definitions will have been loaded, but no beans
     * will have been instantiated yet. This allows for overriding or adding
     * properties even to eager-initializing beans.
     *
     * @param beanFactory the bean factory used by the application context
     * @throws BeansException in case of errors
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        log.info("Mycroft-ConfigurableListableBeanFactory:{}", beanFactory);
    }
}
