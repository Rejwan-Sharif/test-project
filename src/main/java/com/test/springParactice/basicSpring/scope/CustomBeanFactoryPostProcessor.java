package com.test.springParactice.basicSpring.scope;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;


//@Component
//public class CustomBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
//
//
//    @Override
//    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
//        beanFactory.registerScope("timed", new TimedScope());
//    }
//}
