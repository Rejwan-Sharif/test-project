package com.test.springParactice.basicSpring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SingeltoneBean {

    @Autowired
    private ApplicationContext  context;


    public void execute(){
         PrototypeBean prototypeBean = context.getBean(PrototypeBean.class);
        System.out.println(prototypeBean);
    }

//    @Override
//    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        this.context = applicationContext;
//    }
}
