/**
 * 文件名：ProxyController.java
 * 版权： Copyright 2019-2024 XIA.FENG All Rights Reserved.
 * 描述：AUTHOR_XIAFENG
 */
package com.example.springbootdemo.proxy;

import com.example.springbootdemo.spring.utils.ProxyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * @author xia.feng@hand-china.com
 * @version 0.1
 * @date 2021-07-01 10:38
 * @description
 */
@RestController
@RequestMapping("/proxy")
@Slf4j
public class ProxyController {

    @Autowired
    private ChildClass childClass;

    @GetMapping
    public void getProxy (){

        log.debug(Thread.currentThread().getName());
        childClass.asyncMethod();
    }

}
