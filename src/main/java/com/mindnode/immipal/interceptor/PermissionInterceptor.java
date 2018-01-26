package com.mindnode.immipal.interceptor;

import com.mindnode.immipal.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author SQM
 * @version 1.0
 * @date 2018/1/26
 */
public class PermissionInterceptor implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        User loginUser = (User) httpServletRequest.getSession().getAttribute("user");
        if (loginUser != null) {
            return true;
        } else {
            httpServletRequest.getRequestDispatcher("/admin_login_page").forward(httpServletRequest, httpServletResponse);
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
