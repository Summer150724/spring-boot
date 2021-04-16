/**
 * 文件名：CommandLineRunnerExtension.java
 * 版权： Copyright 2019-2024 XIA.FENG All Rights Reserved.
 * 描述：AUTHOR_XIAFENG
 */
package com.example.springbootdemo.spring.extension;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author xia.feng@hand-china.com
 * @version 0.1
 * @date 2021-04-16 14:21
 * @description
 */
@Component
@Slf4j
public class CommandLineRunnerExtension implements CommandLineRunner {

    /**
     * Callback used to run the bean.
     *
     * @param args incoming main method arguments
     * @throws Exception on error
     */
    @Override
    public void run(String... args) throws Exception {
        log.info("Mycroft-SpringApplicationRunComplete.");
    }
}
