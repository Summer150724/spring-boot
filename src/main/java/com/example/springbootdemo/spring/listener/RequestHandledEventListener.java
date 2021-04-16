/**
 * 文件名：RequestHandledEventListener.java
 * 版权： Copyright 2019-2024 XIA.FENG All Rights Reserved.
 * 描述：AUTHOR_XIAFENG
 */
package com.example.springbootdemo.spring.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.RequestHandledEvent;

/**
 * @author xia.feng@hand-china.com
 * @version 0.1
 * @date 2021-04-16 22:00
 * @description
 */
@Component
@Slf4j
public class RequestHandledEventListener implements ApplicationListener<RequestHandledEvent> {


    /**
     * 这是一个 web-specific 事件，告诉所有 bean HTTP 请求已经被服务。
     * 只能应用于使用DispatcherServlet的Web应用。
     * 在使用Spring作为前端的MVC控制器时，当Spring处理用户请求结束后，系统会自动触发该事件
     * @param requestHandledEvent
     */
    @Override
    public void onApplicationEvent(RequestHandledEvent requestHandledEvent) {
        log.info("Mycroft-requestHandled,{}", requestHandledEvent);
    }
}
