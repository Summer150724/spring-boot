/**
 * 文件名：TestServiceImpl.java
 * 版权： Copyright 2019-2024 XIA.FENG All Rights Reserved.
 * 描述：AUTHOR_XIAFENG
 */
package com.example.springbootdemo.rest.app.impl;

import com.example.springbootdemo.rest.app.TestService;
import com.example.springbootdemo.rest.domain.entity.Test;
import com.example.springbootdemo.rest.domain.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author xia.feng@hand-china.com
 * @version 0.1
 * @date 2021-03-20 14:30
 * @description
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestRepository testRepository;

    @Override
    public List<Test> getTest(Integer integer) {
        return testRepository.getAll(integer);
    }

    @Override
    public List<Test> tests(List<Long> list) {
        return testRepository.select(list);
    }

    @Override
    public void batchInsert() {
        List<Test> tests = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            tests.add(new Test(new Long(i), new Long(i+1), new Date()));
        }
        testRepository.batchInsert(tests);
    }
}
