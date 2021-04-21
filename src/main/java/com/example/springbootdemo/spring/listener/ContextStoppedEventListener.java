/**
 * 文件名：ContextStoppedEventListener.java
 * 版权： Copyright 2019-2024 XIA.FENG All Rights Reserved.
 * 描述：AUTHOR_XIAFENG
 */
package com.example.springbootdemo.spring.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.stereotype.Component;

/**
 * @author xia.feng@hand-china.com
 * @version 0.1
 * @date 2021-04-16 21:56
 * @description
 */
@Component
@Slf4j
public class ContextStoppedEventListener implements ApplicationListener<ContextStoppedEvent> {

    /**
     * 当使用 ConfigurableApplicationContext接口中的 stop()停止ApplicationContext 时，
     * 发布这个事件。你可以在接受到这个事件后做必要的清理的工作
     * @param contextStoppedEvent
     */
    @Override
    public void onApplicationEvent(ContextStoppedEvent contextStoppedEvent) {
        log.info("Mycroft-contextStopped,{}", contextStoppedEvent);
        ConfigurableApplicationContext applicationContext  = (ConfigurableApplicationContext) contextStoppedEvent.getApplicationContext();
        // applicationContext.close();
    }
}
