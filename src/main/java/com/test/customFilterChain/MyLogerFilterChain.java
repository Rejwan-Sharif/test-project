package com.test.customFilterChain;



import javax.servlet.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class MyLogerFilterChain implements FilterChain {

    private final List<Filter> filters = Arrays.asList(
            new IPLoggerFilter(),
            new ThreadSecurityFilter(),
            new TimeLoggerFilter(),
            new MyLoggerFilter()
    );

    private final FilterChain filterChain;
    int currentPosition = 0;

    public MyLogerFilterChain(FilterChain filterChain) {
        this.filterChain = filterChain;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse) throws IOException, ServletException {

        if (currentPosition == filters.size()){
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            currentPosition++;
            filters.get(currentPosition).doFilter(servletRequest,servletResponse,this.filterChain);
        }

    }
}
