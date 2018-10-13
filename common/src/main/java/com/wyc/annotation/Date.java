package com.wyc.annotation;

import java.lang.annotation.*;

/**
 * @author: wyc
 * @date: 2018/10/12
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Date {

    String[] between() default {};

    String biggerThan() default "";

    String lessThan() default "";

    String biggerAndEqualThan() default "";

    String lessAndEqualThan() default "";

    String equal() default "";

    String format() default "";


}
