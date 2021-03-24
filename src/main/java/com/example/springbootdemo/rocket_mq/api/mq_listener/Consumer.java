/**
 * 文件名：Consumer.java
 * 版权： Copyright 2019-2024 XIA.FENG All Rights Reserved.
 * 描述：AUTHOR_XIAFENG
 */
package com.example.springbootdemo.rocket_mq.api.mq_listener;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @author xia.feng@hand-china.com
 * @version 0.1
 * @date 2021-03-24 14:41
 * @description rocketmq 消息监听，@RocketMQMessageListener中的selectorExpression为tag，默认为*
 */
@Slf4j
@Component
@RocketMQMessageListener(topic = "queue_test_topic", selectorExpression = "*", consumerGroup = "consumer_group_1")
public class Consumer implements RocketMQListener<MessageExt> {

    @Override
    public void onMessage(MessageExt messageExt) {
        byte[] body = messageExt.getBody();
        String message = new String(body);
        log.info("接收到消息：{}", message);

    }
}
