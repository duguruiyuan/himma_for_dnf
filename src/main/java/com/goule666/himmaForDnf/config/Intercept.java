package com.goule666.himmaForDnf.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author niewenlong
 * @Date: 2017/10/25 14:04
 * @Description: 拦截器链 可以由多个拦截器组合配置
 */
@Configuration
public class Intercept extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogPrintIntercept()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }


}
