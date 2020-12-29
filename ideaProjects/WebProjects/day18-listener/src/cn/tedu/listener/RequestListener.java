package cn.tedu.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener()
public class RequestListener implements ServletRequestListener {

    //request域销毁触发
    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {

        System.out.println("request请求结束.." +servletRequestEvent.getServletRequest());
    }
    //request域初始化触发
    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        System.out.println("request请求开始.." +servletRequestEvent.getServletRequest());
    }
}
