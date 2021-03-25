/**
 * 文件名：CircleA.java
 * 版权： Copyright 2019-2024 XIA.FENG All Rights Reserved.
 * 描述：AUTHOR_XIAFENG
 */
package com.example.springbootdemo.spring.circle;

import com.example.springbootdemo.rest.domain.repository.TestRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author xia.feng@hand-china.com
 * @version 0.1
 * @date 2021-03-25 16:47
 * @description
 */
@Data
@Component
public class CircleA {

    @Autowired
    private CircleB circleB;

    @Autowired
    private CircleC circleC;

    @Autowired
    private TestRepository testRepository;

    /**
     * 加上注解后,会循环依赖
     */
    // @Async
    public void async(){
        testRepository.select();
    }

}
