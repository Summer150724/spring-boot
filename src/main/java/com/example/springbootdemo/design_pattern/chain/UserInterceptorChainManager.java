/**
 * 文件名：UserInterceptorChainManager.java
 * 版权： Copyright 2019-2024 XIA.FENG All Rights Reserved.
 * 描述：AUTHOR_XIAFENG
 */
package com.example.springbootdemo.design_pattern.chain;

import org.hzero.core.interceptor.AbstractInterceptorChainManager;
import org.hzero.core.interceptor.HandlerInterceptor;
import org.hzero.core.interceptor.InterceptorChainBuilder;
import org.hzero.core.interceptor.InterceptorChainConfigurer;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author xia.feng@hand-china.com
 * @version 0.1
 * @date 2021-06-24 22:02
 * @description 配置业务模型的拦截器链管理器
 */
@Component
public class UserInterceptorChainManager extends AbstractInterceptorChainManager<User> {

    public UserInterceptorChainManager(List<HandlerInterceptor<User>> interceptorList, List<InterceptorChainConfigurer<User, InterceptorChainBuilder<User>>> configurerList) {
        super(interceptorList, configurerList);
    }
}
