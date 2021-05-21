/**
 * 文件名：IntroductionsDefinition.java
 * 版权： Copyright 2019-2024 XIA.FENG All Rights Reserved.
 * 描述：AUTHOR_XIAFENG
 */
package com.example.springbootdemo.spring.aop.introductions;

import com.example.springbootdemo.rest.app.TestService;
import com.example.springbootdemo.rest.app.impl.TestServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

/**
 * @author xia.feng@hand-china.com
 * @version 0.1
 * @date 2021-04-23 16:08
 * @description 引言（在AspectJ中称为类型间声明）使一个方面可以声明建议对象实现给定的接口，并代表那些对象提供该接口的实现。
 */
// @Component  //
@Aspect
@Slf4j
public class IntroductionsDefinition {

    @DeclareParents(value = "com.example.springbootdemo.rest.domain.entity.*+",
            defaultImpl = TestServiceImpl.class)
    public static TestService testService;

}
