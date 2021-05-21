/**
 * 文件名：PointCutDefination.java
 * 版权： Copyright 2019-2024 XIA.FENG All Rights Reserved.
 * 描述：AUTHOR_XIAFENG
 */
package com.example.springbootdemo.spring.aop.pointcut;

import org.aspectj.lang.annotation.Pointcut;

/**
 * @author xia.feng@hand-china.com
 * @version 0.1
 * @date 2021-04-22 20:13
 * @description 切点定义类
 */
public class PointCutDefinition {

    /**
     * com.example.springbootdemo.mybatis包下的全部方法
     */
    @Pointcut(value = "execution(* com.example.springbootdemo.mybatis..*.* (..))")
    public void mybatis () {
    }
    @Pointcut(value = "execution(* com.example.springbootdemo.redis..*.* (..))")
    public void redis () {
    }

    @Pointcut(value = "execution(* com.example.springbootdemo.rest..*.*(..))")
    public void rest () {

    }

    /**
     * 可以用 || ! && 运算符
     */
    @Pointcut(value = " ! mybatis() ||  redis()")
    public void data () {

    }

}
