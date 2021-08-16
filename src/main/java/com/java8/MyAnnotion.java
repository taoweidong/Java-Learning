package com.java8;

import static java.lang.annotation.ElementType.*;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解
 * 
 * @author taowd
 * @version 2019年4月27日
 * @see MyAnnotion
 */
@Repeatable(MyAnnotions.class)
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotion {

    String value() default "Hello Annotion";
}
