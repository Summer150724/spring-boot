package com.example.springbootdemo;

import com.alibaba.fastjson.JSONObject;
import com.example.springbootdemo.design_pattern.prototype.Prototype;
import com.example.springbootdemo.rest.domain.entity.Test;
import com.example.springbootdemo.rest.domain.repository.TestRepository;
import com.example.springbootdemo.proxy.MyProxy;
import com.example.springbootdemo.proxy.ProxyTarget;
import com.example.springbootdemo.proxy.ProxyTargetChild;
import com.example.springbootdemo.rocket_mq.app.impl.ProducerServiceImpl;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.List;

//@MapperScan(basePackages = {"com.example.springbootdemo.rest.infra.mapper"})
@EnableAsync
@SpringBootApplication
public class SpringBootDemoApplication {

    public static void main(String[] args) throws Exception{
        Logger logger = LoggerFactory.getLogger(SpringBootDemoApplication.class);
        ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringBootDemoApplication.class, args);
        Thread.currentThread().setName("MainThread");
        System.out.println(applicationContext.getBeanDefinitionNames());
        for (int i = 0; i < applicationContext.getBeanDefinitionNames().length; i++) {
            System.out.println("第"+i+"个bean:"+ applicationContext.getBeanDefinitionNames()[i]);
        }
        // TODO: 设计模式
        Prototype prototype = (Prototype)applicationContext.getBean("com.example.springbootdemo.design_pattern.prototype.Prototype");
        Prototype prototype1 = (Prototype)applicationContext.getBean("com.example.springbootdemo.design_pattern.prototype.Prototype");
        // 指定Scope=prototype 则为多例(原型模式), 指定Scope = singleton 则为单例, Scope默认单例

        logger.debug("单例/多例模式测试:{}", prototype == prototype1);
        ConfigurableListableBeanFactory beanFactory = applicationContext.getBeanFactory();
        // 原型模式
        /// 深拷贝
        prototype1.setClassName("prototype1");
        prototype1.setInnerClass(null);
        prototype.setClassName("prototype");
        prototype.setInnerClass(prototype1);
        Object clone1 = prototype.clone();
        Object clone2 = prototype.clone();
        Object clone3 = prototype.deepClone();
        Object clone4 = prototype.deepClone();
        System.out.println("浅拷贝:" + (clone1 == clone2));
        System.out.println("深拷贝:" + (clone3 == clone4));



        // TODO: 动态代理
        MyProxy myProxy = new MyProxy();
        ProxyTarget proxyTarget = new ProxyTarget();

        proxyTarget.invoke();

        // 生成父代理类
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(ProxyTarget.class);
        enhancer.setCallback(myProxy);
        ProxyTarget proxy = (ProxyTarget) enhancer.create();
        proxy.invoke();

        // 生成子代理类
        Enhancer childEnhancer = new Enhancer();
        childEnhancer.setSuperclass(ProxyTargetChild.class);
        childEnhancer.setCallback(myProxy);
        ProxyTargetChild proxyTargetChild = (ProxyTargetChild) childEnhancer.create();
        proxyTargetChild.invoke();


        // 父代理类调用
        ProxyTarget proxyTarget1 = (ProxyTarget) beanFactory.getBean("ProxyTarget");
        proxyTarget1.invoke();

        ProxyTargetChild  po= (ProxyTargetChild) beanFactory.getBean("ProxyTargetChild");
        po.invoke();
        po.invokeSync();

        // Mybatis测试
        TestRepository testRepository = (TestRepository)applicationContext.getBean("TestRepository");
        List<Test> all = testRepository.getAll();
        List<Test> select = testRepository.select();
        System.out.println(select);
        System.out.println(all);

        // RocketMQ 测试
        ProducerServiceImpl producerService = applicationContext.getBean(ProducerServiceImpl.class);
        producerService.sendMsg("RocketMQTestMessage");


    }



}
