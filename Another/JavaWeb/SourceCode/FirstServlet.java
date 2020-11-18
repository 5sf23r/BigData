package cn.commandoptionesc.servlet;
import javax.servlet.*;
import java.io.*;

public class FirstServlet extends GenericServlet{
    public void service(ServletRequest req,ServletResponse res) throws ServletException,java.io.IOException{
        res.getWriter().write("HelloFirstServlet");
    }
}
