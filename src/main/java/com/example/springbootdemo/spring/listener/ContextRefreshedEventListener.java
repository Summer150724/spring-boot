/**
 * 文件名：CustomApplicationListener.java
 * 版权： Copyright 2019-2024 XIA.FENG All Rights Reserved.
 * 描述：AUTHOR_XIAFENG
 */
package com.example.springbootdemo.spring.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationContextInitializedEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.stereotype.Component;

/**
 * @author xia.feng@hand-china.com
 * @version 0.1
 * @date 2021-04-16 21:34
 * @description
 */
@Component
@Slf4j
public class ContextRefreshedEventListener implements ApplicationListener<ContextRefreshedEvent> {


    /**
     * ApplicationContext 被初始化或刷新时，该事件被发布。
     * 这也可以在ConfigurableApplicationContext接口中使用 refresh()方法来发生。
     * 此处的初始化是指：所有的Bean被成功装载，后处理Bean被检测并激活，所有Singleton Bean 被预实例化，ApplicationContext容器已就绪可用
     * @param contextRefreshedEvent
     */
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        log.info("Mycroft-contextRefreshed,{}", contextRefreshedEvent);
        ConfigurableApplicationContext applicationContext = (ConfigurableApplicationContext) contextRefreshedEvent.getApplicationContext();
        // applicationContext.stop();
    }
}
