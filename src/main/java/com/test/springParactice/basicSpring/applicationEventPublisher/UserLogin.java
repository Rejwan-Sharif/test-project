package com.test.springParactice.basicSpring.applicationEventPublisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;

import java.sql.SQLOutput;
import java.util.Date;


@Configuration
public  class UserLogin {



    @Async
    @EventListener
    public  void userLogin(UserLoginEvent event){
        System.out.println("Succesfully logged in");
    }

    @Async("threadPoolTaskExecutor")
    @EventListener
    public void loginTime(UserLoginEvent event){
        System.out.println(Thread.currentThread().getName());
        System.out.println("login time is "+new Date().toString());
    }

    @Async
    @EventListener
    public void welcomeMsg(UserLoginEvent event){
        System.out.println(Thread.currentThread().getName());
        System.out.println("Welcome to my app");
    }

    @Async("threadPoolTaskExecutor")
    @EventListener
    public void choosePayMoney(UserLoginEvent event) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        Thread.sleep(10000);
        System.out.println("Money Payed $5 USD");
    }
}
