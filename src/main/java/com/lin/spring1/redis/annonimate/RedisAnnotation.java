package com.lin.spring1.redis.annonimate;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RedisAnnotation {

    String value();

    boolean justOnce() default false;

    long expires() default -1;
}
