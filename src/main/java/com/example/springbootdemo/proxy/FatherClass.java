/**
 * 文件名：FatherClass.java
 * 版权： Copyright 2019-2024 XIA.FENG All Rights Reserved.
 * 描述：AUTHOR_XIAFENG
 */
package com.example.springbootdemo.proxy;

import lombok.extern.slf4j.Slf4j;
import org.hzero.core.base.AopProxy;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author xia.feng@hand-china.com
 * @version 0.1
 * @date 2021-07-01 10:30
 * @description
 */

@Slf4j
@Component
public class FatherClass implements OriginInterface {

    @Override
    @Async
    @Transactional
    public void asyncMethod() {
        System.out.println(("俺被调用了:" + this.getClass().getName()));
    }
}
