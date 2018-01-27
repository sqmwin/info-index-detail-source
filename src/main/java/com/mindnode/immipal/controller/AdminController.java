package com.mindnode.immipal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author SQM
 * @version 1.0
 * @date 2018/1/26
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    /**用户登录后的后台主页*/
    @RequestMapping(value = "/admin_home", method = RequestMethod.GET)
    public String adminHomePage() {
        return "admin/home";
    }
}
