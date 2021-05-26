/**
 * 文件名：SpockDemo.java
 * 版权： Copyright 2019-2024 XIA.FENG All Rights Reserved.
 * 描述：AUTHOR_XIAFENG
 */
package com.example.springbootdemo.spock;

import com.example.springbootdemo.rest.domain.entity.Test;
import com.example.springbootdemo.rest.domain.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.Objects;

/**
 * @author xia.feng@hand-china.com
 * @version 0.1
 * @date 2021-05-26 14:57
 * @description
 */
public class SpockDemo {
    @Autowired
    TestRepository testRepository;

    public Boolean test(Test test){
        // 判断传入test对象的columnA属性值是否为null
        if (Objects.nonNull(test.getColumnA())) {
            // 如果不为null,调用批量插入方法
            testRepository.batchInsert(Collections.singletonList(test));
            // 返回true
            return true;
        }
        // 返回false
        return false;
    }
}
