package com.test.customFilterChain;

import org.apache.catalina.core.ApplicationFilterChain;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public class MyLoggerFilter extends OncePerRequestFilter {
 @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("--------logger --------");
       MyLogerFilterChain logerFilterChain = new MyLogerFilterChain(filterChain);
       logerFilterChain.doFilter(httpServletRequest,httpServletResponse);

    }
}
