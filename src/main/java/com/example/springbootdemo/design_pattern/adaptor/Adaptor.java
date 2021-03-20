/**
 * 文件名：Adaptor.java
 * 版权： Copyright 2019-2024 XIA.FENG All Rights Reserved.
 * 描述：AUTHOR_XIAFENG
 */
package com.example.springbootdemo.design_pattern.adaptor;

/**
 * @author xia.feng@hand-china.com
 * @version 0.1
 * @date 2021-03-17 15:26
 * @description 适配器模式
 */
public class Adaptor extends AdaptorTarget implements AdaptorInterface{

    @Override
    public String getApple() {
        String type = "apple";
        return type;
    }

}
