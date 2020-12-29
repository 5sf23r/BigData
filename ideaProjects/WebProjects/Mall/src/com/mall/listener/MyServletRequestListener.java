package com.mall.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

import com.mall.domain.User;
import org.apache.log4j.Logger;

@WebListener
public class MyServletRequestListener implements ServletRequestListener {
    public static Logger logger = Logger.getLogger(MyServletRequestListener.class);
    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        //获取request对象
        HttpServletRequest request = (HttpServletRequest) servletRequestEvent.getServletRequest();
        //访问当前网站的用户是否登录
        //request.getSession(true) ： 如果存在sesison返回sesison，否则创建个一个新的session
        //request.getSession(false)：如果存在session返回session，否则返回null
        String username = "游客";
        if (request.getSession(false)!=null && request.getSession().getAttribute("user")!=null) {//如果存在sesison
            User user = (User) request.getSession().getAttribute("user");
            username = user.getUsername();
        }
        //获取用户IP地址
        String ip = request.getRemoteAddr();
        //获取用户请求的url
        String url =  request.getRequestURL().toString();
        logger.debug("用户【"+username +"】使用IP：【"+ip+"】请求url：【"+ url +"】发送请求结束");
    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        //获取request对象
        HttpServletRequest request = (HttpServletRequest) servletRequestEvent.getServletRequest();
        //访问当前网站的用户是否登录
        //request.getSession(true) ： 如果存在sesison返回sesison，否则创建个一个新的session
        //request.getSession(false)：如果存在session返回session，否则返回null
        String username = "游客";
        if (request.getSession(false)!=null && request.getSession().getAttribute("user")!=null) {//如果存在sesison
            User user = (User) request.getSession().getAttribute("user");
            username = user.getUsername();
        }
        //获取用户IP地址
        String ip = request.getRemoteAddr();
        //获取用户请求的url
        String url =  request.getRequestURL().toString();
        logger.debug("用户【"+username +"】使用IP：【"+ip+"】请求url：【"+ url +"】发送请求开始");
    }
}
