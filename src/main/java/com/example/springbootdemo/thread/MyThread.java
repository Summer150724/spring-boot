/**
 * 文件名：MyThread.java
 * 版权： Copyright 2019-2024 CEC All Rights Reserved.
 * 描述：药品流通监管平台
 */
package com.example.springbootdemo.thread;

/**
 * @author xia.feng@hand-china.com
 * @version 0.1
 * @date 2020-06-29 18:37
 * @description
 */
public class MyThread implements Runnable {

    Long count = 1L;

    @Override
    public void run() {

        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println(Thread.currentThread().getName());

    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
