package com.test.aspect;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Aspect
@Service
public class AspectTest {


    // * = any type
    // .. = any type + any Args

    @Pointcut("execution(* sum(..))")
//    @Pointcut("within(com.test..)")
    public void logPointCut(){}

    @Before("logPointCut()")
    public void beforeLog(){
        System.out.println("This Pointcut Starting");
    }

    @After("logPointCut()")
    public void afterLog(){
        System.out.println("The pointcut ended");
    }

}
