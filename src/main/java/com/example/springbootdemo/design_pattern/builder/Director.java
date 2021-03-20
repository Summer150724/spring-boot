/**
 * 文件名：Director.java
 * 版权： Copyright 2019-2024 XIA.FENG All Rights Reserved.
 * 描述：AUTHOR_XIAFENG
 */
package com.example.springbootdemo.design_pattern.builder;

import lombok.Data;

/**
 * @author xia.feng@hand-china.com
 * @version 0.1
 * @date 2021-03-17 14:39
 * @description 指挥者
 */
@Data
public class Director {
    private AbstractHouseBuilder houseBuilder;

    public Director (AbstractHouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    public House constructHouse (House house) {
        houseBuilder.buildBasic(house);
        houseBuilder.buildWalls(house);
        houseBuilder.roofed(house);
        return houseBuilder.buildHouse();
    }
}
