/**
 * 文件名：BeanPostProcessorExtension.java
 * 版权： Copyright 2019-2024 XIA.FENG All Rights Reserved.
 * 描述：AUTHOR_XIAFENG
 */
package com.example.springbootdemo.spring.extension;

import com.example.springbootdemo.design_pattern.observer.observor.MyObserver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author xia.feng@hand-china.com
 * @version 0.1
 * @date 2021-04-16 10:02
 * @description
 */
@Component
@Slf4j
public class BeanPostProcessorExtension implements BeanPostProcessor {

    public static ThreadLocal<AtomicInteger> beansSerialNum = new ThreadLocal<>();
    public static ThreadLocal<Set<String>> beansSet = new ThreadLocal<>();
    /**
     * Apply this {@code BeanPostProcessor} to the given new bean instance <i>before</i> any bean
     * initialization callbacks (like InitializingBean's {@code afterPropertiesSet}
     * or a custom init-method). The bean will already be populated with property values.
     * The returned bean instance may be a wrapper around the original.
     * <p>The default implementation returns the given {@code bean} as-is.
     *
     * @param bean     the new bean instance
     * @param beanName the name of the bean
     * @return the bean instance to use, either the original or a wrapped one;
     * if {@code null}, no subsequent BeanPostProcessors will be invoked
     * @throws BeansException in case of errors
     * @see InitializingBean#afterPropertiesSet
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    /**
     * Apply this {@code BeanPostProcessor} to the given new bean instance <i>after</i> any bean
     * initialization callbacks (like InitializingBean's {@code afterPropertiesSet}
     * or a custom init-method). The bean will already be populated with property values.
     * The returned bean instance may be a wrapper around the original.
     * <p>In case of a FactoryBean, this callback will be invoked for both the FactoryBean
     * instance and the objects created by the FactoryBean (as of Spring 2.0). The
     * post-processor can decide whether to apply to either the FactoryBean or created
     * objects or both through corresponding {@code bean instanceof FactoryBean} checks.
     * <p>This callback will also be invoked after a short-circuiting triggered by a
     * {@link InstantiationAwareBeanPostProcessor#postProcessBeforeInstantiation} method,
     * in contrast to all other {@code BeanPostProcessor} callbacks.
     * <p>The default implementation returns the given {@code bean} as-is.
     *
     * @param bean     the new bean instance
     * @param beanName the name of the bean
     * @return the bean instance to use, either the original or a wrapped one;
     * if {@code null}, no subsequent BeanPostProcessors will be invoked
     * @throws BeansException in case of errors
     * @see InitializingBean#afterPropertiesSet
     * @see FactoryBean
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (Objects.isNull(beansSerialNum.get())) {
            beansSerialNum.set(new AtomicInteger(0));
        }
        if (Objects.isNull(beansSet.get())) {
            beansSet.set(new HashSet<>(16));
        }
        beansSet.get().add(beanName);
        log.info("第{}个bean({})初始化完成-{}", beansSerialNum.get().incrementAndGet(), beanName, bean);
        return bean;
    }
}
