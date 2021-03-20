/**
 * 文件名：HighBuilding.java
 * 版权： Copyright 2019-2024 XIA.FENG All Rights Reserved.
 * 描述：AUTHOR_XIAFENG
 */
package com.example.springbootdemo.design_pattern.builder;

/**
 * @author xia.feng@hand-china.com
 * @version 0.1
 * @date 2021-03-17 11:31
 * @description
 */
public class HighBuilding extends AbstractHouseBuilder {


    public HighBuilding(House house) {
        super(house);
    }

    @Override
    void buildBasic(House house) {
        house.setBase("HighBase");
        System.out.println("高楼打地基");
    }

    @Override
    void buildWalls(House house) {
        house.setWalls("HighWalls");
        System.out.println("高楼砌墙");
    }

    @Override
    void roofed(House house) {
        house.setRoof("HighRoof");
        System.out.println("高楼封顶");
    }
}
