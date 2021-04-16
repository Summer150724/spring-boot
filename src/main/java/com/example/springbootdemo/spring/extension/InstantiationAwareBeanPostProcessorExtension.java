/**
 * 文件名：InstantiationAwareBeanPostProcessorExtension.java
 * 版权： Copyright 2019-2024 XIA.FENG All Rights Reserved.
 * 描述：AUTHOR_XIAFENG
 */
package com.example.springbootdemo.spring.extension;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * @author xia.feng@hand-china.com
 * @version 0.1
 * @date 2021-04-16 13:22
 * @description 接口继承了BeanPostProcess接口，区别如下：
 * BeanPostProcess接口只在bean的初始化阶段进行扩展（注入spring上下文前后），
 * 而InstantiationAwareBeanPostProcessor接口在此基础上增加了3个方法，
 * 把可扩展的范围增加了实例化阶段和属性注入阶段。
 */
@Component
@Slf4j
public class InstantiationAwareBeanPostProcessorExtension implements InstantiationAwareBeanPostProcessor {

    //TODO 如果我又重写了BeanPostProcessor的两个方法,那么到底会走哪里?

    /**
     * Apply this BeanPostProcessor <i>before the target bean gets instantiated</i>.
     * The returned bean object may be a proxy to use instead of the target bean,
     * effectively suppressing default instantiation of the target bean.
     * <p>If a non-null object is returned by this method, the bean creation process
     * will be short-circuited. The only further processing applied is the
     * {@link #postProcessAfterInitialization} callback from the configured
     * {@link BeanPostProcessor BeanPostProcessors}.
     * <p>This callback will be applied to bean definitions with their bean class,
     * as well as to factory-method definitions in which case the returned bean type
     * will be passed in here.
     * <p>Post-processors may implement the extended
     * {@link SmartInstantiationAwareBeanPostProcessor} interface in order
     * to predict the type of the bean object that they are going to return here.
     * <p>The default implementation returns {@code null}.
     *
     * @param beanClass the class of the bean to be instantiated
     * @param beanName  the name of the bean
     * @return the bean object to expose instead of a default instance of the target bean,
     * or {@code null} to proceed with default instantiation
     * @throws BeansException in case of errors
     * @see #postProcessAfterInstantiation
     * @see AbstractBeanDefinition#getBeanClass()
     * @see AbstractBeanDefinition#getFactoryMethodName()
     * @description 实例化bean之前，相当于new这个bean之前
     */
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        log.info("Mycroft-postProcessBeforeInstantiation,beanName:{}", beanName);
        return null;
    }

    /**
     * Perform operations after the bean has been instantiated, via a constructor or factory method,
     * but before Spring property population (from explicit properties or autowiring) occurs.
     * <p>This is the ideal callback for performing custom field injection on the given bean
     * instance, right before Spring's autowiring kicks in.
     * <p>The default implementation returns {@code true}.
     *
     * @param bean     the bean instance created, with properties not having been set yet
     * @param beanName the name of the bean
     * @return {@code true} if properties should be set on the bean; {@code false}
     * if property population should be skipped. Normal implementations should return {@code true}.
     * Returning {@code false} will also prevent any subsequent InstantiationAwareBeanPostProcessor
     * instances being invoked on this bean instance.
     * @throws BeansException in case of errors
     * @see #postProcessBeforeInstantiation
     * @decription 实例化bean之后，相当于new这个bean之后
     */
    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        log.info("Mycroft-postProcessAfterInstantiation,beanName:{}", beanName);
        return true;
    }

    /**
     * Post-process the given property values before the factory applies them
     * to the given bean, without any need for property descriptors.
     * <p>Implementations should return {@code null} (the default) if they provide a custom
     * {@link #postProcessPropertyValues} implementation, and {@code pvs} otherwise.
     * In a future version of this interface (with {@link #postProcessPropertyValues} removed),
     * the default implementation will return the given {@code pvs} as-is directly.
     *
     * @param pvs      the property values that the factory is about to apply (never {@code null})
     * @param bean     the bean instance created, but whose properties have not yet been set
     * @param beanName the name of the bean
     * @return the actual property values to apply to the given bean (can be the passed-in
     * PropertyValues instance), or {@code null} which proceeds with the existing properties
     * but specifically continues with a call to {@link #postProcessPropertyValues}
     * (requiring initialized {@code PropertyDescriptor}s for the current bean class)
     * @throws BeansException in case of errors
     * @see #postProcessPropertyValues
     * @since 5.1
     * @description bean已经实例化完成，在属性注入时阶段触发，@Autowired,@Resource等注解原理基于此方法实现
     */
    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        log.info("Mycroft-postProcessProperties,beanName:{}, PropertyValues:{}", beanName, pvs);
        return pvs;
    }


}
