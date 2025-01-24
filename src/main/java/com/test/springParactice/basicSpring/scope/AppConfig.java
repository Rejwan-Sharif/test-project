package com.test.springParactice.basicSpring.scope;

import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

//    @Bean
//    public CustomScopeConfigurer customScopeConfigurer(){
//        CustomScopeConfigurer scope = new CustomScopeConfigurer();
//        scope.addScope("timed", new TimedScope());
//        return scope;
//    }
}
