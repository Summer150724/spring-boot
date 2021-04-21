/**
 * 文件名：ApplicationContextInitializerExtension.java
 * 版权： Copyright 2019-2024 XIA.FENG All Rights Reserved.
 * 描述：AUTHOR_XIAFENG
 */
package com.example.springbootdemo.spring.extension;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * @author xia.feng@hand-china.com
 * @version 0.1
 * @date 2021-04-16 11:43
 * @description 容器尚未初始化,所以这个类想要生效,需要在启动类中用springApplication.addInitializers(new ApplicationContextInitializerExtension ())语句加入
 * @description 配置文件配置context.initializer.classes=com.example.demo.TestApplicationContextInitializer
 * @config Spring SPI扩展，在spring.factories中加入org.springframework.context.ApplicationContextInitializer=com.example.springbootdemo.spring.extension.ApplicationContextInitializerExtension
 */
@Slf4j
// 指定最高级别,优先执行
// @Order(Ordered.HIGHEST_PRECEDENCE)
public class ApplicationContextInitializerExtension implements ApplicationContextInitializer {

    /**
     * spring容器在刷新之前初始化ConfigurableApplicationContext的回调接口
     * 可以想到的场景可能为，在最开始激活一些配置，或者利用这时候class还没被类加载器加载的时机，进行动态字节码注入等操作
     * @param configurableApplicationContext
     */
    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        log.info("准备开始初始化容器,此时的容器:{}", configurableApplicationContext);
    }
}
