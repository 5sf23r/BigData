package cn.commandoptionesc.sconfig;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import java.io.IOException;
//ServletConfig 可以获取servlet中的初始化配置信息

public class SConfigDemo1 extends javax.servlet.http.HttpServlet {
    ServletConfig config = null;
    //1. 获取ServletConfig对象
    //获取方式：通过init方法
    @Override
    public void init(ServletConfig config) throws ServletException {
        //如果config对象需要被doGet方法使用
        //则应该将config对象提取成一个成员变量
        //将局部变量的config赋值到全局变量身上
        this.config = config;
        //super.init(config);
    }
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //从当前servlet身上获取指定名称的初始化配置信息
        String username = config.getInitParameter("username");
        System.out.println("username:"+username);
    }
}
