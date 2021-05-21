/**
 * 文件名：OOMTest.java
 * 版权： Copyright 2019-2024 XIA.FENG All Rights Reserved.
 * 描述：AUTHOR_XIAFENG
 */

import okhttp3.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author xia.feng@hand-china.com
 * @version 0.1
 * @date 2021-04-27 14:51
 * @description
 */
public class OOMTest {

    public static void main(String[] args) throws IOException {

        System.out.println(BigDecimal.ZERO.compareTo(new BigDecimal(-1)));
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




    }

}
