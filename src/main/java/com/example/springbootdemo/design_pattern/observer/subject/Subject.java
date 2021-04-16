package com.example.springbootdemo.design_pattern.observer.subject;

import com.example.springbootdemo.design_pattern.observer.observor.Observer;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xia.feng@hand-china.com
 * @version 0.1
 * @date 2021-04-16 17:47
 * @description
 */
public interface Subject {

    /**
     * 订阅
     */
    void subscribe (Observer observer);

    /**
     * 发布消息
     */
    void publish(String message);

}
