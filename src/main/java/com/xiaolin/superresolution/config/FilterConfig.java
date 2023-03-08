package com.xiaolin.superresolution.config;

import com.xiaolin.superresolution.filter.JwtTokenFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xlxing
 * 自定义Filter注册
 */
//@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<JwtTokenFilter> myFilter() {
        FilterRegistrationBean<JwtTokenFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new JwtTokenFilter());
        registrationBean.addUrlPatterns("/api/*");
        return registrationBean;
    }
}
