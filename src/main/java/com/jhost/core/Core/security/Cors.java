package com.jhost.core.Core.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Cors implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        WebMvcConfigurer.super.addCorsMappings(registry);
        registry.addMapping("/**")
                .allowedMethods("GET", "POST", "DELETE", "PATCH", "OPTIONS", "PUT")
                .exposedHeaders("Authorization")
                .allowedOrigins("*")
                .allowedHeaders("*");
    }
}
