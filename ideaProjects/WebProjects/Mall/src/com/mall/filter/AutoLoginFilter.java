package com.mall.filter;

import com.mall.domain.User;
import com.mall.service.UserService;
import com.mall.utils.MD5Utils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URLDecoder;

@WebFilter(filterName = "AutoLoginFilter",value = "/*")
public class AutoLoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //获取请求中的所有的cookie
        HttpServletRequest request = (HttpServletRequest) req;
        Cookie[] cookies = request.getCookies();
        Cookie autologin=null;
        //判断是否有登录状态
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {//没有登录的状态下
            if (cookies!=null ) {
                for (Cookie cookie:cookies){
                    if ("autologin".equals(cookie.getName())) {
                        autologin = cookie;
                    }
                }
            }
            if (autologin!=null) {
                String value = URLDecoder.decode(autologin.getValue(), "utf-8");
                String[] array = value.split("#");
                String username = array[0];
                String password = array[1];
                UserService userService = new UserService();
                User loginuser = userService.login(username, password);
                request.getSession().setAttribute("user", loginuser);
            }
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
