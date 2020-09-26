package com.springboot.project.Util;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class WebConfig {

    @Bean
    public FilterRegistrationBean URLFilter(){
        TimeFilter timeFilter=new TimeFilter();
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean() ;

        filterRegistrationBean.setFilter(timeFilter);
        List<String> urls = new ArrayList<>();
        // 匹配所有请求路径
        urls.add("/*");
        filterRegistrationBean.setUrlPatterns(urls);

        return filterRegistrationBean;
    }
}
