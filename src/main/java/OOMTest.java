/**
 * 文件名：OOMTest.java
 * 版权： Copyright 2019-2024 XIA.FENG All Rights Reserved.
 * 描述：AUTHOR_XIAFENG
 */

import okhttp3.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author xia.feng@hand-china.com
 * @version 0.1
 * @date 2021-04-27 14:51
 * @description
 */
public class OOMTest {

    public static void main(String[] args) throws IOException {

/*
        List<Byte[]> list = new ArrayList<>();
        int i = 0;
        try {
            while (true) {
                list.add(new Byte[1024 * 1024]);
                i++;
            }

        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println("执行了"+i+"次");
        }
*/

    List<String> strings = new ArrayList<>();
   strings.add("0");
    strings.add("hello");
        String s = strings.stream().filter(Objects::nonNull).max(String::compareTo).orElse(null);
        System.out.println(s);

    }

}
