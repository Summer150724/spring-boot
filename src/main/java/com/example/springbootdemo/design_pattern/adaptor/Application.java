/**
 * 文件名：Application.java
 * 版权： Copyright 2019-2024 XIA.FENG All Rights Reserved.
 * 描述：AUTHOR_XIAFENG
 */
package com.example.springbootdemo.design_pattern.adaptor;

/**
 * @author xia.feng@hand-china.com
 * @version 0.1
 * @date 2021-03-17 15:39
 * @description
 */
public class Application {

    public static void main(String[] args) {
        AdaptorInterface adaptor = new Adaptor();
        String apple = adaptor.getApple();
        System.out.println(apple);
        AdaptorTarget adaptorTarget = new AdaptorTarget();
        adaptorTarget.type(new Adaptor());
    }

}
