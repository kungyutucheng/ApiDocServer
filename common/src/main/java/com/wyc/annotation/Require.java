package com.wyc.annotation;

import java.lang.annotation.*;

/**
 * @author: wyc
 * @date: 2018/10/11
 */
@Target(ElementType.FIELD)
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Require {

    String message() default "";
}
