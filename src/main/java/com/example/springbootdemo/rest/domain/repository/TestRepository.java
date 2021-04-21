/**
 * 文件名：TestRepository.java
 * 版权： Copyright 2019-2024 XIA.FENG All Rights Reserved.
 * 描述：AUTHOR_XIAFENG
 */
package com.example.springbootdemo.rest.domain.repository;

import com.example.springbootdemo.rest.domain.entity.Test;

import java.util.List;

/**
 * @author xia.feng@hand-china.com
 * @version 0.1
 * @date 2021-03-19 17:02
 * @description
 */
public interface TestRepository {
    List<Test> getAll (Integer integer);

    List<Test> select();
}
