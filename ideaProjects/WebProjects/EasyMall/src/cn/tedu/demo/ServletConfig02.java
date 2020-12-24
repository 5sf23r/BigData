package cn.tedu.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*initParams 对应着配置文件所有的<init-param>标签*/
/*@WebInitParam 对应着其中一个<init-param>*/
/*name 对应着<param-name>标签*/
/*value 对应着<param-value>标签*/
@WebServlet(value = "/ServletConfig02",initParams = {
        @WebInitParam(name="encoding",value="utf-8"),
        @WebInitParam(name="key3",value="value3")
})
public class ServletConfig02 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
