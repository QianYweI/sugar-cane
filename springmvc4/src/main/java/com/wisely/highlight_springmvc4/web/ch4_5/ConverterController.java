package com.wisely.highlight_springmvc4.web.ch4_5;

import com.wisely.highlight_springmvc4.domain.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ConverterController {

    /**
     * 指定返回的媒体类型为我们自定义的媒体类型application/x-wisely
     *
     * @param demoObj
     * @return
     */
    @RequestMapping(value = "/converter", produces = {"application/x-wisely"})
    public @ResponseBody DemoObj converter(@RequestBody DemoObj demoObj) {
        return demoObj;
    }

}