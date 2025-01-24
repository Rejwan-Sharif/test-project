package com.test.ecommerce;

import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import org.springframework.web.filter.ShallowEtagHeaderFilter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebConfig implements WebMvcConfigurer {

    public ShallowEtagHeaderFilter shallowEtagHeaderFilter(){
        return new ShallowEtagHeaderFilter();
    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer contentNegotiationConfigurer){

        contentNegotiationConfigurer.favorParameter(true)
                .parameterName("media-type")
                .defaultContentType(MediaType.APPLICATION_JSON)
                .mediaType("xml",MediaType.APPLICATION_XML)
                .mediaType("json",MediaType.APPLICATION_JSON);

    }

    // DefaultCorsProcesssor
    //CorsFilter
    @Override
    public void addCorsMappings(CorsRegistry corsRegistry){
        corsRegistry.addMapping("/api/vi")
                .allowedOrigins("http://localhost:3000","http://localhost:4200")
                .allowedHeaders(HttpHeaders.CONTENT_TYPE,HttpHeaders.AUTHORIZATION)
                .maxAge(20)
                .allowedMethods("GET","POST");

        corsRegistry.addMapping("/api/v2")
                .allowedOrigins("http://localhost:3000","http://localhost:4200")
                .allowedHeaders(HttpHeaders.CONTENT_TYPE,HttpHeaders.AUTHORIZATION)
                .maxAge(20)
                .exposedHeaders("custom-header")
                .allowCredentials(true)
                .allowedMethods("POST");

    }




}
