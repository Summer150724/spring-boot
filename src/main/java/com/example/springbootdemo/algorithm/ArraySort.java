/**
 * 文件名：ArraySort.java
 * 版权： Copyright 2019-2024 XIA.FENG All Rights Reserved.
 * 描述：AUTHOR_XIAFENG
 */
package com.example.springbootdemo.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xia.feng@hand-china.com
 * @version 0.1
 * @date 2021-03-08 15:08
 * @description
 */
public class ArraySort {


    /**
     * 在大小为 2N 的数组 A 中有 N+1 个不同的元素，其中有一个元素重复了 N 次。
     * 返回重复了 N 次的那个元素。
     */
    public int repeatedNTimes (int [] array) {
        int length = array.length;
        int n = length / 2;

        return 1;
    }


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        List<Integer> list1 = list.subList(0, 5);
        System.out.println(list1);
    }
}
