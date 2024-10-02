package com.test.springParactice.basicSpring.applicationEventPublisher;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserEventController {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;


    @GetMapping("/home")
    @ResponseBody
    public String login(){
        System.out.println("Login Success");
        applicationEventPublisher.publishEvent(new UserLoginEvent());
        return "Hello World";
    }

}

