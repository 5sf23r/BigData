package cn.tedu.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


@WebListener()
public class SessionListener implements HttpSessionListener {

    //创建session域时触发
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        System.out.println("session已经创建..." +httpSessionEvent.getSession().getId());
    }
    //销毁session域时触发
    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        System.out.println("session已经销毁..." +httpSessionEvent.getSession().getId());

    }
}
