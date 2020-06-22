package com.ddup.zheye.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/common")
@Slf4j
public class CommonController {

    @RequestMapping(value = "/say", method = RequestMethod.GET)
    public String helloWorld(String name){
        return name + " say: Hello World!";
    }



}
