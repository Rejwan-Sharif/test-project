package com.test.customInterceptor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("/api/v1/home")
    public String getTemplate(){
        return "Api Data";
    }
}
