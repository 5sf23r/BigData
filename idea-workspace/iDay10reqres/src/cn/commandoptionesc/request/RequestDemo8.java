package cn.commandoptionesc.request;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * 请求转发细节：
 *   请求转发前后的语句都会正常执行,并且按照请求转发的顺序执行
 *
 *   可以实现多重转发，不可以在一个servlet中多次请求转发
 */
public class RequestDemo8 extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("RequestDemo8 Start......");
        request.getRequestDispatcher("/servlet/RequestDemo9").forward(request,response);
        System.out.println("RequestDemo8 End......");
    }
}
