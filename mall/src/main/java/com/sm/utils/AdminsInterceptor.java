package com.sm.utils;

        import org.springframework.web.servlet.ModelAndView;
        import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;

public class AdminsInterceptor extends HandlerInterceptorAdapter {

    public AdminsInterceptor() {
        super();
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri =request.getRequestURI();
        if(uri.contains("css") ||uri.contains("js")|| uri.contains("login") ||uri.contains("img") || uri.contains("loginOut") || uri.contains("index.html")){
            return true;
        }
        Object admin=request.getSession().getAttribute("admin");
        if(admin!=null){
            return true;
        }
        response.sendRedirect("/admin/login.jsp");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }

    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        super.afterConcurrentHandlingStarted(request, response, handler);
    }
}
