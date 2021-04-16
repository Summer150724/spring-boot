/**
 * 文件名：MyObserver.java
 * 版权： Copyright 2019-2024 XIA.FENG All Rights Reserved.
 * 描述：AUTHOR_XIAFENG
 */
package com.example.springbootdemo.design_pattern.observer.observor;

import com.example.springbootdemo.design_pattern.configuration.DesignPatternConfigurationProperties;
import com.example.springbootdemo.design_pattern.observer.subject.Subject;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author xia.feng@hand-china.com
 * @version 0.1
 * @date 2021-04-16 17:57
 * @description
 */
@Component
@Data
@Slf4j
public class MyObserver implements Observer {

    // @Value("${mycroft.config.observer.name}")
    private String name;
    private Subject subject;
    private DesignPatternConfigurationProperties designPatternConfigurationProperties;

    /**
     * 初始化时注册
     * @param name
     * @param subject
     */
    public MyObserver(Subject subject, DesignPatternConfigurationProperties designPatternConfigurationProperties) {
        this.name = designPatternConfigurationProperties.getObserver().getName();
        this.subject = subject;
        subject.subscribe(this);
    }

    /**
     * 消费
     *
     * @param message
     */
    @Override
    public void consume(String message) {
        log.debug("Mycroft-MyObserver.consume:{}", message);
    }
}
