package com.test.TestingDummyClass;


import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class MathClass {

    public int sum( int a, int b, int c){
        int d = a+b+c;
        return d;
    }

    public int sum( int a, int b, int c, int v){
        int d = a+b+c;
        return d;
    }

}
