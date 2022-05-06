package com.example.demoapi.config;

import com.example.demoapi.interceptor.DemoInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class DemoConfig implements WebMvcConfigurer {

    @Value("${demo.interceptor.enabled}")
    private boolean interceptorEnabled;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new DemoInterceptor(interceptorEnabled)).addPathPatterns("/api/demo*/**");
    }
}
