package com.example.springbootdemo.reflect.domain;


import com.example.springbootdemo.reflect.infra.Property;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author xia.feng@hand-china.com
 * @version 0.1
 * @date 2020-03-16 12:32
 * @description
 */
public class Person {

    public Object newInstance(Object arg) throws Exception {
        Class<?> argClass = arg.getClass();
        Constructor<?> constructor = argClass.getConstructor(String.class, String.class);
        Object newInstance = constructor.newInstance("夏丰", "男");
        System.out.println(newInstance.toString());
        return newInstance;
    }

    /**
     * 回写property值
     *
     * @param arg
     */
    public void process(Object arg) {

        Class<Person> personClass = Person.class;
        Field[] fields = personClass.getDeclaredFields();
        Method[] declaredMethods = personClass.getDeclaredMethods();
        //忽略权限修饰符的安全检查-->暴力反射
        for (Field field : fields) {
            field.setAccessible(true);
            //获取注解的值
            Property propertyData = field.getDeclaredAnnotation(Property.class);
            try {
                if (field.get(arg) == null) {
                    if (field.getType().equals(Long.class)) {
                        field.set(arg, Long.valueOf(1));
                    } else {
                        field.set(arg, "" + field.getName() + "--" + propertyData.name());
                    }
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }
        for (Field f : fields) {
            f.setAccessible(true);
            try {
                System.out.println(f.get(arg));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }
    }

    @Property(name = "序列号")
    private Long id;


    @Property(name = "姓名")
    private String name;

    @Property(name = "性别")
    private String sex;

    @Property(name = "地址")
    private String address;

    @Property(name = "电话")
    private String phone;

    public Person() {

    }

    public Person(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
