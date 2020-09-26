package com.springboot.project.Util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


@Slf4j
@Component
public class TimeFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("初始化过滤器：{}", filterConfig.getFilterName());
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("start to doFilter");
        long startTime = System.currentTimeMillis();
        filterChain.doFilter(servletRequest, servletResponse);
        long endTime = System.currentTimeMillis();
        log.info("the request of {} consumes {}ms.", getUrlFrom(servletRequest), (endTime - startTime));
        log.info("end to doFilter");
    }

    @Override
    public void destroy() {
        log.info("销毁过滤器");
    }

    private String getUrlFrom(ServletRequest servletRequest){
        if (servletRequest instanceof HttpServletRequest){
            return ((HttpServletRequest) servletRequest).getRequestURL().toString();
        }

        return "";
    }
}
