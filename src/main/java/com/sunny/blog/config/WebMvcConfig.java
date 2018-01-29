package com.sunny.blog.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * @author sunny
 * @className WebMvcConfig
 * @date 2018-01-29 13:28
 * @description:
 */
@Configuration
@EnableAsync
// 启用spring mvc xml代码<mvc:annotation-driven/>
@EnableWebMvc
//启用组件扫描
@ComponentScan("com.sunny.blog.controller")
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    final static Logger LOGGER = LoggerFactory.getLogger(WebMvcConfig.class);

    /**
     * jsp 视图解析器
     *
     * @return
     */
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setViewClass(JstlView.class);
        resolver.setSuffix(".jsp");
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setExposeContextBeansAsAttributes(true);
        return resolver;
    }

    /**
     * 定义文件上传的处理器
     *
     * @return
     */
//    @Bean("multipartResolver")
//    public CommonsMultipartResolver commonsMultipartResolver() {
//        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
//        multipartResolver.setMaxUploadSize(10 * 1024 * 1024);
//        return multipartResolver;
//    }

    /**
     * 配置静态资源处理
     * 要求 DispatcherServlet 对静态资源的请求转发到servlet 容器中，
     *
     * @param configurer
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {

        configurer.enable();
    }
}
