/**
 * 文件名：TestService.java
 * 版权： Copyright 2019-2024 XIA.FENG All Rights Reserved.
 * 描述：AUTHOR_XIAFENG
 */
package com.example.springbootdemo.rest.app;

import com.example.springbootdemo.rest.domain.entity.Test;

import java.util.List;

/**
 * @author xia.feng@hand-china.com
 * @version 0.1
 * @date 2021-03-20 14:29
 * @description
 */
public interface TestService {

    List<Test> getTest();
}
