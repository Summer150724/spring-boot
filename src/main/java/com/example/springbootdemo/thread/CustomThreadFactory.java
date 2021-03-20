/**
 * 文件名：CustomThreadFactory.java
 * 版权： Copyright 2019-2024 CEC All Rights Reserved.
 * 描述：药品流通监管平台
 */
package com.example.springbootdemo.thread;

import java.util.concurrent.ThreadFactory;

/**
 * @author xia.feng@hand-china.com
 * @version 0.1
 * @date 2020-06-30 13:22
 * @description
 */
public class CustomThreadFactory implements ThreadFactory {

    public CustomThreadFactory() {
    }

    public CustomThreadFactory(String threadName) {
        this.threadName = threadName;
    }

    private String threadName;

    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setName(threadName + Thread.currentThread().getName());
        return thread;
    }
}
