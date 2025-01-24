package com.test.filterAndInterceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Slf4j
public class  FilterLogInfo extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

        long startTime = System.nanoTime();
        filterChain.doFilter(httpServletRequest,httpServletResponse);
        long endTime = System.nanoTime();

        log.info("Request from ip {}, Total Time Consumed {}, Used Thread Of {}",httpServletRequest.getRemoteAddr(),(startTime-endTime),Thread.currentThread().getName());
    }
}
