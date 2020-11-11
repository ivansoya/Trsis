package com.soya.trsis.carselling.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class Controllers extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/cars").setViewName("cars");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/forbidden").setViewName("forbidden");
        registry.addViewController("/error").setViewName("error");
    }

}