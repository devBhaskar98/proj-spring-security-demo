package com.devProject.springsecuritydemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.devProject.springsecuritydemo.interceptor.LoggingServiceInterceptor;

@Configuration
public class LoggingServiceInterceptorConfig  implements WebMvcConfigurer  {
	
	@Autowired
    private LoggingServiceInterceptor logginServiceInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(logginServiceInterceptor);
    }
}
