/**
 * 文件名：Application.java
 * 版权： Copyright 2019-2024 XIA.FENG All Rights Reserved.
 * 描述：AUTHOR_XIAFENG
 */
package com.example.springbootdemo.design_pattern.builder;

/**
 * @author xia.feng@hand-china.com
 * @version 0.1
 * @date 2021-03-17 11:36
 * @description 建造者模式
 */
public class Application {

    public static void main(String[] args) {
        House originHouse = new House();
        AbstractHouseBuilder abstractHouse = new NormalHouse(originHouse);

        House house = new Director(abstractHouse).constructHouse(originHouse);
        House highBuilding = new Director(new HighBuilding(originHouse)).constructHouse(originHouse);
        System.out.println(house);
        System.out.println(highBuilding);

        StringBuilder stringBuilder = new StringBuilder("helloA");
        System.out.println(stringBuilder.toString());
    }
}
