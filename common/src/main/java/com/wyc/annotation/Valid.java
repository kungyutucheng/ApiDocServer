package com.wyc.annotation;

import java.lang.annotation.*;

/**
 * @author: wyc
 * @date: 2018/10/11
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Target(ElementType.PARAMETER)
public @interface Valid {

}
