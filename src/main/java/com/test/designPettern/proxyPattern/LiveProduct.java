package com.test.designPettern.proxyPattern;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Configuration
public class LiveProduct implements Product{

    @Override
    public int getProduct(int arr []) {

        int sum = 0;
        for ( int arrs : arr ){
            sum +=arrs;
        }
        return sum;
    }
}
