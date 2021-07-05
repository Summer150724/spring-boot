/**
 * 文件名：User.java
 * 版权： Copyright 2019-2024 XIA.FENG All Rights Reserved.
 * 描述：AUTHOR_XIAFENG
 */
package com.example.springbootdemo.design_pattern.chain;

import lombok.Data;

/**
 * @author xia.feng@hand-china.com
 * @version 0.1
 * @date 2021-06-24 21:24
 * @description 业务类
 */
@Data
public class User {
    private transient volatile Object [] array;
    private Long id;
    private String name;
    private Integer age;

    public User() {
    }

    public User(Long id, String name, Integer age) {
        this.name = name;
        this.age = age;
    }

}
