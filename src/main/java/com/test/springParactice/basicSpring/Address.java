package com.test.springParactice.basicSpring;


import lombok.ToString;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

@MyComponent
@ToString
//@Conditional(value = CustomConditional.class)
public class Address {

    private String road;
    private String house;

    public Address(String road, String house) {
        this.road = road;
        this.house = house;
    }

    public Address() {
    }



}

//class CustomConditional implements Condition{
//
//    @Override
//    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
//        Environment env = conditionContext.getEnvironment();
//
//        return (env.getProperty("address.road") != null && env.getProperty("address.house") != null);
//
//    }
//}