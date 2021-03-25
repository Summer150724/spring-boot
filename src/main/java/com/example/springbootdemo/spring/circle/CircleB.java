/**
 * 文件名：CircleB.java
 * 版权： Copyright 2019-2024 XIA.FENG All Rights Reserved.
 * 描述：AUTHOR_XIAFENG
 */
package com.example.springbootdemo.spring.circle;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author xia.feng@hand-china.com
 * @version 0.1
 * @date 2021-03-25 16:48
 * @description
 */
@Data
@Component
public class CircleB {

    private CircleA circleA;

    @Autowired
    private CircleC circleC;

    public CircleB (CircleA circleA) {
        this.circleA = circleA;
    }
}
