/**
 * 文件名：UserChainController.java
 * 版权： Copyright 2019-2024 XIA.FENG All Rights Reserved.
 * 描述：AUTHOR_XIAFENG
 */
package com.example.springbootdemo.design_pattern.chain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xia.feng@hand-china.com
 * @version 0.1
 * @date 2021-06-24 22:24
 * @description
 */
@RestController("UserChainController")
@RequestMapping(path = "/user/chain")
@Slf4j
public class UserChainController {

    @Autowired
    private UserInterceptorChainManager userInterceptorChainManager;


    @PostMapping("/register")
    public String register(@RequestBody User user) {
        log.info("来了");
        userInterceptorChainManager.doInterceptor(UserOperation.REGISTER, user, u -> {
            log.info("注册中....");
        });
        return user.getName();
    }
}
