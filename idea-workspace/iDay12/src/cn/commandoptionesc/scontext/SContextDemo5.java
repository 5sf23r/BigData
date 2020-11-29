package cn.commandoptionesc.scontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
//路径问题
public class SContextDemo5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //相对路径
        //String path = "config.properties";
        //绝对路径(不推荐使用)
        //String path = "D:\\......";
        ServletContext sc = this.getServletContext();
        String path = sc.getRealPath("WEB-INF/web.xml");
        File file = new File(path);
        System.out.println(file.getAbsolutePath());
    }
}
