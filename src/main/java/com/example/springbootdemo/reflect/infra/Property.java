package com.example.springbootdemo.reflect.infra;

import java.lang.annotation.*;


/**
 * @AUTHOR summer
 */

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Property {

    String name() default "";

    String value() default "";
}
