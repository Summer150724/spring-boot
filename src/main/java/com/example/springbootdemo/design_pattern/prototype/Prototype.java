/**
 * 文件名：Prototype.java
 * 版权： Copyright 2019-2024 XIA.FENG All Rights Reserved.
 * 描述：AUTHOR_XIAFENG
 */
package com.example.springbootdemo.design_pattern.prototype;

import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.BeanDefinitionDsl;

import java.io.*;

/**
 * @author xia.feng@hand-china.com
 * @version 0.1
 * @date 2021-03-15 18:03
 * @description 原型模式
 * 用原型实例指定创建对象的种类,并且通过拷贝这些原型,创建新的对象
 */
@Configuration
@Data
public class Prototype implements Serializable,Cloneable{

    /**===============property==========**/
    private String className;
    private Prototype innerClass;

    /**
     * 原型模式,对象克隆
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * Spring中原型模式的运用:Bean创建
     */
    @Bean(name = "com.example.springbootdemo.design_pattern.prototype.Prototype")
    @Scope(value = "prototype")
    public Prototype getBean () {
        return new Prototype();
    }


    /**
     * 深拷贝&浅拷贝
     * clone()为浅拷贝,拷贝对象时如果含有引用类型,只拷贝引用类型的引用
     * 深拷贝实现:
     * 1.重写clone(),对引用类型进行单独处理-->繁琐
     * 2.实现序列化-->好使
     */
    public Object deepClone () {
        // 创建流对象
        ByteArrayOutputStream byteArrayOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        ByteArrayInputStream byteArrayInputStream = null;
        ObjectInputStream objectInputStream = null;

        try {
            // 序列化
            byteArrayOutputStream = new ByteArrayOutputStream();
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            // 把当前对象以对象流的方式输出
            objectOutputStream.writeObject(this);

            //反序列化
            byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            objectInputStream = new ObjectInputStream(byteArrayInputStream);
            Prototype copyObj = (Prototype)objectInputStream.readObject();
            return copyObj;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            // 关闭流
            try {
                byteArrayOutputStream.close();
                objectOutputStream.close();
                byteArrayInputStream.close();
                objectInputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}
