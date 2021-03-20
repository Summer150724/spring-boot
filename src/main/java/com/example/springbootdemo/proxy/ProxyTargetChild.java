/**
 * 文件名：ProxyTargetChild.java
 * 版权： Copyright 2019-2024 XIA.FENG All Rights Reserved.
 * 描述：AUTHOR_XIAFENG
 */
package com.example.springbootdemo.proxy;

import org.springframework.stereotype.Service;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author xia.feng@hand-china.com
 * @version 0.1
 * @date 2021-03-03 15:24
 * @description
 */
@Service("ProxyTargetChild")
public class ProxyTargetChild extends ProxyTarget {

    @Override
    public void invoke() {
        System.out.println("子方法调用,当前线程:" + Thread.currentThread().getName());
    }

    @Override
    public void invokeSync () {
        super.invokeSync();
        System.out.println("子类同步调用, 当前线程:" + Thread.currentThread().getName());
    }
}
