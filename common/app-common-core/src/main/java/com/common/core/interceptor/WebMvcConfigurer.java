package com.common.core.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.Resource;
import java.util.List;


/**
 * @author 袁毅雄
 * @description 描述:拦截器配置
 * @date 2019/6/11
 */
@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {


    @Resource
    private List<AbstractInterceptor> interceptorList;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        interceptorList.forEach(e -> {
            registry.addInterceptor(e).addPathPatterns(e.interceptorPath());
        });

        super.addInterceptors(registry);
    }
}