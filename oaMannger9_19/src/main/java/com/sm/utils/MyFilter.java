package com.sm.utils;

import com.sm.bean.Employee;

import javax.imageio.spi.ServiceRegistry;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileFilter;
import java.io.IOException;

public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response= (HttpServletResponse) servletResponse;

        String uri=request.getRequestURI();
        String path="/login.jsp,/employee/login.do";
        if(!path.contains(uri)){
            Employee emp = (Employee) request.getSession().getAttribute("emp");
            if(emp==null){
                response.sendRedirect("/login.jsp");
                filterChain.doFilter(request,response);
            }
        }
        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
