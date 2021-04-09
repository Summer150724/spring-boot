package com.example.springbootdemo.configuration;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.scheduling.annotation.EnableAsync;

import java.lang.annotation.*;

/**
 * @author xia.feng@hand-china.com
 * @version 0.1
 * @date 2021-04-09 16:33
 * @description
 */

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
// Mapper加@Mapper注解就不需要再手动扫描了
//@MapperScan(basePackages = {"com.example.springbootdemo.rest.infra.mapper"})
//过滤redis&rocketMQ相关bean,本地没起服务
@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX,
        pattern = {"com.example.springbootdemo.rocket_mq.*", "com.example.springbootdemo.redis.*"}))
@EnableAsync
@SpringBootApplication
public @interface Mycroft {
}
