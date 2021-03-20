/**
 * 文件名：TestController.java
 * 版权： Copyright 2019-2024 XIA.FENG All Rights Reserved.
 * 描述：AUTHOR_XIAFENG
 */
package com.example.springbootdemo.rest.api.controller.v1;

import com.example.springbootdemo.rest.app.TestService;
import com.example.springbootdemo.rest.domain.entity.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author xia.feng@hand-china.com
 * @version 0.1
 * @date 2021-03-20 14:28
 * @description
 */
@RestController("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping
    public List<Test> getTest () {
        return testService.getTest();
    }
}
