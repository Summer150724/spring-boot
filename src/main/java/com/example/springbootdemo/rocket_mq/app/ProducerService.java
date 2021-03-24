/**
 * 文件名：ProducerService.java
 * 版权： Copyright 2019-2024 XIA.FENG All Rights Reserved.
 * 描述：AUTHOR_XIAFENG
 */
package com.example.springbootdemo.rocket_mq.app;

/**
 * @author xia.feng@hand-china.com
 * @version 0.1
 * @date 2021-03-24 11:25
 * @description
 */
public interface ProducerService {

    void sendMsg(String msgBody);

    void sendAsyncMsg(String msgBody);

    void sendDelayMsg(String msgBody, Integer delayLevel);

    void sendTagMsg(String msgBody);
}
