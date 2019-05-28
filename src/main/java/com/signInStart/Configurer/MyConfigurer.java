package com.signInStart.Configurer;

import com.signInStart.Configurer.Interceptors.AccessInterceptor;
import com.signInStart.Configurer.Interceptors.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyConfigurer implements WebMvcConfigurer {
    //用来注册拦截器，写好的拦截器在这儿添加注册才能生效
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AccessInterceptor()).addPathPatterns("/**");
        registry.addInterceptor(new LoginInterceptor()).excludePathPatterns("/register/signup","/register/register","/register/logOut").addPathPatterns("/**");
    }

    //用来配置静态资源:html，js，css等
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

    }
}