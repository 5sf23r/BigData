package cn.commandoptionesc.request;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RequestDemo9 extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("RequestDemo9 Start......");
        //response.getWriter().write("I am Demo 9");
        //再次转发，将RequestDemo9转发到RequestDemo10
        //实现多重转发
        request.getRequestDispatcher("/servlet/RequestDemo10").forward(request,response);
        System.out.println("RequestDemo9 End......");
    }
}
