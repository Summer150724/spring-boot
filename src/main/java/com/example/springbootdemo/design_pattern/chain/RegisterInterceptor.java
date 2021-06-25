/**
 * 文件名：RegisterInterceptor.java
 * 版权： Copyright 2019-2024 XIA.FENG All Rights Reserved.
 * 描述：AUTHOR_XIAFENG
 */
package com.example.springbootdemo.design_pattern.chain;

import org.hzero.core.interceptor.HandlerInterceptor;
import org.springframework.stereotype.Service;

/**
 * @author xia.feng@hand-china.com
 * @version 0.1
 * @date 2021-06-24 21:27
 * @description
 */
@Service
public class RegisterInterceptor implements HandlerInterceptor<User> {

    @Override
    public void interceptor(User obj) {
        System.out.println(obj.getName()+"开始注册");
    }
}
