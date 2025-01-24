package com.test.designPettern.proxyPattern;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;

public interface Product {


    int getProduct(int[] arr);
}
