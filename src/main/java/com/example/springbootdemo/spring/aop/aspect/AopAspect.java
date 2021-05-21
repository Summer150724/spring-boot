/**
 * 文件名：AopAspect.java
 * 版权： Copyright 2019-2024 XIA.FENG All Rights Reserved.
 * 描述：AUTHOR_XIAFENG
 */
package com.example.springbootdemo.spring.aop.aspect;

import com.example.springbootdemo.proxy.annotations.MethodInherited;
import com.example.springbootdemo.rest.infra.annotation.ApiLog;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.CodeSignature;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author xia.feng@hand-china.com
 * @version 0.1
 * @date 2021-04-22 16:51
 * @description
 */
@Aspect //把当前类标识为一个切面供容器读取
@Component
@Slf4j
public class AopAspect {

    // Pointcut是植入Advice的触发条件。
    // 每个Pointcut的定义包括2部分，一是表达式，二是方法签名.
    // 方法签名必须是 public及void型。可以将Pointcut中的方法看作是一个被Advice引用的助记符，因为表达式不直观，因此我们可以通过方法签名的方式为 此表达式命名。因此Pointcut中的方法只需要方法签名，而不需要在方法体内编写实际代码。
    @Pointcut(value = "com.example.springbootdemo.spring.aop.pointcut.PointCutDefinition.mybatis()")
    public void join () {

    }

    /**
     * 可以不用切点,直接用注解实现织入
     * @param joinPoint
     */
    @Before(value = "@annotation(com.example.springbootdemo.proxy.annotations.MethodInherited)")
    public void processBefore (JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        log.debug("AOP-Before:{}", signature.getName());
    }

    @After(value = "com.example.springbootdemo.spring.aop.pointcut.PointCutDefinition.mybatis()")
    public void processAfter (JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        log.debug("AOP-After:{}", signature.getName());
    }

    @AfterReturning(pointcut = "com.example.springbootdemo.spring.aop.pointcut.PointCutDefinition.rest()",
    returning = "returns")
    public Object processAfterReturning (JoinPoint joinPoint, Object returns) {
        Signature signature = joinPoint.getSignature();
        log.debug("AOP-afterReturning:{}", signature.getName());

        return returns;
    }

    @Around(value = "@annotation(com.example.springbootdemo.rest.infra.annotation.ApiLog)")
    public Object processAround (ProceedingJoinPoint joinPoint) throws Throwable {
        // 获取连接点的签名
        Signature signature = joinPoint.getSignature();
        // SpringAop中,连接点一定是方法
        MethodSignature methodSignature = (MethodSignature) signature;
        // 通过方法签名获取方法
        Method method = methodSignature.getMethod();
        // 通过方法获取方法上的注解
        ApiLog apiLog = method.getAnnotation(ApiLog.class);
        // 通过连接点获取方法参数
        Object[] args = joinPoint.getArgs();
        // 1.获取方法参数名
        String[] parameterNames = methodSignature.getParameterNames();
        // 2.获取方法参数名
        // CodeSignature表示由连接点捕获的代码块.它可以是方法,构造函数,初始化程序(静态或非静态)或建议
        CodeSignature codeSignature = (CodeSignature) signature;
        String[] codeSignatureParameterNames = codeSignature.getParameterNames();

        if (apiLog.level().equals("info")) {
            log.info("invoke:{},param:{}", methodSignature.getName(), args);
        }

        log.debug("AOP-Around:{}", signature.getName());
        return joinPoint.proceed(args);
    }




}
