/**
 * 文件名：RedisConfig.java
 * 版权： Copyright 2019-2024 XIA.FENG All Rights Reserved.
 * 描述：AUTHOR_XIAFENG
 */
package com.example.springbootdemo.redis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author xia.feng@hand-china.com
 * @version 0.1
 * @date 2021-03-24 16:43
 * @description 配置类
 */
@Configuration
public class RedisConfig {


    @Bean
    public RedisTemplate redisTemplate(RedisTemplate redisTemplate) {
        // TODO 到底先注入的哪个?最终生成的Bean又是哪个? 三级缓存
        //设置序列化Key的实例化对象
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //设置序列化Value的实例化对象
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        return redisTemplate;
    }

}
