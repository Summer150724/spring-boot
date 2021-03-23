/**
 * 文件名：SpringInnerClassAndInterface.java
 * 版权： Copyright 2019-2024 XIA.FENG All Rights Reserved.
 * 描述：AUTHOR_XIAFENG
 */
package com.example.springbootdemo.spring;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @author xia.feng@hand-china.com
 * @version 0.1
 * @date 2021-03-22 15:52
 * @description
 */
@Component
public class SpringInnerClassAndInterface implements BeanNameAware {

    private Environment environment;

    private String beanName;

    @Autowired
    public SpringInnerClassAndInterface(Environment environment) {
        this.environment = environment;
    }



    public void environmentOptions() {
    }

    @Override
    public void setBeanName(String s) {
        this.beanName = s;
    }

    public String getBeanName() {
        return beanName;
    }
}
