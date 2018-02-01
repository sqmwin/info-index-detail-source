package com.mindnode.immipal.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mindnode.immipal.exception.user.ChangePasswordException;
import com.mindnode.immipal.exception.user.UserException;
import com.mindnode.immipal.exception.user.WrongUserInformationException;
import com.mindnode.immipal.pojo.User;
import com.mindnode.immipal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author SQM
 * @version 1.0
 * @date 2018/1/26
 */
@Controller
@RequestMapping("/admin/user")
public class UserController {
    private static int PAGE_SIZE = 10;
    private static String REDIRECT_USER_LIST = "redirect:/admin/user/admin_user_list";
    @Autowired
    UserService userService;
    
    /**
     * loginAdmin <p>   后台登录
     *
     * @param user
     *         要登陆的用户数据
     * @return java.lang.String  登陆成功则转发到后台管理主页，失败则退回登陆页
     */
    @RequestMapping(value = "/admin_user_login", method = RequestMethod.POST)
    public String loginAdmin(User user,
                             HttpSession session,
                             Model model) {
        try {
            userService.login(user);
        } catch (WrongUserInformationException e) {
            model.addAttribute("message", e.getMessage());
            return "fore/loginPage";
        }
        User userInDataBase = userService.getByUsername(user.getUserUsername());
        
        if (userInDataBase != null) {
            session.setAttribute("user", userInDataBase);
        }
        return "redirect:/admin/admin_home";
    }
    
    /**
     * 退出登陆
     */
    @RequestMapping(value = "/admin_user_logout", method = RequestMethod.GET)
    public String logout(HttpSession session, Model model) {
        model.addAttribute("message", "已退出");
        session.invalidate();
        return "fore/loginPage";
    }
    
    /**
     * 修改密码页面
     */
    @RequestMapping(value = "/admin_user_change_password_page", method = RequestMethod.GET)
    public String editPage() {
        return "admin/edit/changePasswordPage";
    }
    
    /**
     * 修改密码
     */
    @RequestMapping(value = "/admin_user_change_password", method = RequestMethod.POST)
    public String edit(HttpSession session, String password, String ensure, Model model) {
        User user = (User) session.getAttribute("user");
        if (user != null) {
            try {
                userService.updatePassword(user.getUserId(), password, ensure);
                model.addAttribute("message", "修改成功");
            } catch (ChangePasswordException e) {
                model.addAttribute("message", e.getMessage());
                return "admin/edit/changePasswordPage";
            }
        }
        return "redirect:/admin/admin_home";
    }
    
    /**
     * 管理除admin外的其他用户 显示用户名，用户权限 权限：1。超级管理员 2。只能修改新闻
     */
    @RequestMapping(value = "/admin_user_list", method = RequestMethod.GET)
    public String listUser(Integer pageNum, Model model) {
        if (pageNum == null) {
            PageHelper.startPage(1, PAGE_SIZE);
        }
        else {
            PageHelper.startPage(pageNum, PAGE_SIZE);
        }
        List<User> userList = userService.listExceptAdmin();
        
        model.addAttribute("userList", userList);
        
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        model.addAttribute("pageInfo", pageInfo);
        return "admin/listUser";
    }
    
    /**
     * 新增后台管理用户页面
     */
    @RequestMapping(value = "/admin_user_add_page", method = RequestMethod.GET)
    public String addUserPage() {
        return "admin/add/addUser";
    }
    
    /**
     * 新增后台管理用户
     */
    @RequestMapping(value = "/admin_user_add", method = RequestMethod.POST)
    public String addUser(User user, String password, String ensure, Model model) {
        try {
            userService.add(user, password, ensure);
        } catch (UserException e) {
            model.addAttribute("message", e.getMessage());
            return "admin/add/addUser";
        }
        return REDIRECT_USER_LIST;
    }
    
    /**
     * 编辑用户等级
     */
    @RequestMapping(value = "/admin_user_edit_level", method = RequestMethod.GET)
    public String editUserLevel(Integer userId, Integer userLevel) {
        User user = userService.get(userId);
        user.setUserLevel(userLevel);
        userService.update(user);
        return REDIRECT_USER_LIST;
    }
}
