package com.test.customInterceptor;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@AllArgsConstructor
public class InterceptorConfig implements WebMvcConfigurer {

    private final SimpleInterceptorImpl simpleInterceptor;


    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(simpleInterceptor).order(1).addPathPatterns("/**");
    }

}
