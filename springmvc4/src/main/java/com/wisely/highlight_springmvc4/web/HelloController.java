package com.wisely.highlight_springmvc4.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // 1
public class HelloController {

    @RequestMapping("/") // 2
    public String hello(){
        return "index"; // 3
    }

    /**
     * 1、利用@Controller注解声明是一个控制器。
     * 2、利用@RequestMapping配置URL和方法之间的映射。
     * 3、通过上面ViewResolver的Bean配置，返回值为index，
     *    说明我们的页面放置的路径为/WEB-INF/classes/views/index.jsp(前缀和后缀都在SpringMVC中已配置)
     */

}