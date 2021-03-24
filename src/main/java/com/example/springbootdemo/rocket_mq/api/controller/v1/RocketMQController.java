/**
 * 文件名：RocketMQController.java
 * 版权： Copyright 2019-2024 XIA.FENG All Rights Reserved.
 * 描述：AUTHOR_XIAFENG
 */
package com.example.springbootdemo.rocket_mq.api.controller.v1;

import com.example.springbootdemo.rocket_mq.app.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xia.feng@hand-china.com
 * @version 0.1
 * @date 2021-03-24 13:42
 * @description
 */
@RestController(value = "RocketMQController")
@RequestMapping(path = "/rocketMQ")
public class RocketMQController {

    @Autowired
    private ProducerService producerService;


    @GetMapping("/produce/common")
    public void produce(String messageBody){
        producerService.sendMsg(messageBody);
    }
}
