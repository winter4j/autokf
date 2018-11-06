package com.songxd.autokf.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Command {

    String value();

    String exchange(); //rabbit交换机
}
