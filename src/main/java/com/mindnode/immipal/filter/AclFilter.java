package com.mindnode.immipal.filter;


import org.apache.commons.httpclient.HttpStatus;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author liweiy
 * @date 2017/11/20 14:38
 * @description 类说明：跨域
 */
@WebFilter(filterName = "aclFilter", urlPatterns = "/*")
public class AclFilter implements Filter {

    private static final String REQUEST_METHOD_OPTIONS = "OPTIONS";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        response.setHeader("Access-Control-Allow-Origin", "*");
        // 响应类型
        response.setHeader("Access-Control-Allow-Methods", "POST, GET");
        // 响应头设置
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, x-requested-with, X-Custom-Header, Authorization");
        if (REQUEST_METHOD_OPTIONS.equals(request.getMethod())) {
            response.setStatus(HttpStatus.SC_NO_CONTENT);
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}