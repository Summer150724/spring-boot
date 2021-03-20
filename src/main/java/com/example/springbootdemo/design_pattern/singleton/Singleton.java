/**
 * 文件名：Singleton.java
 * 版权： Copyright 2019-2024 XIA.FENG All Rights Reserved.
 * 描述：AUTHOR_XIAFENG
 */
package com.example.springbootdemo.design_pattern.singleton;

import java.util.Objects;

/**
 * @author xia.feng@hand-china.com
 * @version 0.1
 * @date 2021-03-12 14:56
 * @description 单例模式
 * 源码中的应用:
 * @see java.lang.Runtime
 */
public class Singleton {
    private String name = "xia.feng";

    // 1.饿汉式(静态常量)
    // 优点:类加载时就完成实例化,避免线程同步问题
    // 缺点:可能从未用过造成资源浪费
    public static class Singleton1{

        /**
         * 私有化构造器
         */
        private Singleton1 () {

        }
        /**
         * 内部创建对象实例
         */
        private final static Singleton1 singleton1 = new Singleton1();
        /**
         * 对外提供获取实例方法
         * @return
         */
        public Singleton1 getInstance () {
            return singleton1;
        }
    }

    // 2.懒汉式
    public static class Singleton2 {

        // volatile关键字,实时同步
        private static volatile Singleton2 singleton2;

        private Singleton2 () {

        }

        // 优点:懒加载
        // 缺点:只能在单线程使用,多线程不安全
        public Singleton2 getInstance () {
            if (Objects.isNull(singleton2)) {
                singleton2 = new Singleton2();
            }
            return singleton2;
        }

        // 优点:懒加载
        // 缺点:只能在单线程使用,解决多线程不安全
        public static synchronized Singleton2 getInstanceSync () {
            if (Objects.isNull(singleton2)) {
                singleton2 = new Singleton2();
            }
            return singleton2;
        }

        // 双重检查,避免上述两个问题
        public static Singleton2 getInstanceWith2Check () {
            if (Objects.isNull(singleton2)) {
                synchronized (Singleton2.class) {
                    if (Objects.isNull(singleton2)) {
                        singleton2 = new Singleton2();
                    }
                }
            }
            return singleton2;
        }



    }

    // 3.静态内部类
    public static class Singleton3 {
        // 类装载时,静态内部类不会加载;静态内部类装载时,线程安全,利用这一特性实现单例
        private static Singleton3 singleton3;

        private static class SingletonInstance {
            private static final Singleton3 instance = new Singleton3();
        }

        public Singleton3 getInstance () {
            return SingletonInstance.instance;
        }



    }

    // 4.枚举
    public enum Singleton4{
        INSTANCE; // 属性
    }
}

