package com.wyc.annotation;

import java.lang.annotation.*;

/**
 * @author: wyc
 * @date: 2018/10/11
 */

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Target(ElementType.FIELD)
public @interface Range {

    String message() default "";

    int[] intValue() default {};

    String[] stringValue() default {};

    double[] doubleValue() default {};

    float[] floatValue() default {};

}
