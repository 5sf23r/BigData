package com.easymall.filter;


import com.easymall.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLDecoder;

public class AutoLoginFilter implements Filter {
    private UserService userService = null;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        ServletContext sc = filterConfig.getServletContext();
        ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(sc);
        this.userService = context.getBean(UserService.class);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();
        //1. 是否未登录
        if (session.getAttribute("user")==null){
            //2. 是否带了自动登录cookie
            Cookie[] cs = req.getCookies();
            Cookie findC = null;
            if(cs != null){
                for(Cookie c : cs){
                    if("autologin".equals(c.getName())){
                        findC = c;
                        break;
                    }
                }
            }
            if(findC != null) {
                //3. 自动登录cookie中保存的用户名密码是否正确
                String username = URLDecoder.decode(findC.getValue().split("#")[0]);
                String password = findC.getValue().split("#")[1];
            }
        }

        //4. 以上三个条件都成立，完成自动登录
        //5. 无论是否自动登录都要放行资源
        chain.doFilter(request,response


        );
    }

    @Override
    public void destroy() {

    }
}
