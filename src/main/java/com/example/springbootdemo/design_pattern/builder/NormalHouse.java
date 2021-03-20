/**
 * 文件名：NomalHouse.java
 * 版权： Copyright 2019-2024 XIA.FENG All Rights Reserved.
 * 描述：AUTHOR_XIAFENG
 */
package com.example.springbootdemo.design_pattern.builder;

/**
 * @author xia.feng@hand-china.com
 * @version 0.1
 * @date 2021-03-17 11:30
 * @description
 */
public class NormalHouse extends AbstractHouseBuilder {

    public NormalHouse(House house) {
        super(house);
    }

    @Override
    void buildBasic(House house) {
        house.setBase("NormalBase");
        System.out.println("普通房子打地基");
    }

    @Override
    void buildWalls(House house) {
        house.setWalls("NormalWalls");
        System.out.println("普通房子砌墙");
    }

    @Override
    void roofed(House house) {
        house.setRoof("NormalRoof");
        System.out.println("普通房子封顶");
    }
}
