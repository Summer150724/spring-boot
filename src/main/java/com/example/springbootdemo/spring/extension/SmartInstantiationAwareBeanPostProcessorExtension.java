/**
 * 文件名：SmartInstantiationAwareBeanPostProcessorExtension.java
 * 版权： Copyright 2019-2024 XIA.FENG All Rights Reserved.
 * 描述：AUTHOR_XIAFENG
 */
package com.example.springbootdemo.spring.extension;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.SmartInstantiationAwareBeanPostProcessor;

import java.lang.reflect.Constructor;

/**
 * @author xia.feng@hand-china.com
 * @version 0.1
 * @date 2021-04-16 14:02
 * @description
 */
public class SmartInstantiationAwareBeanPostProcessorExtension implements SmartInstantiationAwareBeanPostProcessor {

    /**
     * Predict the type of the bean to be eventually returned from this
     * processor's {@link #postProcessBeforeInstantiation} callback.
     * <p>The default implementation returns {@code null}.
     *
     * @param beanClass the raw class of the bean
     * @param beanName  the name of the bean
     * @return the type of the bean, or {@code null} if not predictable
     * @throws BeansException in case of errors
     * @description 该触发点发生在 {@link #postProcessBeforeInstantiation}之前,
     * 这个方法用于预测Bean的类型，返回第一个预测成功的Class类型，
     * 如果不能预测返回null；
     * 当你调用BeanFactory.getType(name)时当通过bean的名字无法得到bean类型信息时就调用该回调方法来决定类型信息
     */
    @Override
    public Class<?> predictBeanType(Class<?> beanClass, String beanName) throws BeansException {
        return beanClass;
    }

    /**
     * Determine the candidate constructors to use for the given bean.
     * <p>The default implementation returns {@code null}.
     *
     * @param beanClass the raw class of the bean (never {@code null})
     * @param beanName  the name of the bean
     * @return the candidate constructors, or {@code null} if none specified
     * @throws BeansException in case of errors
     * @description 该触发点发生在 {@link #postProcessBeforeInstantiation}postProcessBeforeInstantiation之后，
     * 用于确定该bean的构造函数之用，返回的是该bean的所有构造函数列表。
     * 可以扩展这个点，来自定义选择相应的构造器来实例化这个bean
     */
    @Override
    public Constructor<?>[] determineCandidateConstructors(Class<?> beanClass, String beanName) throws BeansException {
        return null;
    }

    /**
     * Obtain a reference for early access to the specified bean,
     * typically for the purpose of resolving a circular reference.
     * <p>This callback gives post-processors a chance to expose a wrapper
     * early - that is, before the target bean instance is fully initialized.
     * The exposed object should be equivalent to the what
     * {@link #postProcessBeforeInitialization} / {@link #postProcessAfterInitialization}
     * would expose otherwise. Note that the object returned by this method will
     * be used as bean reference unless the post-processor returns a different
     * wrapper from said post-process callbacks. In other words: Those post-process
     * callbacks may either eventually expose the same reference or alternatively
     * return the raw bean instance from those subsequent callbacks (if the wrapper
     * for the affected bean has been built for a call to this method already,
     * it will be exposes as final bean reference by default).
     * <p>The default implementation returns the given {@code bean} as-is.
     *
     * @param bean     the raw bean instance
     * @param beanName the name of the bean
     * @return the object to expose as bean reference
     * (typically with the passed-in bean instance as default)
     * @throws BeansException in case of errors
     * @description 该触发点发生在 {@link #postProcessAfterInstantiation}之后，
     * 当有循环依赖的场景，当bean实例化好之后，
     * 为了防止有循环依赖，会提前暴露回调方法，用于bean实例化的后置处理。
     * 这个方法就是在提前暴露的回调方法中触发
     */
    @Override
    public Object getEarlyBeanReference(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
