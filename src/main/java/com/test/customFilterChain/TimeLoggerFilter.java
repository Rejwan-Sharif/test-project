package com.test.customFilterChain;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;


public class TimeLoggerFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        Long st = System.currentTimeMillis();
        filterChain.doFilter(httpServletRequest,httpServletResponse);
        Long et = System.currentTimeMillis();
        System.out.println("Total Time Consumed : "+(et-st)+" Millisecond");
    }
}
