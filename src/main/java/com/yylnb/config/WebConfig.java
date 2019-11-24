package com.yylnb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author RainLin
 * @date 2019/11/24 - 18:48
 */
//拓展SpringMVC的功能
@Configuration
public class WebConfig implements WebMvcConfigurer {
    //定义入口
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index.html").setViewName("index");
    }
}
