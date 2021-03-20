package com.example.springbootdemo.reflect.run;


import com.example.springbootdemo.reflect.domain.Person;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * description:
 *
 * @author: xia.feng@hand-china.com 2019/12/31 10:56
 **/
public class Test {

    public void function() {
        ExecutorService executorService =
                new ThreadPoolExecutor(2,
                        5,
                        3000L,
                        TimeUnit.SECONDS,
                        new LinkedBlockingDeque<Runnable>());


    }

    public static void main(String[] args) throws Exception {

        // 加载配置文件
        Properties properties = new Properties();
        ClassLoader classLoader = Person.class.getClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream("bean.properties");
        properties.load(resourceAsStream);
        //获取配置文件中定义的数据
        String className = properties.getProperty("className");
        String methodName = properties.getProperty("methodName");
        //加载类进内存
        Class cls = Class.forName(className);
        //创建对象
        Object obj = cls.newInstance();
        //获取方法对象
        Method method = cls.getMethod(methodName,Object.class);
        //执行方法
        method.invoke(obj,obj);


    }
}
