/**
 * 文件名：UserInterceptorChainConfiguration.java
 * 版权： Copyright 2019-2024 XIA.FENG All Rights Reserved.
 * 描述：AUTHOR_XIAFENG
 */
package com.example.springbootdemo.design_pattern.chain;

import org.hzero.core.interceptor.InterceptorChainBuilder;
import org.hzero.core.interceptor.InterceptorChainConfigurer;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author xia.feng@hand-china.com
 * @version 0.1
 * @date 2021-06-24 21:37
 * @description 配置器中配置多条拦截器链
 */
@Order(0)
@Component
public class UserInterceptorChainConfiguration implements InterceptorChainConfigurer<User, InterceptorChainBuilder<User>> {


    @Override
    public void configure(InterceptorChainBuilder<User> chainBuilder) {
        chainBuilder
                .selectChain(UserOperation.REGISTER)
                .pre() // 开始配置前置拦截器
                .addInterceptor(RegisterInterceptor.class) // 添加前置拦截器
                .addInterceptor(AccountCheckInterceptor.class)
                .addInterceptor(AgeLimitInterceptor.class)
                .post() // 开始配置后置拦截器
                .sync() // 异步化执行(默认是同步)
                .addInterceptor(SendMessageInterceptor.class); // 添加后置拦截器

        chainBuilder
                .selectChain(UserOperation.MODIFY)
                .pre() // 开始配置前置拦截器
                .addInterceptor(RegisterInterceptor.class) // 添加前置拦截器
                .addInterceptor(AccountCheckInterceptor.class)
                .addInterceptor(AgeLimitInterceptor.class)
                .post() // 开始配置后置拦截器
                .sync() // 异步化执行(默认是同步)
                .addInterceptor(SendMessageInterceptor.class); // 添加后置拦截器
    }
}
