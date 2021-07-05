/**
 * 文件名：ChildClass.java
 * 版权： Copyright 2019-2024 XIA.FENG All Rights Reserved.
 * 描述：AUTHOR_XIAFENG
 */
package com.example.springbootdemo.proxy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author xia.feng@hand-china.com
 * @version 0.1
 * @date 2021-07-01 10:32
 * @description
 */

@Component
@Slf4j
public class ChildClass extends FatherClass {

    @Override
    @Transactional
    public void asyncMethod() {
        log.debug("被调用了,class:{}", this.getClass().getName());
    }
}
