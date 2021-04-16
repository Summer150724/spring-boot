package com.example.springbootdemo.thread.run;


import com.example.springbootdemo.thread.CustomThreadFactory;
import com.example.springbootdemo.thread.MyThread;
import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
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

/*        // 加载配置文件
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
        method.invoke(obj,obj);*/


        /*double random = Math.random();
        System.out.println(String.valueOf(random*10000000));

        BigDecimal var1 = new BigDecimal(6000);
        BigDecimal var2 =BigDecimal.valueOf(1L).add(new BigDecimal(16.0).divide(BigDecimal.valueOf(100L)));
        System.out.println(var2);
        BigDecimal var3 =new BigDecimal(16.0).divide(BigDecimal.valueOf(100L));
        System.out.println(var3);
        BigDecimal result = var1.multiply(var3).divide(var2,2, BigDecimal.ROUND_HALF_UP);
        System.out.println(""+result);
        List<String> a = new ArrayList<>();
        a.add("abc");
        a.add("def");
        List<String> b = new ArrayList<>();
        b.add("abc");
        b.add("def");
        boolean f;
        f = a.containsAll(b);
        f=a.retainAll(b);
        System.out.println(f);

        System.nanoTime();


        a = a.stream().filter(e -> e.equals("abc")).collect(Collectors.toList());

        System.out.println(a);
*/


/*        //公司标签
        List<Map<String, String>> companyTagList = new ArrayList<>();
        //标签列表
        List<Map<String, String>> tagList = new ArrayList<>();
        //公司变迁标签
        List<Map<String, String>> changedComTagList = new ArrayList<>();
        //非公司标签
        List<Map<String, String>> othersTagList = new ArrayList<>();

        //获取公司标签中的所有tagName的值
        List<String> companyTagNames = companyTagList.stream().map(item -> item.get("tagName")).collect(Collectors.toList());
        //获取标签列表中的所有tagName的值
        List<String> tagListTagNames = tagList.stream().map(item -> item.get("tagName")).collect(Collectors.toList());
        //取出交集->公司变迁标签
        List<String> changedTagNames = tagListTagNames.stream().filter(item -> companyTagNames.contains(item)).collect(Collectors.toList());
        //剩余标签->非公司标签
        List<String> othersTagNames = tagListTagNames.stream().filter(item -> !companyTagNames.contains(item)).collect(Collectors.toList());
        //根据标签名 去  标签列表  获取标签对象放进对应list
        tagList.stream().forEach(item -> {
            if (changedTagNames.contains(item.get("tagName"))) {
                changedComTagList.add(item);
            } else if (othersTagNames.contains(item.get("tagName"))) {
                othersTagList.add(item);
            }
        });

        System.out.println(changedComTagList);
        System.out.println(othersTagList);

        List<String> stringList = new ArrayList<>(16);
        stringList.add("aaa");
        stringList.add("aaa");
        stringList.add("aaa");
        stringList.add("aaa");
        stringList.add("bbb");
        stringList.add("ccc");
        List<String> collect = stringList.stream().distinct().collect(Collectors.toList());
        System.out.println(collect);*/

/*        try{
            Thread.sleep(100000000);
        }catch (Exception e){
            e.printStackTrace();
        }*/

        Thread thread = new Thread(new MyThread());
        thread.start();

/*      //阿里规约标准代码

        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("demo-pool-%d").build();
        ExecutorService singleThreadPool = new ThreadPoolExecutor(1, 1,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

        singleThreadPool.execute(() -> System.out.println(Thread.currentThread().getName()));
        singleThreadPool.shutdown();*/


        /// 线程工厂 其实就是一个可复用的new Thread,把Thread newThread封装成接口,但怎么实现呢.
        // google Guava包下的threadFactory构建方法

        ThreadFactory threadFactoryBuilder = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();
        ///预定义线程工厂
        ThreadFactory threadFactory = Executors.defaultThreadFactory();

        /// 自定义线程工厂
        ThreadFactory myThreadFactory = new CustomThreadFactory("my-pool");

        ///预定义线程池
        ExecutorService defaultFixThreadPool = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 5; i++) {
            defaultFixThreadPool.execute(() -> {
                System.out.println(Thread.currentThread().getName());
            });
        }

        Executors.newCachedThreadPool();
        Executors.newSingleThreadExecutor();

        /**
         * 自定义线程池的实现,管理线程与调度
         */
        ExecutorService executorService = new ThreadPoolExecutor(
                //核心线程数
                4,
                //最大线程数
                4,
                //线程空闲时间,对核心线程不生效
                6L,
                //时间单位
                TimeUnit.SECONDS,
                //队列 有界阻塞队列
                new LinkedBlockingQueue<Runnable>(1024),
                //线程工厂
                threadFactory,
                //拒绝策略
                /**
                 * AbortPolicy：默认测策略，抛出RejectedExecutionException运行时异常；
                 * CallerRunsPolicy：这提供了一个简单的反馈控制机制，可以减慢提交新任务的速度；
                 * DiscardPolicy：直接丢弃新提交的任务；
                 * DiscardOldestPolicy：如果执行器没有关闭，队列头的任务将会被丢弃，然后执行器重新尝试执行任务（如果失败，则重复这一过程）；
                 * 我们可以自己定义RejectedExecutionHandler，以适应特殊的容量和队列策略场景中。
                 */
                new ThreadPoolExecutor.AbortPolicy()
        );

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                4,
                4,
                60L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(),
                myThreadFactory,
                new ThreadPoolExecutor.AbortPolicy()
        );

        // 维护两个重要的资源：第一，线程（Thread）；第二，任务（task）。
        // 第一，优化性能，ThreadPoolExecutor采用线程池的方式实现，可以线程线程的数量，减少线程上下文的切换和计算资源的耗尽。此外，ThreadPoolExecutor的线程池可以重复利用线程，减少资源浪费，提升性能。
        // 第二，线程和资源的管理，ThreadPoolExecutor维护众多的属性，比如：已完成任务的数量、活跃的线程数量、任务拒绝策略、超时时间等等。
        ExecutorService singleThreadPool = new ThreadPoolExecutor(
                0,
                Integer.MAX_VALUE,
                60L,
                TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>(),
                threadFactoryBuilder,
                new ThreadPoolExecutor.AbortPolicy());

        singleThreadPool.execute(() -> {
            synchronized (Thread.currentThread()) {
///                System.out.println(Thread.currentThread().getName() + "---------------");
            }
        });


        threadPoolExecutor.execute(() -> {
            System.out.println(Thread.currentThread().getName());
        });

        executorService.execute(() -> {
            // 线程的run方法
            System.out.println(Thread.currentThread().getName());
        });
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                // 没有语法糖其实就是这个样子
                System.out.println(Thread.currentThread().getName());
            }
        });
        executorService.execute(new MyThread());

        singleThreadPool.shutdown();

        System.out.println("--------------------");


        Map<String, Object> map = new LinkedHashMap<>();
        map.put("k1", 2L);
        map.put("k2", 2);
        map.put("k3", "hello");


        System.out.println(LocalDateTime.now());


        System.out.println("ALIYUN".hashCode());


        List<String> stringList = new ArrayList<>(16);
        stringList.add("aaa");
        stringList.add("aaa");
        stringList.add("aaa");
        stringList.add("aaa");
        stringList.add("bbb");
        stringList.add("ccc");
        long count = stringList.stream().filter(item -> item.equals("aaa")).count();
        System.out.println("count:" + count);


    }

}
