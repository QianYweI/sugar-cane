package com.wisely.highlight_springmvc4.web.ch4_5;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class UploadController {

    public static Logger logger = Logger.getLogger(UploadController.class);

    // 文件跟路径
    public static String FILE_ROOT_PATH = "G:/upload/";

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public @ResponseBody String upload(MultipartFile file) { //1、使用MultipartFile file接收上传的文件
        try {
            FileUtils.writeByteArrayToFile(new
                            File(FILE_ROOT_PATH + file.getOriginalFilename()),
                    file.getBytes()); // 2、使用FileUtils.writeByteArrayToFile快速写文件到磁盘
            return "ok";
        } catch (IOException e) {
            logger.error("图片上传失败:" + e.getMessage());
            e.printStackTrace();
            return "wrong";
        }
    }
}