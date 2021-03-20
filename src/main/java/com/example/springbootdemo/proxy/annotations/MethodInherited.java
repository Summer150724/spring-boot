package com.example.springbootdemo.proxy.annotations;

import java.lang.annotation.*;

/**
 * @author xia.feng@hand-china.com
 * @version 0.1
 * @date 2021-03-04 19:09
 * @description
 */

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface MethodInherited {
    String name() default "";
}
