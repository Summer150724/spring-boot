package com.example.springbootdemo.design_pattern.observer.observor;

/**
 * @author xia.feng@hand-china.com
 * @version 0.1
 * @date 2021-04-16 17:56
 * @description
 */
public interface Observer {

    /**
     * 消费
     * @param message
     */
    void consume (String message);

}
