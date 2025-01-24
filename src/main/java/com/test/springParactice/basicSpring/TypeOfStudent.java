package com.test.springParactice.basicSpring;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


@Configuration
public class TypeOfStudent {

    @Bean
    @Type(resultType = ResultType.GOOD)
    public String types(){
        return "Good";
    }


    @Bean
    @Type(resultType = ResultType.BETTER)
    public String type1(){
        return "Better";
    }

    @Bean
    @Type(resultType = ResultType.BEST)
    public String type3(){
        return "Best";
    }

}
