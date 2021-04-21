package com.example.springbootdemo;

import com.example.springbootdemo.spring.extension.BeanPostProcessorExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

// Mapper加@Mapper注解就不需要再手动扫描了
//@MapperScan(basePackages = {"com.example.springbootdemo.rest.infra.mapper"})
//过滤redis&rocketMQ相关bean,本地没起服务
@ComponentScan(
        // basePackages = {"com.example.springbootdemo"},
        excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX, pattern = {"com.example.springbootdemo.rocket_mq.*", "com.example.springbootdemo.redis.*"}))
@EnableAsync
@SpringBootApplication
public class SpringBootDemoApplication {

    public static void main(String[] args) throws Exception{
        Logger logger = LoggerFactory.getLogger(SpringBootDemoApplication.class);
        Thread.currentThread().setName("夏丰多帅哦");

        // 容器初始化前
        SpringApplication springApplication = new SpringApplication(SpringBootDemoApplication.class);
        // springApplication.addInitializers(new ApplicationContextInitializerExtension());
        ConfigurableApplicationContext applicationContext = springApplication.run(args);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        List<String> asList = Arrays.asList(beanDefinitionNames);
        Set<String> collect = asList.stream().collect(Collectors.toSet());
        collect.removeAll(BeanPostProcessorExtension.beansSet.get());
        List<String> stringList = collect.stream().collect(Collectors.toList());
        for (int i = 0; i < stringList.size(); i++) {
            logger.info("第"+i+"个beanPostProcessor未拦截到的bean:"+ stringList.get(i));
        }
    }



}
