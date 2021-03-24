/**
 * 文件名：RedisController.java
 * 版权： Copyright 2019-2024 XIA.FENG All Rights Reserved.
 * 描述：AUTHOR_XIAFENG
 */
package com.example.springbootdemo.redis.api.controller.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xia.feng@hand-china.com
 * @version 0.1
 * @date 2021-03-24 16:08
 * @description
 */
@RestController("RedisController")
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisTemplate redisTemplate;



    @PostMapping("/push")
    public void insertData (@RequestParam String json) {
        ValueOperations<String,String> valueOperations = redisTemplate.opsForValue();
        valueOperations.set("mycroft", "summer");
    }
}
