package com.mindnode.immipal.controller;

import com.alibaba.fastjson.JSON;
import com.mindnode.immipal.pojo.Pic;
import com.mindnode.immipal.service.PicService;
import com.mindnode.immipal.util.upload.FileUpLoad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

/**
 * @author SQM
 * @version 1.0
 * @date 2018/1/28
 */
@Controller
@RequestMapping("/file")
public class UploadController {
    @Autowired
    PicService picService;
    /**
     * 富文本编辑器上传图片
     */
    @RequestMapping(value = "/upload_pic",method = RequestMethod.POST)
    public String uploadPic(HttpSession session, @RequestParam("file") MultipartFile file) {
        String http = "http://127.0.0.1:8080";
        String serverPath = null;
        //上传图片
        try {
                serverPath = FileUpLoad.uploadPic(session, file);

                Pic pic = new Pic();
                pic.setPicUrl(serverPath);
                picService.add(pic);

        } catch (Exception e) {
            return JSON.toJSONString(e.getMessage());
        }

        return http + serverPath;
    }


}
