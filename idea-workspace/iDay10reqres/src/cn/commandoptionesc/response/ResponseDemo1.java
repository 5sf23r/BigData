package cn.commandoptionesc.response;

        import javax.servlet.ServletException;
        import javax.servlet.http.HttpServlet;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import java.io.IOException;

/**
 * 响应参数乱码处理
 * getOutputStream()
 * getWriter()
 */
public class ResponseDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //通知服务器使用utf-8字符集
        response.setCharacterEncoding("utf-8");
        //通知浏览器使用utf-8字符集接收数据
        response.setHeader("Content-Type","text/html;charset=utf-8");
        response.getWriter().write("中文");
    }
}