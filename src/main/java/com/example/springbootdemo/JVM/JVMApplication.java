/**
 * 文件名：JVMApplication.java
 * 版权： Copyright 2019-2024 XIA.FENG All Rights Reserved.
 * 描述：AUTHOR_XIAFENG
 */
package com.example.springbootdemo.JVM;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * @author xia.feng@hand-china.com
 * @version 0.1
 * @date 2021-05-19 13:58
 * @description
 */
public class JVMApplication{

    public static WeakReference<String> weakStr;

    public static void main(String[] args) {

        test();

        System.gc();

        try {
            Thread.currentThread().sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(weakStr);
    }


    static void test () {
        // 强引用
        String strongStr = new String("hello");
        WeakReference<String> weakStr = new WeakReference<>(strongStr);
        System.gc();
        System.out.println(weakStr.get());
    }
}
