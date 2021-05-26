/**
 * 文件名：TestController.java
 * 版权： Copyright 2019-2024 XIA.FENG All Rights Reserved.
 * 描述：AUTHOR_XIAFENG
 */
package com.example.springbootdemo.rest.api.controller.v1;

import com.example.springbootdemo.proxy.annotations.MethodInherited;
import com.example.springbootdemo.rest.app.TestService;
import com.example.springbootdemo.rest.domain.entity.Test;
import com.example.springbootdemo.rest.domain.repository.TestRepository;
import com.example.springbootdemo.rest.infra.annotation.ApiLog;
import lombok.SneakyThrows;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xia.feng@hand-china.com
 * @version 0.1
 * @date 2021-03-20 14:28
 * @description
 */
@RestController("TestController")
@RequestMapping(path = {"/mybatis/test"})
public class TestController {

    @Autowired
    private TestService testService;
    @Autowired
    private TestRepository testRepository;

    @GetMapping("/haha")
    public ResponseEntity haha () {
        return ResponseEntity.ok("hello");
    }

    @SneakyThrows
    @GetMapping
    @ApiLog(param = "summer", level = "info")
    public ResponseEntity getTest (@RequestParam Integer integer) {
/*        List<Test> test = testService.getTest(integer);
        if (CollectionUtils.isEmpty(test)) {
            throw new Exception("hahahaha");
        }*/
        List<Long> longs = new ArrayList<>();
        for (int i = integer; i > 0; i--) {
            longs.add(new Long(i--));
        }
        String ids = longs.stream().map(String::valueOf).collect(Collectors.joining(","));
        // List<Test> tests = testService.tests(longs);
        List<Test> tests = testRepository.selectByIds(ids);
        return ResponseEntity.ok(tests);
    }


    @PostMapping
    @ApiLog(param = "summer", level = "info")
    public ResponseEntity<?> insertData () {
        testService.batchInsert();
        return ResponseEntity.ok("hello");
    }
}
