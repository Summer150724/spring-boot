/**
 * 文件名：MySubject.java
 * 版权： Copyright 2019-2024 XIA.FENG All Rights Reserved.
 * 描述：AUTHOR_XIAFENG
 */
package com.example.springbootdemo.design_pattern.observer.subject;

import com.example.springbootdemo.design_pattern.observer.observor.Observer;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xia.feng@hand-china.com
 * @version 0.1
 * @date 2021-04-16 18:00
 * @description
 */
@Component
public class MySubject implements Subject {

    // 观察者注册中心
    private Set<Observer> observers = new HashSet<>();

    /**
     * 订阅
     */
    @Override
    public void subscribe(Observer observer) {
        this.observers.add(observer);
    }

    /**
     * 发布消息
     */
    @Override
    public void publish(String message) {
        Set<Observer> observers = this.observers;
        for (Observer observer : observers) {
            observer.consume(message);
        }
    }
}
