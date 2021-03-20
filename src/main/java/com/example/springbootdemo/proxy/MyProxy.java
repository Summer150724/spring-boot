/**
 * 文件名：MyProxy.java
 * 版权： Copyright 2019-2024 XIA.FENG All Rights Reserved.
 * 描述：AUTHOR_XIAFENG
 */
package com.example.springbootdemo.proxy;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author xia.feng@hand-china.com
 * @version 0.1
 * @date 2021-03-03 11:23
 * @description
 */
public class MyProxy extends ProxyTarget implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("代理类调用前");
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("代理类调用后");
        return result;
    }
}
