package com.sunny.blog.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author sunny
 * @className com.sunny.blog.config.RootContextConfig
 * @date 2018-01-29 12:37
 * @description:
 */
@Configuration
@ComponentScan(basePackages = {"com.sunny.blog"},
        excludeFilters  ={
       @ComponentScan.Filter(type= FilterType.ANNOTATION,value = EnableWebMvc.class)
})
public class RootContextConfig {
}
