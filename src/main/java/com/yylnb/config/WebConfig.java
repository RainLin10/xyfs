package com.yylnb.config;

import com.yylnb.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author RainLin
 * @date 2019/11/24 - 18:48
 */
//拓展SpringMVC的功能
@Configuration
public class WebConfig implements WebMvcConfigurer {
    //拦截器必须手动示例bean，否则拦截器中无法自动注入其他类
    @Bean
    public LoginInterceptor loginInterceptor() {
        return new LoginInterceptor();
    }

    //需要拦截的路径，默认为全部
    String addPathPatterns[] = {
            "/"
    };

    //排除不需要拦截的路径
    String excludePathPatterns[] = {
             "/webjars/**"
    };

    //加载拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor())
                .addPathPatterns(addPathPatterns)
                .excludePathPatterns(excludePathPatterns);
    }

    //定义入口
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
    }
}
