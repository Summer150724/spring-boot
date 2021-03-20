package com.example.springbootdemo.thread.run; /**
 * 文件名：TreadTest.java
 * 版权： Copyright 2019-2024 XIA.FENG All Rights Reserved.
 * 描述：AUTHOR_XIAFENG
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @author xia.feng@hand-china.com
 * @version 0.1
 * @date 2020-07-27 14:27
 * @description
 */
public class TreadTest {


    public static void main(String[] args) throws InterruptedException {
        StringBuilder variable = new StringBuilder("a");
        System.out.println("variableInit:" + variable.hashCode());
        variable = new StringBuilder("s");
        System.out.println("variableAssignment:" + variable.hashCode());


        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        StringBuilder finalVariable = variable;
        System.out.println("finalVariable:" + finalVariable.hashCode());
        executorService.submit(() -> {
            /// 验证 : 当变量指向多个堆时,线程调用变量会怎样? 无法编译
            /// 2 当变量指向一个堆时,会不会报错变量未初始化?也就是说,我线程还没起,这个时候我的变量指向的堆已经确定了,那为什么不让我用?
            /// 赋值null算不算改变了内存地址
            /// 目前结论:向线程中传递的参数,堆内存地址不能发生过改变;但无法解释问题2
            System.out.println(Thread.currentThread().getName() + "---" + finalVariable.hashCode());
            try {
                executorService.wait(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.submit(() -> {
            System.out.println(Thread.currentThread().getName() + "---" + finalVariable.hashCode());
        });
        executorService.submit(() -> {
            System.out.println(Thread.currentThread().getName() + "---" + finalVariable.hashCode());
        });
        executorService.submit(() -> {
            System.out.println(Thread.currentThread().getName() + "---" + finalVariable.hashCode());
        });
        executorService.submit(() -> {
            System.out.println(Thread.currentThread().getName() + "---" + finalVariable.hashCode());
        });

    }
}
