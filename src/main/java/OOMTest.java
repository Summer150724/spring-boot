/**
 * 文件名：OOMTest.java
 * 版权： Copyright 2019-2024 XIA.FENG All Rights Reserved.
 * 描述：AUTHOR_XIAFENG
 */

import okhttp3.*;
import org.apache.commons.collections.CollectionUtils;

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
    private static final ThreadLocal<Collection<Long>> variables = new ThreadLocal<>();

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



/*        while (true) {
            Scanner in = new Scanner(System.in);
            int input = in.nextInt();
            System.out.println(input/200);
        }*/

// 测试++i和i++
/*        for (int i = 0; i < 10; i++) {
            int we = i++ * 10;
            System.out.println("we:"+we);
        }

        for (int i = 0; i < 10; i++) {
            int ew = ++i * 10;
            System.out.println("ew:"+ew);
        }*/


        long i  = 1<<2;
        System.out.println(i);

        List<Integer> list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        list.add(11);
        list.add(12);
        list.add(13);
        Collection<Long> collection = variables.get();
        if (CollectionUtils.isEmpty(collection)) {
            collection = new HashSet<>();
            for (Integer id : list) {
                collection.add(Long.valueOf(String.valueOf(id)));
            }
        }

    }

}
