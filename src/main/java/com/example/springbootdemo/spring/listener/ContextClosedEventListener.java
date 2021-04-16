/**
 * 文件名：ContextClosedEventListener.java
 * 版权： Copyright 2019-2024 XIA.FENG All Rights Reserved.
 * 描述：AUTHOR_XIAFENG
 */
package com.example.springbootdemo.spring.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;

/**
 * @author xia.feng@hand-china.com
 * @version 0.1
 * @date 2021-04-16 21:59
 * @description
 */
@Component
@Slf4j
public class ContextClosedEventListener implements ApplicationListener<ContextClosedEvent> {

    /**
     * 当使用 ConfigurableApplicationContext接口中的 close()方法关闭 ApplicationContext 时，
     * 该事件被发布。
     * 一个已关闭的上下文到达生命周期末端；
     * 它不能被刷新或重启
     * @param contextClosedEvent
     */
    @Override
    public void onApplicationEvent(ContextClosedEvent contextClosedEvent) {
        log.info("Mycroft-contextClosed,{}", contextClosedEvent);
        ConfigurableApplicationContext applicationContext = (ConfigurableApplicationContext) contextClosedEvent.getApplicationContext();
        log.error("GAME OVER!!!");
    }
}
