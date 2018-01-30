package com.mindnode.immipal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 后台登录
 *
 * @author SQM
 * @version 1.0
 * @date 2018/1/26
 */
@Controller
@RequestMapping("")
public class LoginController {

    /**
     * <p>   后台管理登陆页
     *
     * @return 后台管理登陆页
     */
    @RequestMapping(value = "/admin_login_page", method = RequestMethod.GET)
    public String loginPage() {
        return "fore/loginPage";
    }

}
