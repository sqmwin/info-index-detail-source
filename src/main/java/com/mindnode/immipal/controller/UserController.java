package com.mindnode.immipal.controller;

import com.mindnode.immipal.exception.user.ChangePasswordException;
import com.mindnode.immipal.exception.user.WrongUserInformationException;
import com.mindnode.immipal.pojo.User;
import com.mindnode.immipal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @author SQM
 * @version 1.0
 * @date 2018/1/26
 */
@Controller
@RequestMapping("/admin")
public class UserController {
    @Autowired
    UserService userService;

    /**
     * loginAdmin
     * <p>   后台登录
     *
     * @param username 要登陆的用户名
     * @param password 要登陆的用户密码
     * @return java.lang.String  登陆成功则转发到后台管理主页，失败则退回登陆页
     */
    @RequestMapping(value = "/admin_user_login",method = RequestMethod.POST)
    public String loginAdmin(@RequestParam("username")String username,
                             @RequestParam("password")String password,
                             HttpSession session,
                             Model model) {
        try {
            userService.login(username, password);
        } catch (WrongUserInformationException e) {
            model.addAttribute("message", e.getMessage());
            return "/fore/loginPage";
        }
        User userInDataBase = userService.getByUsername(username);
        session.setAttribute("user", userInDataBase);

        return "admin/home";
    }

    /**退出登陆*/
    @RequestMapping(value = "/admin_user_logout", method = RequestMethod.GET)
    public String logout(HttpSession session, Model model) {
        model.addAttribute("message", "已退出");
        session.invalidate();
        return "fore/loginPage";
    }

    /**修改密码*/
    @RequestMapping(value = "/admin_user_change_password", method = RequestMethod.POST)
    public String edit(HttpSession session, @RequestParam("password") String password, @RequestParam("ensure") String ensure, Model model) {
        User user = (User) session.getAttribute("user");
        if (user != null) {
            try {
                userService.updatePassword(user.getUserId(), password, ensure);
                model.addAttribute("message", "修改成功");
            } catch (ChangePasswordException e) {
                model.addAttribute("message", e.getMessage());
            }
        }
        return "admin/changePasswordPage";
    }
}
