/**
 * 文件名：AbstractHouse.java
 * 版权： Copyright 2019-2024 XIA.FENG All Rights Reserved.
 * 描述：AUTHOR_XIAFENG
 */
package com.example.springbootdemo.design_pattern.builder;

import lombok.Data;

/**
 * @author xia.feng@hand-china.com
 * @version 0.1
 * @date 2021-03-17 11:28
 * @description
 */
@Data
public abstract class AbstractHouseBuilder {

    protected House house;


    public AbstractHouseBuilder(House house){
        this.house = house;
    }


    abstract void buildBasic (House house);

    abstract void buildWalls (House house);

    abstract void roofed (House house);

    public void build(House house){
        buildBasic(house);
        buildWalls(house);
        roofed(house);
    }

    public House buildHouse(){
        return this.house;
    }
}
