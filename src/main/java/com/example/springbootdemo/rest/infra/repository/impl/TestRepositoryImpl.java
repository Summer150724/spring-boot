/**
 * 文件名：TestRepository.java
 * 版权： Copyright 2019-2024 XIA.FENG All Rights Reserved.
 * 描述：AUTHOR_XIAFENG
 */
package com.example.springbootdemo.rest.infra.repository.impl;

import com.example.springbootdemo.rest.domain.entity.Test;
import com.example.springbootdemo.rest.domain.repository.TestRepository;
import com.example.springbootdemo.rest.infra.mapper.TestMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author xia.feng@hand-china.com
 * @version 0.1
 * @date 2021-03-19 17:02
 * @description
 */
@Repository(value = "TestRepository")
public class TestRepositoryImpl implements TestRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestRepositoryImpl.class);

    @Autowired
    @Lazy
    private TestMapper testMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<Test> getAll() {
        return testMapper.getAll();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public List<Test> select(){
        return testMapper.select();
    }
}
