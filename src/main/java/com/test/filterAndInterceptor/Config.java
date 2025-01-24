package com.test.filterAndInterceptor;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Order(Integer.MIN_VALUE)
@EnableScheduling
@Component
public class Config   extends OncePerRequestFilter/* implements Filter */{

    private final ConcurrentHashMap<String, AtomicInteger> map =new ConcurrentHashMap<>();
    private static  final int MAX_REQ = 5;
    Map<String,String> message = new HashMap<>();
      
    @Scheduled(fixedDelay =10_000)
    public void cleanUp(){
        if (!map.isEmpty()){
            map.clear();
        }
    }

//    @Override
//    public void doFilterInternal(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//
////       HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
//
//        String ip = servletRequest.getRemoteAddr();
//        AtomicInteger count = map.computeIfAbsent(ip, k-> new AtomicInteger());
//
//        if (count.getAndIncrement() > MAX_REQ){
//            HttpServletResponse response = (HttpServletResponse) servletResponse;
//            response.setStatus(HttpStatus.TOO_MANY_REQUESTS.value());
//            response.setContentType("application/json");
//            response.getWriter().write(
//                    Objects.requireNonNull(message.put("Message", "I know you are Hacker Bro "))
//            );
//            return;
//        }
//        filterChain.doFilter(servletRequest,servletResponse);
//    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String ip = httpServletRequest.getRemoteAddr();
        AtomicInteger count = map.computeIfAbsent(ip, k-> new AtomicInteger());
        if (count.getAndIncrement() > MAX_REQ){
//            HttpServletResponse response = (HttpServletResponse) servletResponse;
            httpServletResponse.setStatus(HttpStatus.TOO_MANY_REQUESTS.value());
            httpServletResponse.setContentType("application/json");
            httpServletResponse.getWriter().write(
                    Objects.requireNonNull(message.put("Message", "I know you are Hacker Bro "))
            );
            return;
        }
        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }
}

