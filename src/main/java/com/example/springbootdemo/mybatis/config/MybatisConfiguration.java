/**
 * 文件名：MybatisConfiguration.java
 * 版权： Copyright 2019-2024 XIA.FENG All Rights Reserved.
 * 描述：AUTHOR_XIAFENG
 */
package com.example.springbootdemo.mybatis.config;

import com.example.springbootdemo.mybatis.intercept.SelectSqlInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author xia.feng@hand-china.com
 * @version 0.1
 * @date 2021-04-21 14:30
 * @description
 */

@Configuration
@ConditionalOnProperty(prefix = "mybatis.log", name = "intact", matchIfMissing = true)
@ComponentScan({"com.example.springbootdemo.mybatis.intercept"})
public class MybatisConfiguration {


    @Bean
    public SelectSqlInterceptor selectSqlInterceptor () {
            return new SelectSqlInterceptor();
    }

}
