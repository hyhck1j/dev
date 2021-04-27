package com.example.demo.fifter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2018/3/26.
 */

@WebFilter(filterName = "TestFilter", urlPatterns = {"/*"})
public class DemoFilter implements Filter {

    private static String[] alowPath = {"/login", "/error"};

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String referer = request.getHeader("Referer");
        String path = request.getRequestURI().substring(request.getContextPath().length()).replaceAll("[/]+$", "");
        System.out.println(path);
        if (getaut(path) || referer != null) {
            filterChain.doFilter(request, response);
        } else if (referer == null) {
            response.sendRedirect("/error");
        }
    }

    @Override
    public void destroy() {

    }

    public boolean getaut(String path) {
        for (String spath : alowPath) {
            if (spath.equals(path)) {
                return true;
            }
        }
        return false;
    }

}
