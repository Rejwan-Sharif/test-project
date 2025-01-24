package com.test.customInterceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@Slf4j
public class SimpleInterceptorImpl implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        long time =  System.currentTimeMillis();
                request.setAttribute("time",time);
        if (request.getRemoteAddr().equals("192.168.0.101")){
            response.getWriter().println("Access Denied");
            response.getWriter().flush();
        }

        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

   public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
       HandlerInterceptor.super.preHandle(request, response, handler);
    }

   public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
       long time = (long) request.getAttribute("time");
       log.info("time {}",time);
        HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
