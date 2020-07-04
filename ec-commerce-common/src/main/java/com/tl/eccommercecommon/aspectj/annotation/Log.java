package com.tl.eccommercecommon.aspectj.annotation;

import java.lang.annotation.*;


@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Log {

    //方法名
    String name () default "";
}
