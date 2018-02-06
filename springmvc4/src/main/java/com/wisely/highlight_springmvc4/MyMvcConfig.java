package com.wisely.highlight_springmvc4;

import com.wisely.highlight_springmvc4.interceptor.DemoInterceptor;
import com.wisely.highlight_springmvc4.messageconverter.MyMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.List;

@Configuration
@EnableWebMvc //1、开启SpringMVC支持，若无此句，重写WebMvcConfigurerAdapter方法无效
@ComponentScan("com.wisely.highlight_springmvc4")
public class MyMvcConfig extends WebMvcConfigurerAdapter { // 2、继承WebMvcConfigurerAdapter类，重写其方法可对Spring MVC进行配置

    /**
     * 此处无任何特别，只是一个普通的Spring配置类。这里我们配置一个JSP的ViewResolver，
     * 用来映射路径和实际页面的位置，其中，@EnableWebMvc注解会开启一些默认配置，如一些
     * ViewResolver或者MessageConverter等。
     * <p>
     * 特别解释一下Spring MVC的ViewResolver，这是Spring MVC视图渲染的核心机制；Spring MVC里有
     * 一个接口叫做ViewResolver（我们的ViewResolver都实现该接口），实现这个接口要重写方法resolveViewName()，
     * 这个方法的返回值是接口View，而View的职责就是使用model、request、response对象，并将渲染
     * 的视图（html、json、xml、pdf）返回给浏览器。
     * <p>
     * 路径前缀配置为 /WEB-INF/classes/views/ 。因为我们看到的页面效果是运行时而不是开发时的代码，
     * 运行时代码会将我们的页面自动编译到/WEB-INF/classes/views/下，
     */
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/classes/views/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);
        return viewResolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //3、addResourceLocations指的是文件放置的目录，addResourceHandler指的是对外暴露的访问路径。
        registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets/");
    }

    //配置拦截器Bean
    @Bean
    public DemoInterceptor demoInterceptor() {
        return new DemoInterceptor();
    }

    // 注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(demoInterceptor());
    }

    // Controller路径管理
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("/index");
        registry.addViewController("/toUpload").setViewName("/upload");
        registry.addViewController("/converter").setViewName("/converter");
    }

    // 路径匹配参数配置
    // 通过重写configurePathMatch方法可不忽略"."后面的参数
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setUseSuffixPatternMatch(false);
    }

    @Bean
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(1000000);
        return multipartResolver;
    }

    @Bean
    public MyMessageConverter converter(){
        return new MyMessageConverter();
    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(converter());
    }
}