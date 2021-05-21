/**
 * 文件名：InterceptorConfiguration.java
 * 版权： Copyright 2019-2024 XIA.FENG All Rights Reserved.
 * 描述：AUTHOR_XIAFENG
 */
package com.example.springbootdemo.spring.configuration;

import com.example.springbootdemo.spring.aop.pointcut.PointCutDefinition;
import com.example.springbootdemo.spring.interceptor.CustomMethodInterceptor;
import com.example.springbootdemo.spring.interceptor.CustomWebRequestInterceptor;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author xia.feng@hand-china.com
 * @version 0.1
 * @date 2021-04-26 16:18
 * @description
 */
@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer {


    /**
     * Add Spring MVC lifecycle interceptors for pre- and post-processing of
     * controller method invocations and resource handler requests.
     * Interceptors can be registered to apply to all requests or be limited
     * to a subset of URL patterns.
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CustomWebRequestInterceptor()).addPathPatterns("/**");
    }


/*    @Bean
    public Advisor pointcutAdvisor() {
        CustomMethodInterceptor interceptor = new CustomMethodInterceptor();
        // 配置增强类advisor
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor();
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        // pointcut.setExpression();
        advisor.setPointcut(pointcut);
        // 把写好的方法拦截器放进来
        advisor.setAdvice(interceptor);
        return advisor;
    }*/
}
