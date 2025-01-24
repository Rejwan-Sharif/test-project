package com.test.aspect;



import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Retry {

    Class<? extends Throwable>exception() default RuntimeException.class;
    int attemptsTime() default 1;
    long intervalTimes() default 3000;

}
