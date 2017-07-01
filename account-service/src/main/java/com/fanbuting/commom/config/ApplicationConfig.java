package com.fanbuting.commom.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.fanbuting.commom.interceptor.ActionInterceptor;

@Component
public class ApplicationConfig extends WebMvcConfigurerAdapter 
{
 
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    // 多个拦截器组成一个拦截器链
    // addPathPatterns 用于添加拦截规则
    // excludePathPatterns 用户排除拦截
    registry.addInterceptor(new ActionInterceptor()).addPathPatterns("/**");
    super.addInterceptors(registry);
  }
}
