package com.test.customFilterChain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfiguration {


    @Bean
    public FilterRegistrationBean<MyLoggerFilter> myLoggerFilter(){
        FilterRegistrationBean<MyLoggerFilter> newFilter = new FilterRegistrationBean<>();
        newFilter.setFilter(new MyLoggerFilter());
//        newFilter.addUrlPatterns("/api");
        return newFilter;
    }




}
