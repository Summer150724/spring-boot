/**
 * 文件名：ProxyTarget.java
 * 版权： Copyright 2019-2024 XIA.FENG All Rights Reserved.
 * 描述：AUTHOR_XIAFENG
 */
package com.example.springbootdemo.proxy;

import com.example.springbootdemo.proxy.annotations.MethodInherited;
import com.example.springbootdemo.reflect.infra.Property;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author xia.feng@hand-china.com
 * @version 0.1
 * @date 2021-03-03 11:22
 * @description
 */
@Service("ProxyTarget")
public class ProxyTarget extends ProxyTest {

    @Async
    public void invoke () {
        System.out.println("主方法运行,当前线程:" + Thread.currentThread().getName());
    }

    @MethodInherited(name = "IfCanInherited")
    public void invokeSync () {
        Class<ProxyTarget> childClass = ProxyTarget.class;
        Method[] declaredMethods = childClass.getDeclaredMethods();
        for (Method method : declaredMethods) {
            Annotation[] annotations = method.getDeclaredAnnotations();
            for (Annotation annotation : annotations) {
                Class<? extends Annotation> aClass = annotation.getClass();
                Field[] declaredFields = aClass.getDeclaredFields();
                for (Field field : declaredFields) {
                    field.setAccessible(true);
                    try {
                        Object o = field.get(annotation);
                        System.out.println("注解的值:"+o);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        System.out.println("父类调用,当前线程:"+ Thread.currentThread().getName());
    }
}
