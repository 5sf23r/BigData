package cn.tedu.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/response02")
public class Response02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.定义一个字符串
        String str = "我爱你中国";
        //2.使用响应流进行输出内容到 浏览器页面中
        //2.1 使用字节流响应
        //如果在获取字节流时没有设置编码格式，那么会默认使用平台的编码GBK
        //平台：操作系统的默认字符集：GBK
        //浏览器：默认的字符集：GBK
        //所以这一句话不会出现乱码
        //resp.getOutputStream().write(str.getBytes());
        //2.2 字节流设置utf-8
        // 浏览器默认默认字符集GBK
        // 响应流设置的字符集utf-8
        // 编码格式不匹配，会出现乱码
        //resp.getOutputStream().write(str.getBytes("utf-8"));
        //2.3 字节流设置utf-8
        //设置HTTP协议的响应头，告诉浏览器使用什么类型编码格式TFF-8进行解析
        //resp.setHeader("Content-Type","text/html;charset=utf-8");
        //服务器端的代码使用utf-8进行字节流获取
        //resp.getOutputStream().write(str.getBytes("utf-8"));


        //2.4 使用字符流响应
        //底层原理：字符流的底层依然是字节流
        //getWriter方法返回的是PrintWriter字符流
        //如果进行字符流输出时，没有设置字符流的编码格式，
        // 那么会默认使用 tomcat服务器的字符集：iso-8859-1
        //resp.getWriter().write(str);

        //2.5 字符流设置 响应实体的内容编码为utf-8
        //服务器端的字符流是utf-8格式的
        //但是浏览器的默认字符集GBK
        //所以该结果一定会出现 乱码
        //resp.setCharacterEncoding("utf-8");
        //resp.getWriter().write(str);

        //2.6 字符流完整的使用方法
        //服务端字符流的编码格式
        resp.setCharacterEncoding("utf-8");
        //通知浏览器使用utf-8的格式进行解析
        //这两句是等价的 ： resp.setHeader("Content-Type","text/html;charset=utf-8");
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write(str);
    }
}
