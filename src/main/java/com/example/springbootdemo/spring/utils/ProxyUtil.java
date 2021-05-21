/**
 * 文件名：ProxyUtil.java
 * 版权： Copyright 2019-2024 XIA.FENG All Rights Reserved.
 * 描述：AUTHOR_XIAFENG
 */
package com.example.springbootdemo.spring.utils;

import org.aopalliance.intercept.MethodInterceptor;
import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;

/**
 * @author xia.feng@hand-china.com
 * @version 0.1
 * @date 2021-04-26 16:53
 * @description
 */
public class ProxyUtil {

    public static <T> T createProxy (final Class<?> targetClass, final MethodInterceptor methodInterceptor) {
        return (T) Enhancer.create(targetClass, (Callback) methodInterceptor);
    }
}
