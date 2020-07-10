package com.zheye.ddup.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Api(tags = {"公共接口"})
@RestController
@RequestMapping(value = "/common")
@SuppressWarnings(value = "unchecked")
public class CommonController {

    @ApiOperation(value = "打招呼", notes = "叫一下名字")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "名字", dataType = "string", required = true, paramType = "query", example = "ace"),
            @ApiImplicitParam(name = "age", value = "年龄", dataType = "integer", required = true, paramType = "query", example = "20")
    })
    @RequestMapping(value = "/greet", method = RequestMethod.GET)
    public String greet(String name, Integer age) {
        log.info("param name : {}, age: {}", name, age);
        if (StringUtils.isEmpty(name)){
            throw new IllegalArgumentException("name can not be null !");
        }
        if (age < 18){
            return "少儿不宜！！";
        }
        return "Hello, my name is " + name + " !";
    }
}
