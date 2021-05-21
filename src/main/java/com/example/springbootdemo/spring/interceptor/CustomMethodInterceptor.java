/**
 * 文件名：CustomMethodInterceptor.java
 * 版权： Copyright 2019-2024 XIA.FENG All Rights Reserved.
 * 描述：AUTHOR_XIAFENG
 */
package com.example.springbootdemo.spring.interceptor;


import com.example.springbootdemo.spring.configuration.InterceptorConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

/**
 * @author xia.feng@hand-china.com
 * @version 0.1
 * @date 2021-04-26 15:41
 * @description 没啥鸟用,直接切面拦截Controller是一样的
 * @see InterceptorConfiguration
 */

@Slf4j
public class CustomMethodInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        log.debug("Mycroft_beforeMethodInvoke");
        Object result = methodInvocation.proceed();
        log.debug("Mycroft_afterMethodInvoke");
        return result;
    }
}
