package com.test.customInterceptor;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Slf4j

public class SimpleInterceptorImpl implements HandlerInterceptor {

    @Autowired
    private RequestRepo requestRepo;

    private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

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
      if (modelAndView != null){
          request.setAttribute("page_name",modelAndView.getViewName());
      }
       HandlerInterceptor.super.preHandle(request, response, handler);
    }

   public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
       long st = (long) request.getAttribute("time");
       long et = System.currentTimeMillis();
        String time = format.format(new Date(st));

       InfoDto infoDto = new InfoDto();
       infoDto.setIp(request.getRemoteAddr());
       infoDto.setPath(request.getRequestURI());
       infoDto.setMethod(request.getMethod());
       infoDto.setTime(time);
       infoDto.setPageName(String.valueOf(request.getAttribute("page-name")));
       infoDto.setThread(Thread.currentThread().getName());
       infoDto.setConsumedTime(Long.valueOf(String.valueOf(et-st)));
       requestRepo.addRequestTracker(infoDto);
//       log.info("ip - {}",infoDto);
//       log.info("time {}",time);
        HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
