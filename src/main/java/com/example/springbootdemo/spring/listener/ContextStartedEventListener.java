/**
 * 文件名：ContextStartedEventListener.java
 * 版权： Copyright 2019-2024 XIA.FENG All Rights Reserved.
 * 描述：AUTHOR_XIAFENG
 */
package com.example.springbootdemo.spring.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.stereotype.Component;

/**
 * @author xia.feng@hand-china.com
 * @version 0.1
 * @date 2021-04-16 21:52
 * @description
 */
@Component
@Slf4j
public class ContextStartedEventListener implements ApplicationListener<ContextStartedEvent> {

    /**
     * 当使用 ConfigurableApplicationContext （ApplicationContext子接口）接口中的 start() 方法启动 ApplicationContext时，
     * 该事件被发布。你可以调查你的数据库，或者你可以在接受到这个事件后重启任何停止的应用程序
     * @param contextStartedEvent
     */
    @Override
    public void onApplicationEvent(ContextStartedEvent contextStartedEvent) {
        log.info("Mycroft-contextStarted,{}", contextStartedEvent);
    }
}
