package com.llds.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

@WebFilter(urlPatterns = "/*")  //拦截所有请求
public class DemoFilter implements Filter {

    @Override  // 初始化方法
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        System.out.println("init");
    }

    @Override  //拦截方法
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        System.out.println("拦截！！！！");
        //放行
        chain.doFilter(request,response);
    }

    @Override  // 销毁方法
    public void destroy() {
        Filter.super.destroy();
        System.out.println("销毁方法");
    }











}
