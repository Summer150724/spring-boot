/**
 * 文件名：AccountCheckInterceptor.java
 * 版权： Copyright 2019-2024 XIA.FENG All Rights Reserved.
 * 描述：AUTHOR_XIAFENG
 */
package com.example.springbootdemo.design_pattern.chain;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.hzero.core.interceptor.HandlerInterceptor;
import org.springframework.stereotype.Component;

/**
 * @author xia.feng@hand-china.com
 * @version 0.1
 * @date 2021-06-24 21:55
 * @description
 */
@Component
@Slf4j
public class AgeLimitInterceptor implements HandlerInterceptor<User> {

    @SneakyThrows
    @Override
    public void interceptor(User obj) {
        log.debug("{}开始进行年龄校验.", obj.getName());
        if (obj.getAge() < 18) {
            throw new Exception("18未满,立入禁止");
        }
    }
}
