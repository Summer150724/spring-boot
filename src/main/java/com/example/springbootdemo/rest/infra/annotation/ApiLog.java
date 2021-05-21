package com.example.springbootdemo.rest.infra.annotation;

import java.lang.annotation.*;

/**
 * @author xia.feng@hand-china.com
 * @version 0.1
 * @date 2021-04-26 11:29
 * @description
 */

// 类和方法的 Annotation 在缺省情况下是不出现在 javadoc 中的。
// 如果使用 @Documented 修饰该 Annotation，则表示它可以出现在 javadoc 中。
//定义 Annotation 时，@Documented 可有可无；若没有定义，则 Annotation 不会出现在 javadoc 中。
@Documented
// 指定 Annotation 的类型属性。
// 定义 Annotation 时，@Target 可有可无。若有 @Target，则该 Annotation 只能用于它所指定的地方；若没有 @Target，则该 Annotation 可以用于任何地方。
@Target(ElementType.METHOD)
// 指定 Annotation 的策略属性。
// 若没有 @Retention，则默认是 RetentionPolicy.CLASS。
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiLog {

    String param() default "";

    String level() default "debug";


}
